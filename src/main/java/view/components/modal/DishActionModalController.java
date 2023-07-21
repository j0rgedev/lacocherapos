package view.components.modal;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import model.dao.impl.DishDAOImpl;
import model.entity.Dish;
import model.enums.Category;
import model.enums.DishAction;
import view.listeners.ModalListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DishActionModalController extends ModalController{

    private DishActionPanel dishActionPanel;
    private DishAction dishAction;
    private Dish dish;

    public DishActionModalController(CustomModal customModal, JFrame jFrame, ModalListener modalListener, DishAction dishAction) {
        super(customModal, jFrame, modalListener);
        this.dishAction = dishAction;
    }

    public DishActionModalController(CustomModal customModal, JFrame jFrame, ModalListener modalListener, DishAction dishAction, Dish dish) {
        super(customModal, jFrame, modalListener);
        this.dishAction = dishAction;
        this.dish = dish;
    }
    @Override
    public void showModal() {
        dishActionPanel = new DishActionPanel();
        init();
        setupModal(dishActionPanel, "icons/edit.svg");
    }

    private void init() {
        switch(dishAction) {
            case ADD -> dishActionPanel.lbTitle.setText("Agregando nuevo plato");
            case EDIT -> {
                dishActionPanel.lbTitle.setText("Editando plato "+dish.getName());
                customModal.btnEdit.setText("EDITAR");
                dishActionPanel.txtName.setText(dish.getName());
                dishActionPanel.txtPrice.setText(String.valueOf(dish.getPrice()));
                Category category = Category.getCategoryById(dish.getCategory_id());
                dishActionPanel.cbCategories.setSelectedItem(category.getName());
            }
        }
    }

    @Override
    protected void handleCustomModalAction(ActionEvent e) {
        if(e.getSource() == customModal.btnCancel){
            closeMessage();
        }
        if(e.getSource()==customModal.btnEdit && dishAction==DishAction.ADD){
            String name = dishActionPanel.txtName.getText();
            String price = dishActionPanel.txtPrice.getText();
            int categoryIndex = dishActionPanel.cbCategories.getSelectedIndex();
            if(name.isEmpty() || price.isEmpty() || categoryIndex == -1){
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, rellene todos los campos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        new FlatSVGIcon("icons/error.svg",20,20)
                );
            }else{
                customModal.btnEdit.setEnabled(false);
                String categoryName = Objects.requireNonNull(dishActionPanel.cbCategories.getSelectedItem()).toString();
                Category category = Category.getCategoryByName(categoryName);
                DishDAOImpl dishDAO = new DishDAOImpl();
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Timer timer = new Timer(500, new ActionListener() {
                    private int dotsCount = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dotsCount = (dotsCount + 1) % 4;
                        customModal.btnEdit.setText("GUARDANDO" + ".".repeat(Math.max(0, dotsCount)));
                    }
                });
                timer.start();
                executorService.execute(() -> {
                    dishDAO.createDish(new Dish("", name, Double.parseDouble(price) ,category.getId()));

                    SwingUtilities.invokeLater(() -> {
                        timer.stop();
                        customModal.btnEdit.setText("GUARDAR");
                        customModal.btnEdit.setEnabled(true);
                        JOptionPane.showMessageDialog(
                                null,
                                "Plato agregado correctamente",
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE,
                                new FlatSVGIcon("icons/success.svg",20,20)
                        );
                        closeMessage();
                    });
                });
            }
        }
    }
}
