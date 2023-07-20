package controller.pos;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import model.utils.ReceiptGenerator;
import view.pos.FinishedOrderPanel;
import view.pos.PointOfSaleFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FinishedOrderPanelController extends AbstractController implements ActionListener {

    private final FinishedOrderPanel finishedOrderPanel;

    public FinishedOrderPanelController(PointOfSaleFrame pointOfSaleFrame, FinishedOrderPanel finishedOrderPanel) {
        super(pointOfSaleFrame);
        this.finishedOrderPanel = finishedOrderPanel;
    }

    @Override
    protected void init() {
        int dimension = finishedOrderPanel.svgImage.getHeight() - 10;
        finishedOrderPanel.svgImage.setImage("icons/check.svg", new Dimension(dimension, dimension));

        finishedOrderPanel.lblOrderId.setText(orderInterface.getOrder().getId());
        finishedOrderPanel.btnNewOrder.addActionListener(this);
        finishedOrderPanel.btnReceipt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == finishedOrderPanel.btnNewOrder) {
            pointOfSaleFrm.dispose();
            PointOfSaleFrame pointOfSaleFrame = new PointOfSaleFrame();
            PosFrameController posFrameController = new PosFrameController(pointOfSaleFrame);
            posFrameController.init();
            pointOfSaleFrame.setVisible(true);
        }
        if(e.getSource() == finishedOrderPanel.btnReceipt) {
            try {
                ReceiptGenerator.generateReceipt(orderInterface.getOrder(), orderInterface.getDishes());

                JOptionPane.showMessageDialog(
                        null,
                        "Se generó el recibo correctamente",
                        "Generación exitosa",
                        JOptionPane.INFORMATION_MESSAGE,
                        new FlatSVGIcon("icons/success.svg", 20, 20)
                );

                String currentWorkingDir = System.getProperty("user.dir");
                File receiptsFolder = new File(currentWorkingDir, "receipts");
                String pdfFilePath = receiptsFolder.getAbsolutePath() + File.separator + "recibo_" + orderInterface.getOrder().getId() + ".pdf";
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(new File(pdfFilePath));
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "No se pudo abrir el recibo",
                            "Error",
                            JOptionPane.ERROR_MESSAGE,
                            new FlatSVGIcon("icons/error.svg", 20, 20)
                    );
                }

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error al generar el recibo",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        new FlatSVGIcon("icons/error.svg", 20, 20)
                );
            }
        }
    }
}
