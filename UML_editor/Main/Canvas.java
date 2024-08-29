package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Mode.ToolMode;
import Shape.Graph;
import Shape.GroupObject;
import Shape.Line;

public class Canvas extends JPanel {
    private ArrayList<Graph> graphs = new ArrayList<>();
    public Line dragLine;
    public Graph selection = null;
    public Rectangle SelectedArea = new Rectangle();

    private Canvas() {
        setBackground(Color.PINK);
    }

    private static Canvas instance = null;

    public static Canvas getInstance() {
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

    private ToolMode event = null;
    protected ToolMode currentMode;

    public void setCurrentMode() {
        removeMouseListener((MouseListener) event);
        removeMouseMotionListener((MouseMotionListener) event);
        event = currentMode;
        addMouseListener((MouseListener) event);
        addMouseMotionListener((MouseMotionListener) event);
        System.out.println(event);
    }

    public void select(Graph _graph) {
        this.selection = _graph;
        selection.isSelect();
    }

    public void unselect() {
        if (selection != null) {
            selection.notSelect();
            this.selection = null;
        }
    }

    public void addGraph(Graph g) {
        graphs.add(g);
    }

    public void removeGraph(Graph g) {
        graphs.remove(g);
    }

    public ArrayList<Graph> getGraphsList() {
        return this.graphs;
    }

    public void paint(Graphics g) {
        Dimension dim = getSize();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, dim.width, dim.height);

        g.setColor(Color.BLACK);
        for (Graph _Graph : graphs) {
            if (_Graph.hidden == false)
             _Graph.draw(g);
        }

        if (dragLine != null) {
            dragLine.draw(g);
        }
        if (!SelectedArea.isEmpty()) {
            int alpha = 50;
            g.setColor(new Color(52,250,237, alpha));
            g.fillRect(SelectedArea.x, SelectedArea.y, SelectedArea.width, SelectedArea.height);
            g.setColor(new Color(52,250,237));
            g.drawRect(SelectedArea.x, SelectedArea.y, SelectedArea.width, SelectedArea.height);

        }
    }

    public void getGroup() {
        GroupObject _group = new GroupObject();
        for (Graph g: graphs) {
            if (g.selected == true) {
                _group.addGroup(g);
                hidden(g); // 可以考慮用hidden方式
            }
        }
        _group.setBounds();
        graphs.add(_group);
    }

    public void toUnGroup() {
        for (int index = graphs.size() - 1; index >= 0; index--) {
            Graph g = graphs.get(index);
            g.unGroup();
            if (g instanceof GroupObject){
                break;
            }
        }
        repaint();
    }

    private void hidden(Graph _g){
        _g.hidden = true;
    }
}
