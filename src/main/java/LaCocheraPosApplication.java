import com.formdev.flatlaf.FlatDarculaLaf;
import controller.pos.PosFrameController;
import view.pos.PointOfSaleFrame;

public class LaCocheraPosApplication {

        public static void main(String[] args) {
            // Frame theme
            FlatDarculaLaf.setup();
            // POS view
            PointOfSaleFrame puntoVenta = new PointOfSaleFrame();
            // POS controller
            PosFrameController puntoVentaController = new PosFrameController(puntoVenta);
            puntoVentaController.init();
            puntoVenta.setVisible(true);
        }
}
