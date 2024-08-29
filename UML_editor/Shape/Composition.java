package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Composition extends Line {
    private double H = 12, L = 8;

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int endX = x2;
        int endY = y2;
        int startX = x1;
        int startY = y1;
        g.setColor(Color.BLACK);
        g.drawLine(startX, startY, endX, endY);

        double sx = (double) x1;
        double sy = (double) y1;
        double ex = (double) x2;
        double ey = (double) y2;
        double awrad = Math.atan(L / H);
        double arraow_len = Math.sqrt(L * L + H * H);

        double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
        double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);

        double x_3 = ex - arrXY_1[0];
        double y_3 = ey - arrXY_1[1];
        double x_4 = ex - arrXY_2[0];
        double y_4 = ey - arrXY_2[1];
        GeneralPath triangle1 = new GeneralPath();
        triangle1.moveTo(ex, ey);
        triangle1.lineTo(x_3, y_3);
        triangle1.lineTo(x_4, y_4);
        triangle1.closePath();
        g2.fill(triangle1);

        double x_5 = x_3 + (x_4 - x_3) / 2;
        double y_5 = y_3 + (y_4 - y_3) / 2;
        double x_6 = ex - (ex - x_5) * 2;
        double y_6 = ey - (ey - y_5) * 2;
        GeneralPath triangle2 = new GeneralPath();
        triangle2.moveTo(x_6, y_6);
        triangle2.lineTo(x_3, y_3);
        triangle2.lineTo(x_4, y_4);
        triangle2.closePath();
        g2.fill(triangle2);
    }

    public Composition(int _x1, int _y1, int _x2, int _y2) {
        this.x1 = _x1;
        this.y1 = _y1;
        this.x2 = _x2;
        this.y2 = _y2;

    }

}
