package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import Main.Canvas;

public class GroupObject extends Graph {
    protected Canvas canvas = Canvas.getInstance();

    private int offset = 10;
    private ArrayList<Graph> groups = new ArrayList<>();
    private Rectangle aRectangle = new Rectangle();

    public void addGroup(Graph obj) {
        groups.add(obj);
    }

    public void unGroup() {
        for (Graph obj : groups) {
            obj.hidden = false;
        }
        canvas.removeGraph(this);
    }

    public void isSelect() {
        for (Graph obj : groups) {
            obj.isSelect();
            this.selected = true;
        }
    }

    public void notSelect() {
        for (Graph obj : groups) {
            obj.notSelect();
        }
        this.selected = false;
    }


    public void resetLocation(int moveX, int moveY) {
        resetBound(moveX, moveY);
        for (Graph obj : groups) {
            if (obj instanceof GroupObject) {
               obj.resetBound(moveX, moveY);

            } else{
                obj.resetLocation(moveX, moveY);

            }
        }
    }
    public void resetBound(int moveX, int moveY) {
        this.x1 += moveX;
        this.y1 += moveY;
        this.x2 += moveX;
        this.y2 += moveY;
    }

    public void draw(Graphics g) {
        for (Graph obj : groups) {
            obj.draw(g);
        }
        int alpha = 85; // 33% transparent
        g.setColor(new Color(52, 250, 237, alpha));
        g.fillRect(x1 - offset, y1 - offset, x2 - x1 + 2 * offset, y2 - y1 + 2 * offset);
        g.setColor(new Color(52, 250, 237));
        g.drawRect(x1 - offset, y1 - offset, x2 - x1 + 2 * offset, y2 - y1 + 2 * offset);
        g.setColor(Color.white);
        canvas.repaint();
    }

    public int contain(Point p) {
        if ((p.x > x1) && (p.x < x2) && (p.y > y1) && (p.y < y2)) {
            int PortIndex = -1;
            for (Graph obj : groups) {
                if (obj.contain(p) != -1) {
                    PortIndex = obj.contain(p);
                }
            }
            return PortIndex;
        } else {
            return -1;
        }
    }

    public void setBounds() {
        Point upLeftP, bottomRightP;
        int leftX = Integer.MAX_VALUE, rightX = Integer.MIN_VALUE;
        int upY = Integer.MAX_VALUE, bottomY = Integer.MIN_VALUE;

        for (int i = 0; i < groups.size(); i++) {

            Graph group = groups.get(i);
            if (group.getX1() < leftX) {
                leftX = group.getX1();
            }
            if (group.getX2() > rightX) {
                rightX = group.getX2();
            }
            if (group.getY1() < upY) {
                upY = group.getY1();
            }
            if (group.getY2() > bottomY) {
                bottomY = group.getY2();
            }
        }

        upLeftP = new Point(leftX, upY);
        bottomRightP = new Point(rightX, bottomY);
        aRectangle.setBounds(upLeftP.x, upLeftP.y, Math.abs(upLeftP.x - bottomRightP.x),
                Math.abs(upLeftP.y - bottomRightP.y));

        this.x1 = aRectangle.x;
        this.y1 = aRectangle.y;
        this.x2 = aRectangle.x + aRectangle.width;
        this.y2 = aRectangle.y + aRectangle.height;
    }
}
