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
public class ButtonDemoDos extends JFrame implements ActionListener {
	JButton b1;
	JButton b2;
	public ButtonDemoDos() {
		setLayout(new FlowLayout());
		
		add(b1 = new JButton("A button"));
		b1.addActionListener(this);
		
		add(b2 = new JButton("Another button"));
		b2.addActionListener(this);
		
		setSize(300, 200);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == b1)
			System.out.println("Thanks for pushing my first button!");
		else
			System.out.println("Thanks for pushing my second button!");
	}

	public static void main(String[] unuxed) {
		
		SwingUtilities.invokeLater(() -> new ButtonDemoDos().setVisible(true));
	}
}
