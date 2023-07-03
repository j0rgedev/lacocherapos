import com.formdev.flatlaf.FlatDarculaLaf;
import controller.pos.PosFrameController;
import view.pos.PointOfSaleFrame;

public class LaCocheraPosApplication {

        public static void main(String[] args) {
            // Frame theme
            FlatDarculaLaf.setup();
            // POS view
            PointOfSaleFrame pointOfSaleFrame = PointOfSaleFrame.getInstance();
            // POS controller
            PosFrameController posFrameController = new PosFrameController();
            posFrameController.init();
            pointOfSaleFrame.setVisible(true);
        }
}
