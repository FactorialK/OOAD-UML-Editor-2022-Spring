package Main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JMenuBar {
	private Canvas canvas;

	public Menu() {
		canvas = Canvas.getInstance();
		JMenu menu;
		JMenuItem menuitem; // menu item

		menu = new JMenu("File");
		add(menu);
		menu = new JMenu("Edit");
		add(menu);

		menuitem = new JMenuItem("Group");
		menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.getGroup();
			}
		});
		menu.add(menuitem);

		menuitem = new JMenuItem("Unroup");
		menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.toUnGroup();
			}
		});
		menu.add(menuitem);

		menuitem = new JMenuItem("Change Object Name");
		menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toChangeName();
			}
		});
		menu.add(menuitem);
	}

	private void toChangeName() {
		JFrame inputTextFrame = new JFrame("Change Object Name");
		inputTextFrame.setSize(400, 100);
		inputTextFrame.getContentPane().setLayout(new GridLayout(1, 1));

		JPanel panel = null;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JTextField Text = new JTextField("Object Name");
		panel.add(Text);
		inputTextFrame.getContentPane().add(panel);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JButton ok = new JButton("OK");
		panel.add(ok);

		JButton cancel = new JButton("Cancel");
		panel.add(cancel);

		inputTextFrame.getContentPane().add(panel);
		inputTextFrame.setLocationRelativeTo(null);
		inputTextFrame.setVisible(true);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (canvas.selection != null) {
					canvas.selection.changeName(Text.getText());
				}
				inputTextFrame.dispose();
				canvas.repaint();
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextFrame.dispose();
			}
		});

	}
}