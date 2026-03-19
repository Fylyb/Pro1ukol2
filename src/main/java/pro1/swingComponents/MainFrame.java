package pro1.swingComponents;

import pro1.drawingModel.*;
import pro1.drawingModel.Rectangle;
import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    DisplayPanel displayPanel;
    private int x;
    private int y;
    private String color;

    private PolyLine polyLine = new PolyLine();

    public void setColor(String color) {
        this.color = color;
    }

    public MainFrame() {
        this.setTitle("PRO1 Drawing");
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.displayPanel.setDrawable(this.polyLine);
        this.add(this.displayPanel, BorderLayout.CENTER);

        JPanel leftPanel = new OptionsPanel(this, this.polyLine, this.displayPanel);

        this.add(leftPanel, BorderLayout.WEST);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                polyLine.addPoint(e.getX(), e.getY());
                displayPanel.setDrawable(polyLine);
                displayPanel.repaint();
            }
        });
        this.setVisible(true);
    }

    public void showExample() {
        this.displayPanel.setDrawable(example());
    }

    private Drawable example() {
//        var color = ColorUtils.randomColor();
        var d1 = new Ellipse(0, 0, 150, 250, color);
        var d2 = new Text(0, 0, color);
        var d3 = new Line(0, 50, 170, 170, 3, color);
        return new Group(new Drawable[]{d1, d2, d3}, this.x, this.y, 40, 1, 1);
    }
}
