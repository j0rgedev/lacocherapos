package components.pos;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;

public class SVGImage extends JLabel {

    public void setSvgIcon(String path, int width, int height) {
        FlatSVGIcon svgIcon = new FlatSVGIcon(path, width, height);
        setIcon(svgIcon);
    }
}
