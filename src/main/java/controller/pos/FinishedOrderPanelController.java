package controller.pos;

import view.pos.FinishedOrderPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class FinishedOrderPanelController extends AbstractController implements ActionListener {

    private final FinishedOrderPanel finishedOrderPanel;

    public FinishedOrderPanelController(FinishedOrderPanel finishedOrderPanel) {
        this.finishedOrderPanel = finishedOrderPanel;
    }

    @Override
    protected void init() {
        int dimension = finishedOrderPanel.svgImage.getHeight();
        finishedOrderPanel.svgImage.setImage("icons/done.svg", new Dimension(dimension, dimension));

        finishedOrderPanel.btnNewOrder.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == finishedOrderPanel.btnNewOrder) {
            orderInterface.clearOrder();
        }
    }
}
