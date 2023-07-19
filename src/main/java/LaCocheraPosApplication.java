import com.formdev.flatlaf.FlatDarculaLaf;
import controller.admin.AdminFrameController;
import controller.pos.PosFrameController;
import view.admin.AdminIntranetFrame;
import view.pos.PointOfSaleFrame;

public class LaCocheraPosApplication {

        public static void main(String[] args) {
            // Frame theme
            FlatDarculaLaf.setup();
            testAdmin();
            //testPos();
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
