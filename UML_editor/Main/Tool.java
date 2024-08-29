package Main;

//import javax.swing.JFrame;
import javax.swing.JPanel;

import Mode.LineMode;
import Mode.ObjectMode;
import Mode.SelectMode;
import Mode.ToolMode;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tool extends JButton implements ActionListener {
    protected Canvas canvas = Canvas.getInstance();
    protected JPanel button = new JPanel();
    private JButton Select_B;
    private JButton AssociationL_B;
    private JButton GeneralizationL_B;
    private JButton CompositionL_B;
    private JButton Class_B;
    private JButton User_B;
    public int currentMode;
    private static final int SelectTool = 1;
    private static final int AssociationTool = 2;
    private static final int GeneralizationTool = 3;
    private static final int CompositionTool = 4;
    private static final int ClassTool = 5;
    private static final int UserCaseTool = 6;

    protected ToolMode mode;

    public JPanel newTool() {
        currentMode = SelectTool;

        button.setPreferredSize(new Dimension(100, 100));

        Select_B = new JButton();
        ImageIcon SBIcon = new ImageIcon("Image/SELECT.png");
        Image sbi = SBIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Select_B.setIcon(new ImageIcon(sbi));
        Select_B.addActionListener(this);
        Select_B.setBackground(Color.white);
        button.add(Select_B);// new JButton("Select"));

        AssociationL_B = new JButton();
        ImageIcon ALIcon = new ImageIcon("Image/ASSOCIATION.png");
        Image ali = ALIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        AssociationL_B.setIcon(new ImageIcon(ali));
        AssociationL_B.addActionListener(this);
        AssociationL_B.setBackground(Color.white);
        button.add(AssociationL_B);

        GeneralizationL_B = new JButton();
        ImageIcon GLIcon = new ImageIcon("Image/GENERALIZATION.png");
        Image gli = GLIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        GeneralizationL_B.setIcon(new ImageIcon(gli));
        GeneralizationL_B.addActionListener(this);
        GeneralizationL_B.setBackground(Color.white);
        button.add(GeneralizationL_B);

        CompositionL_B = new JButton();
        ImageIcon CLIcon = new ImageIcon("Image/COMPOSITION.png");
        Image cli = CLIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        CompositionL_B.setIcon(new ImageIcon(cli));
        CompositionL_B.addActionListener(this);
        CompositionL_B.setBackground(Color.white);
        button.add(CompositionL_B);

        Class_B = new JButton();
        ImageIcon CBIcon = new ImageIcon("Image/CLASS.png");
        Image cbi = CBIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Class_B.setIcon(new ImageIcon(cbi));
        Class_B.addActionListener(this);
        Class_B.setBackground(Color.white);
        button.add(Class_B);

        ImageIcon UBIcon = new ImageIcon("Image/USE_CLASS.png");
        Image ubi = UBIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        User_B = new JButton();
        User_B.setIcon(new ImageIcon(ubi));
        User_B.addActionListener(this);
        User_B.setBackground(Color.white);
        button.add(User_B);

        return button;
    }

    private void resetButtonColor() {
        Select_B.setBackground(Color.WHITE);
        AssociationL_B.setBackground(Color.WHITE);
        GeneralizationL_B.setBackground(Color.WHITE);
        CompositionL_B.setBackground(Color.WHITE);
        Class_B.setBackground(Color.WHITE);
        User_B.setBackground(Color.WHITE);
    }

    private void using(JButton btn){
        btn.setBackground(Color.GRAY);
    }

    public void actionPerformed(ActionEvent e) {
        resetButtonColor();
        if (e.getSource() == Select_B) {
            using(Select_B);
            currentMode = SelectTool;
            mode = new SelectMode();
        }
        else if (e.getSource() == AssociationL_B) {
            using(AssociationL_B);
            currentMode = AssociationTool;
            mode = new LineMode(currentMode);
        } else if (e.getSource() == GeneralizationL_B) {
            using(GeneralizationL_B);
            currentMode = GeneralizationTool;
            mode = new LineMode(currentMode);
        } else if (e.getSource() == CompositionL_B) {
            using(CompositionL_B);
            currentMode = CompositionTool;
            mode = new LineMode(currentMode);
        } else if (e.getSource() == Class_B) {
            using(Class_B);
            currentMode = ClassTool;
            mode = new ObjectMode(currentMode);
        } else if (e.getSource() == User_B) {
            using(User_B);
            currentMode = UserCaseTool;
            mode = new ObjectMode(currentMode);
        } else {
            using(Select_B);
            currentMode = SelectTool;
        }

        canvas.currentMode = mode;
        canvas.setCurrentMode();
    }

}
