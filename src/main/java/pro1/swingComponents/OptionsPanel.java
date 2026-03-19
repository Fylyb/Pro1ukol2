package pro1.swingComponents;

import pro1.drawingModel.PolyLine;
import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {

    private final MainFrame parent;

    public OptionsPanel(MainFrame parent, PolyLine polyLine, DisplayPanel displayPanel) {
        this.parent = parent;

        this.setPreferredSize(new Dimension(250, 0));

        JSlider thicknessSlider = new JSlider(1, 20, 1);
        this.add(new JLabel("Tloušťka:"));
        this.add(thicknessSlider);
        thicknessSlider.addChangeListener(e -> {
            polyLine.setThickness(thicknessSlider.getValue());
            displayPanel.repaint();
        });

        JCheckBox colorBox = new JCheckBox("Červená barva");
        this.add(colorBox);
        colorBox.addChangeListener(e -> {
            polyLine.setRed(colorBox.isSelected());
            displayPanel.repaint();
        });

        JButton resetButton = new JButton("Reset");
        this.add(resetButton);
        resetButton.addActionListener(e -> {
            polyLine.reset();
            displayPanel.repaint();
        });
    }
}
