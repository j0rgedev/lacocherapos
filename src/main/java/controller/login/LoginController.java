package controller.login;

import components.alert.Alert;
import components.alert.AlertController;
import components.alert.AlertModel;
import components.alert.ErrorType;
import view.login.Login;

import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private final Login login;

    public LoginController(Login login) {
        this.login = login;
        init();
    }

    // Init login controller
    private void init() {
        login.setLocationRelativeTo(null);
        login.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == login.btnLogin){
            Alert alert = new Alert(login, true);
            AlertController alertController = new AlertController(alert);
            AlertModel alertModel = new AlertModel();
            alertModel.setTitle("BIENVENIDO");
            alertModel.setDescription("Inicio de sesión exitoso");
            alertModel.setErrorType(ErrorType.SUCCESS);
            alertController.showAlarm(alertModel);
        }
    }
}
