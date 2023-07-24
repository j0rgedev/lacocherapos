package view.components.spinner;

import javax.swing.JProgressBar;

/**
 *
 * @author Raven
 */
public class SpinnerProgress extends JProgressBar {

    private final int DEFAULT_SIZE = 12;

    public SpinnerProgress() {
        init();
    }

    private void init() {
        setUI(new SpinnerProgressUI(DEFAULT_SIZE));
    }
}
