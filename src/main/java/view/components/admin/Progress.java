package view.components.admin;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar {

    private final ProgressCircleUI ui;

    String[] type = {"",""};
    
    public Progress() {
        setOpaque(false);
        setStringPainted(true);
        ui = new ProgressCircleUI();
        setUI(ui);
    }

    @Override
    public String getString() {
        return type[0] + ((int) (getValue() * ui.getAnimate())) + type[1];
    }

    public void start() {
        ui.start();
    }

    public void setType(String[] type) {
        this.type = type;
    }
    

}
