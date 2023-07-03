package view.components;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.function.Function;

public class SVGImage extends JLabel {

    public void setImage(String image, Dimension dimension) {
        FlatSVGIcon flatSVGIcon = new FlatSVGIcon(image, dimension.width, dimension.height);
        setIcon(flatSVGIcon);
    }
}
