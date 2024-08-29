package Mode;

import java.awt.event.MouseEvent;

import Shape.Objects;

public class ObjectMode extends ToolMode{
    private int mode;
    private GraphicsFactoryInterface GraphicsFactory = new GraphicsFactory();
    public ObjectMode(int setMode){
        mode = setMode;
    }
    public void mousePressed(MouseEvent e){
        Objects obj = GraphicsFactory.drawObject(mode,e.getPoint());
        canvas.addGraph(obj);
        canvas.repaint();
    }
}
