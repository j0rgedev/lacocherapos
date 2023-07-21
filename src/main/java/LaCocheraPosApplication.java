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
            testWholeApp();
//            testAdmin();
//            testPos();
        }

        private static void testWholeApp(){
            Login login = new Login();
            LoginController loginController = new LoginController(login);
            loginController.init();
            login.setVisible(true);
        }

        private static void testPos(){
            // POS view
            PointOfSaleFrame pointOfSaleFrame = new PointOfSaleFrame();
            // POS controller
            PosFrameController posFrameController = new PosFrameController(pointOfSaleFrame);
            posFrameController.init();
            pointOfSaleFrame.setVisible(true);
        }

        private static void testAdmin(){
            // Admin view
            AdminIntranetFrame adminIntranetFrame = new AdminIntranetFrame();
            // Admin controller
            AdminFrameController adminFrameController = new AdminFrameController(adminIntranetFrame);
            adminFrameController.init();
            adminIntranetFrame.setVisible(true);
        }
}
