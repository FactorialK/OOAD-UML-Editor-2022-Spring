package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Shape.Graph;

public class SelectMode extends ToolMode {
    private Point clickPoint;
    private Point dragPoint;
    private ArrayList<Graph> _graphs;

    public void mousePressed(MouseEvent e) {
        canvas.repaint();

        canvas.SelectedArea.setBounds(0, 0, 0, 0);
        canvas.unselect();
        clickPoint = e.getPoint();
        dragPoint = e.getPoint();
        _graphs = canvas.getGraphsList();

        for (int index = _graphs.size() - 1; index >= 0; index--) {
            Graph g = _graphs.get(index);
            if (g.contain(clickPoint) != -1) { // -1為obeject外部
                g.isSelect();
                canvas.select(g);
                break;
            }
            ;
        }
        canvas.repaint();
    }

    public void mouseDragged(MouseEvent e) {
        int moveX = e.getX() - clickPoint.x;
        int moveY = e.getY() - clickPoint.y;
        int moveXD = e.getX() - dragPoint.x;
        int moveYD = e.getY() - dragPoint.y;

        if (canvas.selection != null) { // 檢查有沒有選到obj
            Graph x = canvas.selection;
            x.isSelect();
            x.resetLocation(moveX, moveY);
        } else {// 用來畫 選取框框
            if (e.getX() > dragPoint.x) {
                canvas.SelectedArea.setBounds(dragPoint.x, dragPoint.y, Math.abs(moveXD), Math.abs(moveYD));
            } else {
                canvas.SelectedArea.setBounds(e.getX(), e.getY(), Math.abs(moveXD), Math.abs(moveYD));
            }
            checkInsideSelect(_graphs); // 0330
        }
        clickPoint.x = e.getX();
        clickPoint.y = e.getY();

        canvas.repaint();

    }

    public void mouseReleased(MouseEvent e) {
        canvas.repaint();
    }

    private void checkInsideSelect(ArrayList<Graph> shapes) { // 0330
        int leftUpperX = canvas.SelectedArea.x;
        int leftUpperY = canvas.SelectedArea.y;
        int rightLowerX = canvas.SelectedArea.x + canvas.SelectedArea.width;
        int rightLowerY = canvas.SelectedArea.y + canvas.SelectedArea.height;

        for (Graph shape : shapes) {
            if ((leftUpperX < shape.getX1()) && (leftUpperY < shape.getY1()) && (rightLowerX > shape.getX2())
                    && (rightLowerY > shape.getY2())) {
                shape.isSelect();
            } else {
                shape.notSelect();
            }
        }

    }

}