package view.components.modal;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import model.service.OrderInterface;
import model.service.OrderManager;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import view.listeners.ModalListener;

public abstract class ModalController extends JDialog implements ActionListener {

    private Animator animator;
    private Glass glass;
    private boolean show;
    protected final CustomModal customModal;
    private final JFrame jFrame;
    protected final ModalListener modalListener;
    protected final OrderInterface orderInterface = OrderManager.getInstance();

    public ModalController(CustomModal customModal, JFrame jFrame, ModalListener modalListener) {
        super(jFrame, true);
        this.jFrame = jFrame;
        this.customModal = customModal;
        this.modalListener = modalListener;
        init();
        // General listeners
        this.customModal.btnEdit.addActionListener(this);
        this.customModal.btnCancel.addActionListener(this);
    }

    private void init() {
        customModal.setBackground(new Color(0, 0, 0, 0));
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                glass.setAlpha(f - f * 0.3f);
                customModal.setOpacity(f);
            }

            @Override
            public void end() {
                if (!show) {
                    customModal.dispose();
                    glass.setVisible(false);
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        customModal.setOpacity(0f);
        glass = new Glass();
        glass.setEnabled(false);
        glass.setFocusable(false);
    }

    private void startAnimator(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
    }

    protected void setupModal(JPanel panel, String path) {
        setModalIcon(path);
        customModal.containerPanel.setPreferredSize(panel.getPreferredSize());
        customModal.containerPanel.add(panel);
        customModal.pack();
        jFrame.setGlassPane(glass);
        glass.setVisible(true);
        customModal.setLocationRelativeTo(jFrame);
        startAnimator(true);
        customModal.setVisible(true);
    }

    protected void setModalIcon(String path) {
        int dimension = (int) (customModal.lblIcon.getHeight() / 1.5);
        FlatSVGIcon icon = new FlatSVGIcon(path, dimension, dimension);
        customModal.lblIcon.setIcon(icon);
    }

    public void closeMessage() {
        startAnimator(false);
    }

    public abstract void showModal();
    protected abstract void handleCustomModalAction(ActionEvent e);


    @Override
    public void actionPerformed(ActionEvent e) {
        handleCustomModalAction(e);
    }
}
