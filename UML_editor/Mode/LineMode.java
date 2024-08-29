package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Shape.Graph;
import Shape.Line;
import Shape.Objects;

public class LineMode extends ToolMode {
    private int mode;
    private ArrayList<Graph> _graphs;
    private Point startPoint = null, endPoint = null;
    private int startPort, endPort;
    private Objects from, to;
    private GraphicsFactoryInterface GraphicsFactory = new GraphicsFactory();

    public LineMode(int setMode) {
        mode = setMode;
    }

    public void mousePressed(MouseEvent e) {
        startPoint = null;
        Point clickPoint = e.getPoint();
        _graphs = canvas.getGraphsList();

        for (Graph g : _graphs) {
            if (g.contain(clickPoint) != -1) {
                startPort = g.contain(clickPoint);
                from = (Objects) g;
                startPoint = from.Ports[startPort];
                break;
            }
        }

        canvas.repaint();
    }

    public void mouseDragged(MouseEvent e) {
        if (startPoint != null) {
            Line line = GraphicsFactory.drawLine(mode, startPoint, e.getPoint());
            canvas.dragLine = line;
            canvas.repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        Point releasePoint = e.getPoint();
        for (Graph g : _graphs) {
            if (g.contain(releasePoint) != -1) {
                endPort = g.contain(releasePoint);
                to = (Objects) g;
                endPoint = to.Ports[endPort];
                if (from != to) {
                    Line line = GraphicsFactory.drawLine(mode, startPoint, endPoint);
                    from.addLine(line);
                    to.addLine(line);
                    line.setPort(from, startPort, to, endPort); // 成功畫出線的時候 才會給他設定Port
                    canvas.addGraph(line);
                    canvas.repaint();
                } 
                break;
            }
        }

        canvas.dragLine = null;
        canvas.repaint();
        endPoint = null;
        startPort = -1;
        endPort = -1;

    }
}
