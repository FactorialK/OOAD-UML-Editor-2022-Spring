package Shape;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Graph {
    public abstract void draw(Graphics g); // 用來繼承
    public boolean hidden = false;
    public boolean selected = false;
    protected int x1, y1, x2, y2; // 每種圖形都有起始位置與最終未置。

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getCentralX() {
        return (x1 + x2) / 2;
    }

    public int getCentralY() {
        return (y1 + y2) / 2;
    }

    public int contain(Point p) {
        return -1;
    }

    public void isSelect() {
    }

    public void notSelect() {
    }

    public void resetLocation(int moveX, int moveY) {
    };// 給object移動用
    public void resetBound(int moveX, int moveY){}
    public void changeName(String name) {
    }

    public void unGroup(){}
}
