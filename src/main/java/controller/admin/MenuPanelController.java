package controller.admin;

import model.dao.impl.DishDAOImpl;
import model.entity.CartDish;
import model.entity.Dish;
import model.enums.Category;
import model.enums.DishAction;
import view.admin.AdminIntranetFrame;
import view.admin.MenuPanel;
import view.components.modal.CustomModal;
import view.components.modal.DishActionModalController;
import view.listeners.ModalListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class MenuPanelController extends AdminAbstractController implements ActionListener, ModalListener {

    private final MenuPanel menuPanel;
    private final DishDAOImpl dishDAO;
    private DefaultTableModel tableModel;
    private Dish selectedDish;
    private List<Dish> cachedDishes = new ArrayList<>();
    private final DecimalFormat decimalFormat = new DecimalFormat("S/00.00");

    public MenuPanelController(AdminIntranetFrame adminIntranetFrm, MenuPanel menuPanel) {
        super(adminIntranetFrm);
        this.menuPanel = menuPanel;
        this.dishDAO = new DishDAOImpl();
    }

    @Override
    public void init() {
        // Listeners
        menuPanel.btnAdd.addActionListener(this);
        menuPanel.btnEdit.addActionListener(this);
        menuPanel.btnDelete.addActionListener(this);

        // Disable buttons
        menuPanel.btnEdit.setEnabled(false);
        menuPanel.btnDelete.setEnabled(false);

        // Table header configuration
        tableModel = (DefaultTableModel) menuPanel.dishesTable.getModel();
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(null);
        renderer.setForeground(new Color(176, 176, 176));
        renderer.setBackground(new Color(21, 22, 26));
        menuPanel.dishesTable.getTableHeader().setDefaultRenderer(renderer);
        menuPanel.dishesTable.getTableHeader().setPreferredSize(new Dimension(0, 50));

        // Some methods
        loadDishes();
        tableListener();
    }

    private void loadDishes() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Timer timer = new Timer(10, e -> {
            // Aquí actualizamos la barra de progreso y mostramos el porcentaje
            int progress = menuPanel.spinnerProgress.getValue();
            if (progress < 100) {
                progress++;
                menuPanel.spinnerProgress.setValue(progress);
                menuPanel.spinnerProgress.setString(progress + "%");
            }
        });

        timer.start(); // Iniciamos el temporizador

        executorService.submit(() -> {
            cachedDishes = dishDAO.getAllDishes();

            changePanel(menuPanel.jScrollPane1);
            tableModel.setRowCount(0);
            for (Dish dish : cachedDishes) {
                Category category = Category.getCategoryById(dish.getCategory_id());
                tableModel.addRow(new Object[]{
                        dish.getName(),
                        category.getName(),
                        decimalFormat.format(dish.getPrice()),
                });
            }

            timer.stop();
            menuPanel.spinnerProgress.setValue(100);
            menuPanel.spinnerProgress.setString("100%");
        });

        executorService.shutdown();
    }

    private void tableListener(){
        menuPanel.dishesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = menuPanel.dishesTable.rowAtPoint(evt.getPoint());
                int col = menuPanel.dishesTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    menuPanel.btnEdit.setEnabled(true);
                    menuPanel.btnDelete.setEnabled(true);
                    selectedDish = getSelectedDish(row);
                }
            }
        });
    }

    private Dish getSelectedDish(int selectedRow) {
        return cachedDishes.get(selectedRow);
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Dish dish : cachedDishes) {
            Category category = Category.getCategoryById(dish.getCategory_id());
            tableModel.addRow(new Object[]{
                    dish.getName(),
                    category.getName(),
                    decimalFormat.format(dish.getPrice()),
            });
        }
    }

    private void changePanel(Component panel){
        CardLayout cardLayout = (CardLayout) menuPanel.mainPanel.getLayout();
        cardLayout.show(menuPanel.mainPanel, panel.getName());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuPanel.btnAdd){
            DishActionModalController dishActionModalController = new DishActionModalController(
                    new CustomModal(),
                    adminIntranetFrm,
                    MenuPanelController.this,
                    DishAction.ADD
            );
            dishActionModalController.showModal();
        }
        if(e.getSource() == menuPanel.btnEdit){
            DishActionModalController dishActionModalController = new DishActionModalController(
                    new CustomModal(),
                    adminIntranetFrm,
                    MenuPanelController.this,
                    DishAction.EDIT,
                    selectedDish
            );
            dishActionModalController.showModal();
        }
        if(e.getSource()== menuPanel.btnDelete){
            DishActionModalController dishActionModalController = new DishActionModalController(
                    new CustomModal(),
                    adminIntranetFrm,
                    MenuPanelController.this,
                    DishAction.DELETE,
                    selectedDish
            );
            dishActionModalController.showModal();
        }
    }

    @Override
    public void onEditDishModalClose() {

    }

    @Override
    public void onClientInfoModalClose() {

    }

    @Override
    public void onDishActionModalClose(Dish dish, DishAction dishAction) {
        switch (dishAction){
            case ADD -> {
                cachedDishes.add(0, dish);
                updateTable();
                menuPanel.dishesTable.getSelectionModel().setSelectionInterval(0, 0);
                Rectangle rectangle = menuPanel.dishesTable.getCellRect(0, 0, true);
                menuPanel.dishesTable.scrollRectToVisible(rectangle);
                menuPanel.btnEdit.setEnabled(false);
                menuPanel.btnDelete.setEnabled(false);
            }
            case EDIT -> {
                for (int i = 0; i < cachedDishes.size(); i++) {
                    if(Objects.equals(cachedDishes.get(i).getId(), dish.getId())){
                        cachedDishes.set(i, dish);
                        updateTable();
                        break;
                    }
                }
                menuPanel.btnEdit.setEnabled(false);
                menuPanel.btnDelete.setEnabled(false);
            }
            case DELETE -> {
                for (int i = 0; i < cachedDishes.size(); i++) {
                    if(Objects.equals(cachedDishes.get(i).getId(), dish.getId())){
                        cachedDishes.remove(i);
                        updateTable();
                        break;
                    }
                }
                menuPanel.btnEdit.setEnabled(false);
                menuPanel.btnDelete.setEnabled(false);
            }
        }
    }
}
