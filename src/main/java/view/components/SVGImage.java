package view.components;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;

public class SVGImage extends JLabel {

    public void setImage(String image, Dimension dimension) {
        FlatSVGIcon flatSVGIcon = new FlatSVGIcon(image, dimension.width, dimension.height);
        setIcon(flatSVGIcon);
    }
}
