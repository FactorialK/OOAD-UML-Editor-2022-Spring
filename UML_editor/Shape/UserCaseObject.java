package Shape;

import java.awt.Color;
import java.awt.Graphics;

public class UserCaseObject extends Objects {
    public void draw(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillOval(x1, y1, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x1, y1, width, height);
        int stringWidth = g.getFontMetrics(font).stringWidth(ObjectName);
        double empty = (Math.abs(x1 - x2) - stringWidth) / 2;
        g.setFont(font);
        g.drawString(ObjectName, x1 + (int) empty, y1 + 50);
        if (selected == true){
            showPort(g);
        }

    }

    public UserCaseObject(int x, int y) {
        this.x1 = x;
        this.y1 = y;
        this.width = 150;
        this.height = 100;
        this.x2 = x + width;
        this.y2 = y + height;
        setCenter();
        setPort();

    }
}
