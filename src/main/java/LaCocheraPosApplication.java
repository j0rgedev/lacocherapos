import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import controller.admin.AdminFrameController;
import controller.login.LoginController;
import controller.pos.PosFrameController;
import view.admin.AdminIntranetFrame;
import view.login.Login;
import view.pos.PointOfSaleFrame;

public class LaCocheraPosApplication {

    public static void main(String[] args) {
        // Frame theme
        FlatDarculaLaf.setup();
        Login login = new Login();
        LoginController loginController = new LoginController(login);
        loginController.init();
        login.setVisible(true);
    }
}
