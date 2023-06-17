package components.modal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class CustomModalController extends JDialog implements ActionListener {

    private Animator animator;
    private Glass glass;
    private boolean show;
    private final CustomModal customModal;
    private final JFrame jFrame;

    public CustomModalController(CustomModal customModal, JFrame jFrame) {
        super(jFrame, true);
        this.jFrame = jFrame;
        this.customModal = customModal;
        init();
        customModal.btnIncrementar.addActionListener(this);
        customModal.btnReducir.addActionListener(this);
        customModal.btnEdit.addActionListener(this);
        customModal.btnCancel.addActionListener(this);
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

    public void showMessage() {
        jFrame.setGlassPane(glass);
        glass.setVisible(true);
        customModal.setLocationRelativeTo(jFrame);
        startAnimator(true);
        customModal.setVisible(true);
    }

    public void closeMessage() {
        startAnimator(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
