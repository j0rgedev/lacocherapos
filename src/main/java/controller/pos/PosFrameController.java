package controller.pos;

import java.awt.*;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class PosFrameController extends AbstractController implements ActionListener {

    public PosFrameController() {}

    @Override
    public void init() {
        frameConfig();
        showTime();
    }

    private void showTime() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String fecha = now.format(dateFormatter);
                String hora = now.format(timeFormatter);
                pointOfSaleFrm.posHeader.lblTime.setText(fecha + " " + hora);
                pointOfSaleFrm.posSecondaryHeader.lblTime.setText(fecha + " " + hora);
            }
        }, 0, 1000);
    }

    private void frameConfig() {
        pointOfSaleFrm.getContentPane().setBackground(Color.BLACK);
        // Initial panel: OrderPanel and CartPanel
        CartPanelController cartPanelController = new CartPanelController();
        cartPanelController.init();
        OrderPanelController orderPanelController = new OrderPanelController(cartPanelController);
        orderPanelController.init();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
    }

}
