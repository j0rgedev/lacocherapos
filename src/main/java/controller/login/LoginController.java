package controller.login;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.admin.AdminFrameController;
import controller.pos.PosFrameController;
import model.dao.impl.EmployeeDAOImpl;
import model.entity.Employee;
import model.enums.Roles;
import model.utils.PasswordEncryption;
import view.admin.AdminIntranetFrame;
import view.login.Login;
import view.pos.PointOfSaleFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginController implements ActionListener {

    private final Login login;
    private final EmployeeDAOImpl userDAO;

    public LoginController(Login login) {
        this.login = login;
        this.userDAO = new EmployeeDAOImpl();
    }

    // Init login controller
    public void init() {
        login.setLocationRelativeTo(null);
        login.btnLogin.addActionListener(this);
        login.rbAdmin.addActionListener(this);
        login.rbEmployee.addActionListener(this);
        listeners();
    }

    private void listeners() {
        login.txtUser.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                checkButtonState();
            }
        });

        login.txtPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                checkButtonState();
            }
        });
    }

    private void checkButtonState() {
        boolean textFieldsNotEmpty = !login.txtUser.getText().isEmpty() && !login.txtPassword.getText().isEmpty();
        boolean radioButtonSelected = login.rbEmployee.isSelected() || login.rbAdmin.isSelected();

        // Habilitar el botón si se cumplen ambas condiciones
        login.btnLogin.setEnabled(textFieldsNotEmpty && radioButtonSelected);
    }

    private void showMessage(String message, String title, String iconPath) {
        FlatSVGIcon icon = new FlatSVGIcon(iconPath, 20, 20);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == login.btnLogin) {
            String userId = login.txtUser.getText().toUpperCase();
            String password = String.valueOf(login.txtPassword.getPassword());

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            login.btnLogin.setEnabled(false);

            Timer timer = new Timer(500, new ActionListener() {
                private int dotsCount = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    dotsCount = (dotsCount + 1) % 4;
                    login.btnLogin.setText("BUSCANDO" + ".".repeat(Math.max(0, dotsCount)));
                }
            });
            timer.start();

            executorService.execute(() -> {
                Employee employee = userDAO.getUser(userId);
                timer.stop();
                login.btnLogin.setText("INICIAR SESIÓN");
                login.btnLogin.setEnabled(true);
                if (employee != null) {
                    if (login.rbAdmin.isSelected()) {
                        if (employee.getRole() == Roles.MANAGER) {
                            if (PasswordEncryption.verifyCredentials(password, employee.getSalt(), employee.getPassword())) {
                                showMessage("Bienvenido " + employee.getNames(), "Inicio de sesión exitoso", "icons/success.svg");
                                // Admin view
                                AdminIntranetFrame adminIntranetFrame = new AdminIntranetFrame();
                                // Admin controller
                                AdminFrameController adminFrameController = new AdminFrameController(adminIntranetFrame);
                                adminFrameController.init();
                                adminIntranetFrame.setVisible(true);
                                login.dispose();
                            } else {
                                showMessage("Contraseña incorrecta", "Error", "icons/error.svg");
                            }
                        } else {
                            showMessage("El usuario no tiene permisos de administrador", "Error", "icons/error.svg");
                        }
                    } else if (PasswordEncryption.verifyCredentials(password, employee.getSalt(), employee.getPassword())) {
                        showMessage("Bienvenido " + employee.getNames(), "Inicio de sesión exitoso", "icons/check.svg");
                        // POS view
                        PointOfSaleFrame pointOfSaleFrame = new PointOfSaleFrame();
                        // POS controller
                        PosFrameController posFrameController = new PosFrameController(pointOfSaleFrame);
                        posFrameController.init();
                        pointOfSaleFrame.setVisible(true);
                        login.dispose();
                    } else {
                        showMessage("Contraseña incorrecta", "Error", "icons/error.svg");
                    }
                } else {
                    showMessage("Usuario no existe", "Error", "icons/error.svg");
                }
            });
        }
        if (e.getSource() == login.rbAdmin) {
            checkButtonState();
        }
        if (e.getSource() == login.rbEmployee) {
            checkButtonState();
        }
    }
}
