package Shape;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public abstract class Objects extends Graph {
    protected String ObjectName = "Object Name";
    protected int width, height;
    protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
    public Point[] Ports = new Point[4];
    protected int PortSize = 10;
    protected int offset = PortSize / 2;
    protected int centerX, centerY;
    protected ArrayList<Line> connectedLines = new ArrayList<>();

    public void addLine(Line _line) {
        connectedLines.add(_line);
    }

    public void changeName(String name) {
        this.ObjectName = name;
    }

    public int contain(Point p) { // 會回傳落在哪一塊block，並讓他連接到這個block的ports;
        if ((p.x > x1) && (p.x < x2) && (p.y > y1) && (p.y < y2)) {
            Point[] points = { new Point(x1, y1), new Point(x2, y1), new Point(x2, y2), new Point(x1, y2) };
            Polygon[] block = new Polygon[4]; // 四個區塊
            int PortIndex = -1;

            for (int Index = 0; Index < points.length; Index++) {

                int nextIndex = ((Index + 1) % 4);
                block[Index] = new Polygon();
                block[Index].addPoint(points[Index].x, points[Index].y);
                block[Index].addPoint(points[nextIndex].x, points[nextIndex].y);
                block[Index].addPoint(centerX, centerY);
                if (block[Index].contains(p)) {
                    PortIndex = Index;
                }
            }
            return PortIndex;
        } else {
            return -1;
        }
    }

    public void setCenter() {
        this.centerX = (x1 + x2) / 2;
        this.centerY = (y1 + y2) / 2;
    }

    public void setPort() {
        this.Ports[0] = new Point(centerX, centerY - (height / 2));
        this.Ports[1] = new Point(centerX + (width / 2), centerY);
        this.Ports[2] = new Point(centerX, centerY + (height / 2));
        this.Ports[3] = new Point(centerX - (width / 2), centerY);
    }

    public void isSelect() {
        selected = true;
    }

    public void notSelect() {
        selected = false;
    }

    protected void showPort(Graphics g) {
        g.fillRect((Ports[0]).x - offset, (Ports[0]).y - PortSize, PortSize, PortSize);
        g.fillRect((Ports[1]).x, (Ports[1]).y - offset, PortSize, PortSize);
        g.fillRect((Ports[2]).x - offset, (Ports[2]).y, PortSize, PortSize);
        g.fillRect((Ports[3]).x - PortSize, (Ports[3]).y - offset, PortSize, PortSize);
    }

    public void resetLocation(int moveX, int moveY) {
        int x1 = this.x1 + moveX;
        int y1 = this.y1 + moveY;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + width;
        this.y2 = y1 + height;
        setCenter();
        setPort();
        for (Line l : connectedLines) {
            if (l.fromObject == this && l.toObject == this) {
                l.resetLocation(moveX, moveY);
            } else {
                if (l.toObject == this) {
                    l.resetLocation(moveX, moveY,1);
                }
                if (l.fromObject == this) {
                    l.resetLocation(moveX, moveY, 0);
                }
            }

        }
    }
}