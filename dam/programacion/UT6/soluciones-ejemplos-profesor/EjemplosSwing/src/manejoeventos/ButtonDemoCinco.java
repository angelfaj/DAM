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
public class ButtonDemoCinco extends JFrame {
	JButton b1;
	JButton b2;

	public ButtonDemoCinco() {
		setLayout(new FlowLayout());

		add(b1 = new JButton("A button"));
		b1.addActionListener((e) -> {
			System.out.println("Thanks for pushing my first button!");
		});

		add(b2 = new JButton("Another button"));
		b2.addActionListener((e) -> {
			System.out.println("Thanks for pushing my second button!");
		});

		setSize(300, 200);
	}

	public static void main(String[] unuxed) {

		SwingUtilities.invokeLater(() -> new ButtonDemoCinco().setVisible(true));
	}
}
