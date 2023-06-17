package controller.pos;

import java.awt.Color;

import view.pos.PointOfSaleFrame;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class PosFrameController implements ActionListener {

    private final PointOfSaleFrame pointOfSaleFrm;

    public PosFrameController(PointOfSaleFrame puntoVenta) {
        this.pointOfSaleFrm = puntoVenta;
    }

    public void init(){
        frameConfig();
        showTime();
        pointOfSaleFrm.orderPanel.btnNext.addActionListener(this);
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
    
    private void frameConfig(){
        pointOfSaleFrm.getContentPane().setBackground(Color.BLACK);
        CartPanelController cartPanelController = new CartPanelController(pointOfSaleFrm);
        cartPanelController.init();
        OrderPanelController orderPanelController = new OrderPanelController(pointOfSaleFrm, cartPanelController);
        orderPanelController.init();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
    }
}
