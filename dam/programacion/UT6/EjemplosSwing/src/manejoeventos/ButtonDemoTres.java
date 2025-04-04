package manejoeventos;

/**
 * @author victor
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Demonstrate simple use of Button */
public class ButtonDemoTres extends JFrame {
	JButton b1;
	JButton b2;
	ActionListener handler = new ButtonHandler();

	public ButtonDemoTres() {
		setLayout(new FlowLayout());

		add(b1 = new JButton("A button"));
		b1.addActionListener(handler);

		add(b2 = new JButton("Another button"));
		b2.addActionListener(handler);

		setSize(300, 200);
	}

	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1)
				System.out.println("Thanks for pushing my first button!");
			else
				System.out.println("Thanks for pushing my second button!");
		}
	}

	public static void main(String[] unuxed) {

		SwingUtilities.invokeLater(() -> new ButtonDemoTres().setVisible(true));
	}
}
