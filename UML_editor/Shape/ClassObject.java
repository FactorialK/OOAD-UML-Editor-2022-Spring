package Shape;

import java.awt.Color;
import java.awt.Graphics;

public class ClassObject extends Objects {
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x1, y1, width, height);

        int cut = height / 3;
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, width, height);
        g.drawLine(x1, y1 + cut, x2, y1 + cut);
        g.drawLine(x1, y1 + cut * 2, x2, y1 + cut * 2);

        int stringWidth = g.getFontMetrics(font).stringWidth(ObjectName);
        double empty = (Math.abs(x1 - x2) - stringWidth) / 2; 
        g.setFont(font);
        g.drawString(ObjectName, x1 + (int) empty, y1 + 25);
        if (selected == true){
            showPort(g);
        }

    }

    public ClassObject(int x, int y) {
        this.x1 = x;
        this.y1 = y;
        this.width = 120;
        this.height = 150;
        this.x2 = x + width;
        this.y2 = y + height;
        setCenter();
        setPort();

    }
}