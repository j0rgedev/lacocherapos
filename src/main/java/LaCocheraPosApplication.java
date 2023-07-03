import com.formdev.flatlaf.FlatDarculaLaf;
import controller.pos.PosFrameController;
import view.pos.PointOfSaleFrame;

public class LaCocheraPosApplication {

        public static void main(String[] args) {
            // Frame theme
            FlatDarculaLaf.setup();
            // POS view
            PointOfSaleFrame pointOfSaleFrame = new PointOfSaleFrame();
            // POS controller
            PosFrameController posFrameController = new PosFrameController(pointOfSaleFrame);
            posFrameController.init();
            pointOfSaleFrame.setVisible(true);
        }
}
