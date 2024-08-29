package Main;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class UML_editor extends JFrame{
    private Menu menu;
    private Tool tool;
    private Canvas canvas;

    public UML_editor(){
        menu = new Menu();
        canvas = Canvas.getInstance();//new Canvas();
        tool = new Tool();

        getContentPane().setLayout(new BorderLayout());
		getContentPane().add(menu, BorderLayout.NORTH);
		getContentPane().add(tool.newTool(), BorderLayout.WEST);
		getContentPane().add(canvas, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        UML_editor window = new UML_editor();
        window.setTitle("UML editor");
        window.setSize(1200,700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
}
