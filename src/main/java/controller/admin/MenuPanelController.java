package controller.admin;

import model.dao.impl.DishDAOImpl;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class MenuPanelController extends AdminAbstractController implements ActionListener, ModalListener {

    private final MenuPanel menuPanel;
    private final DishDAOImpl dishDAO;
    private DefaultTableModel tableModel;
    List<Dish> cachedDishes = new ArrayList<>();

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

        // Table header configuration
        tableModel = (DefaultTableModel) menuPanel.dishesTable.getModel();
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(null);
        renderer.setForeground(new Color(176, 176, 176));
        renderer.setBackground(new Color(21, 22, 26));
        menuPanel.dishesTable.getTableHeader().setDefaultRenderer(renderer);
        menuPanel.dishesTable.getTableHeader().setPreferredSize(new Dimension(0, 50));

//        loadDishes();
    }

    private void loadDishes() {
        DecimalFormat decimalFormat = new DecimalFormat("S/00.00");
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
    }

    @Override
    public void onEditDishModalClose() {

    }

    @Override
    public void onClientInfoModalClose() {

    }

    @Override
    public void onDishActionModalClose() {

    }
}
