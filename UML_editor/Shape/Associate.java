package Shape;

import java.awt.Color;
import java.awt.Graphics;

public class Associate extends Line {
    private double H = 12, L = 8;
    public void draw(Graphics g) {

        int endX = x2;
        int endY = y2;
        int startX = x1;
        int startY = y1;
        g.setColor(Color.black);
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
        g.drawLine((int) ex, (int) ey, (int) x_3, (int) y_3);
        g.drawLine((int) ex, (int) ey, (int) x_4, (int) y_4);

    }

    public Associate(int _x1, int _y1, int _x2, int _y2){ 
        this.x1 = _x1;
		this.y1 = _y1;
		this.x2 = _x2;
		this.y2 = _y2;

    }

}
