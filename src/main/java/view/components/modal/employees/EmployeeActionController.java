package view.components.modal.employees;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import model.dao.impl.EmployeeDAOImpl;
import model.entity.Employee;
import model.enums.CrudAction;
import model.enums.Roles;
import model.utils.CodeGenerator;
import model.utils.HashedPassword;
import model.utils.PasswordEncryption;
import view.components.modal.CustomModal;
import view.components.modal.DeleteWarningPanel;
import view.components.modal.ModalController;
import view.listeners.ModalListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeActionController extends ModalController {

    private EmployeeActionPanel employeeActionPanel;
    private DeleteWarningPanel deleteEmployeeModal;
    private final CrudAction crudAction;
    private Employee employee;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Timer timer;

    public EmployeeActionController(
            CustomModal customModal,
            JFrame jFrame,
            ModalListeners employeesModalListener,
            CrudAction crudAction
    ) {
        super(customModal, jFrame, employeesModalListener);
        this.crudAction = crudAction;
    }

    public EmployeeActionController(
            CustomModal customModal,
            JFrame jFrame,
            ModalListeners employeesModalListener,
            CrudAction crudAction,
            Employee employee
    ) {
        super(customModal, jFrame, employeesModalListener);
        this.crudAction = crudAction;
        this.employee = employee;
    }

    @Override
    public void showModal() {
        employeeActionPanel = new EmployeeActionPanel();
        deleteEmployeeModal = new DeleteWarningPanel();
        init();
        if(crudAction == CrudAction.DELETE) setupModal(deleteEmployeeModal, "icons/trash.svg");
        else setupModal(employeeActionPanel, "icons/edit.svg");
    }

    private void init() {
        switch (crudAction) {
            case ADD -> {
                employeeActionPanel.lbTitle.setText("Agregando nuevo empleado");
                customModal.btnEdit.setText("AGREGAR");
            }
            case EDIT -> {
                employeeActionPanel.lbTitle.setText("Editando empleado " + employee.getId());
                customModal.btnEdit.setText("EDITAR");
                employeeActionPanel.txtName.setText(employee.getNames());
                employeeActionPanel.txtLastNames.setText(employee.getLastNames());
                String roleName = employee.getRole().getRoleName();
                String role = Character.toUpperCase(roleName.charAt(0)) + roleName.substring(1).toLowerCase();
                employeeActionPanel.cbRoles.setSelectedItem(role);
            }
            case DELETE -> {
                deleteEmployeeModal.lbTitle.setText("Eliminando empleado " + employee.getId());
                deleteEmployeeModal.lblWarning.setText(
                        "<html>" +
                            "<body style=\"text-align:center\">" +
                                "¿Estas seguro que deseas eliminar al empleado <b>" + employee.getNames() + "</b>?" +
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
        if (e.getSource() == customModal.btnEdit && crudAction == CrudAction.ADD) {
            String names = employeeActionPanel.txtName.getText();
            String lastNames = employeeActionPanel.txtLastNames.getText();
            String password = new String(employeeActionPanel.txtPassword.getPassword());
            int roleIndex = employeeActionPanel.cbRoles.getSelectedIndex();
            if (names.isEmpty() || lastNames.isEmpty() || password.isEmpty() || roleIndex == -1) {
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
                    String roleName = employeeActionPanel.cbRoles.getSelectedItem().toString().toLowerCase();
                    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
                    buttonWait("AGREGANDO");
                    executorService.execute(() -> {
                        String id = CodeGenerator.generateEmployeeId(employeeDAO.getLastUserId());
                        HashedPassword hashedPassword = PasswordEncryption.hashPassword(password);
                        Employee newEmployee = new Employee(
                                id,
                                names,
                                lastNames,
                                hashedPassword.hashedPassword(),
                                hashedPassword.salt(),
                                Roles.getRole(roleName)
                        );

                        employeeDAO.save(newEmployee);

                        SwingUtilities.invokeLater(() -> {
                            timer.stop();
                            customModal.btnEdit.setText("AGREGAR");
                            customModal.btnEdit.setEnabled(true);
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Empleado agregado correctamente\n" +
                                            "ID: " + newEmployee.getId() + "\n" +
                                            "Contraseña: " + password,
                                    "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    new FlatSVGIcon("icons/success.svg", 20, 20)
                            );
                            closeMessage();
                            modalListeners.onEmployeeActionModalClose(newEmployee, crudAction);
                        });
                    });
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error al agregar empleado",
                            "Error",
                            JOptionPane.ERROR_MESSAGE,
                            new FlatSVGIcon("icons/error.svg", 20, 20)
                    );
                }
            }
        }
        if (e.getSource() == customModal.btnEdit && crudAction == CrudAction.EDIT) {
            String names = employeeActionPanel.txtName.getText();
            String lastNames = employeeActionPanel.txtLastNames.getText();
            String password = new String(employeeActionPanel.txtPassword.getPassword());
            int roleIndex = employeeActionPanel.cbRoles.getSelectedIndex();
            String roleName = employeeActionPanel.cbRoles.getSelectedItem().toString().toLowerCase();
            if (names.isEmpty() || lastNames.isEmpty() || roleIndex == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, rellene todos los campos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        new FlatSVGIcon("icons/error.svg", 20, 20)
                );
            } else {
                customModal.btnEdit.setEnabled(false);
                EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
                buttonWait("EDITANDO");
                executorService.execute(() -> {
                    Employee updatedEmployee;
                    if(!password.isEmpty()) {
                        HashedPassword hashedPassword = PasswordEncryption.hashPassword(password);
                        updatedEmployee = new Employee(
                                employee.getId(),
                                names,
                                lastNames,
                                hashedPassword.hashedPassword(),
                                hashedPassword.salt(),
                                Roles.getRole(roleName)
                        );
                    } else {
                        updatedEmployee = new Employee(
                                employee.getId(),
                                names,
                                lastNames,
                                employee.getPassword(),
                                employee.getSalt(),
                                Roles.getRole(roleName)
                        );
                    }

                    employeeDAO.update(updatedEmployee);

                    SwingUtilities.invokeLater(() -> {
                        timer.stop();
                        customModal.btnEdit.setText("EDITAR");
                        customModal.btnEdit.setEnabled(true);

                        JOptionPane.showMessageDialog(
                                null,
                                "Empleado editado correctamente\n" +
                                        (password.isEmpty()  ? "Los datos fueron actualizados correctamente" :
                                        "Los datos fueron actualizados correctamente\n" +
                                        "Nueva contraseña: " + password),
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE,
                                new FlatSVGIcon("icons/success.svg", 20, 20)
                        );
                        closeMessage();
                        modalListeners.onEmployeeActionModalClose(updatedEmployee, crudAction);
                    });
                });
            }
        }
        if (e.getSource() == customModal.btnEdit && crudAction == CrudAction.DELETE) {
            customModal.btnEdit.setEnabled(false);
            buttonWait("ELIMINANDO");
            executorService.execute(() -> {
                EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
                employeeDAO.delete(employee);

                SwingUtilities.invokeLater(() -> {
                    timer.stop();
                    customModal.btnEdit.setText("ELIMINAR");
                    customModal.btnEdit.setEnabled(true);
                    JOptionPane.showMessageDialog(
                            null,
                            "Empleado eliminado correctamente",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE,
                            new FlatSVGIcon("icons/success.svg", 20, 20)
                    );
                    closeMessage();
                    modalListeners.onEmployeeActionModalClose(employee, crudAction);
                });
            });
        }
    }
}
