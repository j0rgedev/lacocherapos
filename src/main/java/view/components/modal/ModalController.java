package view.components.modal;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import view.listeners.ModalListener;

public abstract class ModalController extends JDialog implements ActionListener {

    private Animator animator;
    private Glass glass;
    private boolean show;
    protected final CustomModal customModal;
    private final JFrame jFrame;
    private final ModalListener modalListener;

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
                    dispose();
                    glass.setVisible(false);
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        customModal.setOpacity(0f);
        glass = new Glass();
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

    protected void setupModal() {
        jFrame.setGlassPane(glass);
        glass.setVisible(true);
        customModal.setLocationRelativeTo(jFrame);
        startAnimator(true);
        customModal.setVisible(true);
    }


    protected void closeMessage() {
        startAnimator(false);
        modalListener.onModalClose();
    }

    public abstract void showModal();
    protected abstract void handleCustomModalAction(ActionEvent e);


    @Override
    public void actionPerformed(ActionEvent e) {
        handleCustomModalAction(e);
    }
}
