package Mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Main.Canvas;

public abstract class ToolMode implements MouseListener, MouseMotionListener {
    protected Canvas canvas = Canvas.getInstance();  
    // mouse event
    public void mouseClicked(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
      
    }
    ////mouse motion
    public void mouseMoved(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){

    }
}
