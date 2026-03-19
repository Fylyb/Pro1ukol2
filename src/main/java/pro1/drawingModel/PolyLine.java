package pro1.drawingModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Drawable{
    private final List<Point> points = new ArrayList<>();
    private int thickness = 1;
    private boolean isRed = false;


    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void reset() {
        points.clear();
    }

    @Override
    public void draw(Graphics2D g) {
        if (points.isEmpty()) return;

        g.setColor(isRed ? Color.RED : Color.GRAY);
        g.setStroke(new BasicStroke(this.thickness));

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        if (points.size() > 1) {
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

            for (Point p : points) {
                if (p.x < minX) minX = p.x;
                if (p.y < minY) minY = p.y;
                if (p.x > maxX) maxX = p.x;
                if (p.y > maxY) maxY = p.y;
            }

            g.setColor(Color.RED);
            g.setStroke(new BasicStroke(1));
            g.drawRect(minX-1, minY-1, maxX - minX + 2, maxY - minY + 2);
        }
    }
}
