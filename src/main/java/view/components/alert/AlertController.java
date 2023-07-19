package view.components.alert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AlertController implements ActionListener {
    private final Alert alert;
    private final Color successColor = new Color(24,157,88);
    private final Color errorColor = new Color(235,98,98);
    private final Color warningColor = new Color(246,191,71);

    public AlertController(Alert alert) {
        this.alert = alert;
        init();
    }

    private void init(){
        alert.btnConfirm.addActionListener(this);
        alert.setLocationRelativeTo(null);
    }

    public void showAlarm(AlertModel alertModel){
        switch (alertModel.getErrorType()) {
            case ERROR, WARNING, SUCCESS -> {
                setAlertInfo(alertModel);
                alert.setVisible(true);
            }
        }
    }

    private void setAlertInfo(AlertModel alertModel){
        switch (alertModel.getErrorType()) {
            case ERROR -> {
                alert.lblTitle.setForeground(errorColor);
                alert.lblTitle.setText(alertModel.getTitle());
                alert.lblDescription.setText(alertModel.getDescription());
                alert.btnConfirm.setBackground(errorColor);
                alert.btnConfirm.setForeground(Color.WHITE);
                alert.btnConfirm.setText("CERRAR");
            }
            case WARNING -> {
                alert.lblTitle.setForeground(warningColor);
                alert.lblTitle.setText(alertModel.getTitle());
                alert.lblDescription.setText(alertModel.getDescription());
                alert.btnConfirm.setBackground(warningColor);
                alert.btnConfirm.setForeground(Color.WHITE);
                alert.btnConfirm.setText("CONTINUAR");
            }
            case SUCCESS -> {
                alert.lblTitle.setForeground(successColor);
                alert.lblTitle.setText(alertModel.getTitle());
                alert.lblDescription.setText(alertModel.getDescription());
                alert.btnConfirm.setBackground(successColor);
                alert.btnConfirm.setForeground(Color.WHITE);
                alert.btnConfirm.setText("CONTINUAR");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == alert.btnConfirm){
            alert.dispose();
        }
    }
}
