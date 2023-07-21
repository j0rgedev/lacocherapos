package view.components.modal;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import model.dao.impl.DishDAOImpl;
import model.entity.Dish;
import model.enums.Category;
import model.enums.DishAction;
import view.listeners.ModalListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DishActionModalController extends ModalController {

    private DishActionPanel dishActionPanel;
    private DeleteWarningPanel deleteDishModal;
    private final DishAction dishAction;
    private Dish dish;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Timer timer;

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
        deleteDishModal = new DeleteWarningPanel();
        init();
        if(dishAction==DishAction.DELETE) setupModal(deleteDishModal, "icons/trash.svg");
        else setupModal(dishActionPanel, "icons/edit.svg");
    }

    private void init() {
        switch (dishAction) {
            case ADD -> {
                dishActionPanel.lbTitle.setText("Agregando nuevo plato");
                customModal.btnEdit.setText("AGREGAR");
            }
            case EDIT -> {
                dishActionPanel.lbTitle.setText("Editando plato " + dish.getId());
                customModal.btnEdit.setText("EDITAR");
                dishActionPanel.txtName.setText(dish.getName());
                dishActionPanel.txtPrice.setText(String.valueOf(dish.getPrice()));
                Category category = Category.getCategoryById(dish.getCategory_id());
                dishActionPanel.cbCategories.setSelectedItem(category.getName());
            }
            case DELETE -> {
                deleteDishModal.lbTitle.setText("Eliminando plato " + dish.getId());
                deleteDishModal.lblWarning.setText(
                        "<html>" +
                            "<body style=\"text-align:center\">" +
                                "¿Estas seguro que deseas eliminar al plato <b>" + dish.getName() + "</b>?" +
                            "</body>" +
                        "</html>"
                );
                customModal.btnEdit.setText("ELIMINAR");
                customModal.btnEdit.setBackground(new Color(255, 66, 66));
            }
        }
    }

    private void buttonWait(String text) {
        timer = new Timer(500, new ActionListener() {
            private int dotsCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                dotsCount = (dotsCount + 1) % 4;
                customModal.btnEdit.setText(text + ".".repeat(Math.max(0, dotsCount)));
            }
        });
        timer.start();
    }

    @Override
    protected void handleCustomModalAction(ActionEvent e) {
        if (e.getSource() == customModal.btnCancel) {
            closeMessage();
        }
        if (e.getSource() == customModal.btnEdit && dishAction == DishAction.ADD) {
            String name = dishActionPanel.txtName.getText();
            String price = dishActionPanel.txtPrice.getText();
            int categoryIndex = dishActionPanel.cbCategories.getSelectedIndex();
            if (name.isEmpty() || price.isEmpty() || categoryIndex == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, rellene todos los campos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        new FlatSVGIcon("icons/error.svg", 20, 20)
                );
            } else {
                try {
                    customModal.btnEdit.setEnabled(false);
                    String categoryName = Objects.requireNonNull(dishActionPanel.cbCategories.getSelectedItem()).toString();
                    Category category = Category.getCategoryByName(categoryName);
                    DishDAOImpl dishDAO = new DishDAOImpl();
                    buttonWait("AGREGANDO");
                    executorService.execute(() -> {
                        Dish newDish = new Dish("", name, Double.parseDouble(price), category.getId());
                        dishDAO.createDish(newDish);

                        SwingUtilities.invokeLater(() -> {
                            timer.stop();
                            customModal.btnEdit.setText("AGREGAR");
                            customModal.btnEdit.setEnabled(true);
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Plato agregado correctamente",
                                    "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    new FlatSVGIcon("icons/success.svg", 20, 20)
                            );
                            closeMessage();
                            modalListener.onDishActionModalClose(newDish, dishAction);
                        });
                    });
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error al agregar plato",
                            "Error",
                            JOptionPane.ERROR_MESSAGE,
                            new FlatSVGIcon("icons/error.svg", 20, 20)
                    );
                }
            }
        }
        if (e.getSource() == customModal.btnEdit && dishAction == DishAction.EDIT) {
            String name = dishActionPanel.txtName.getText();
            String price = dishActionPanel.txtPrice.getText();
            int categoryIndex = dishActionPanel.cbCategories.getSelectedIndex();
            if (name.isEmpty() || price.isEmpty() || categoryIndex == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, rellene todos los campos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        new FlatSVGIcon("icons/error.svg", 20, 20)
                );
            } else {
                customModal.btnEdit.setEnabled(false);
                String categoryName = Objects.requireNonNull(dishActionPanel.cbCategories.getSelectedItem()).toString();
                Category category = Category.getCategoryByName(categoryName);
                DishDAOImpl dishDAO = new DishDAOImpl();
                buttonWait("EDITANDO");
                executorService.execute(() -> {
                    Dish updatedDish = new Dish(dish.getId(), name, Double.parseDouble(price), category.getId());
                    dishDAO.updateDish(updatedDish);

                    SwingUtilities.invokeLater(() -> {
                        timer.stop();
                        customModal.btnEdit.setText("EDITAR");
                        customModal.btnEdit.setEnabled(true);
                        JOptionPane.showMessageDialog(
                                null,
                                "Plato editado correctamente",
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE,
                                new FlatSVGIcon("icons/success.svg", 20, 20)
                        );
                        closeMessage();
                        modalListener.onDishActionModalClose(updatedDish, dishAction);
                    });
                });
            }
        }
        if (e.getSource() == customModal.btnEdit && dishAction == DishAction.DELETE) {
            customModal.btnEdit.setEnabled(false);
            buttonWait("ELIMINANDO");
            executorService.execute(() -> {
                DishDAOImpl dishDAO = new DishDAOImpl();
                dishDAO.deleteDish(dish.getId());

                SwingUtilities.invokeLater(() -> {
                    timer.stop();
                    customModal.btnEdit.setText("ELIMINAR");
                    customModal.btnEdit.setEnabled(true);
                    JOptionPane.showMessageDialog(
                            null,
                            "Plato eliminado correctamente",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE,
                            new FlatSVGIcon("icons/success.svg", 20, 20)
                    );
                    closeMessage();
                    modalListener.onDishActionModalClose(dish, dishAction);
                });
            });
        }
    }
}
