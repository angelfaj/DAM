package manejoeventos;

/**
 * @author victor
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EjemploItemListener extends JFrame implements ItemListener {

	JCheckBox bold = new JCheckBox("Bold");
	JCheckBox italic = new JCheckBox("Italic");
	JTextField txt = new JTextField(20);
	private int valBold = Font.PLAIN;
	private int valItalic = Font.PLAIN;

	public EjemploItemListener() {
		JPanel panel = new JPanel();
		bold.addItemListener(this);
		italic.addItemListener(this);
		txt.setText("Esto es un ejemplo");
		panel.add(txt);
		panel.add(bold);
		panel.add(italic);
		this.setContentPane(panel);
		this.setSize(new Dimension(400, 70));
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == bold) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				valBold = Font.BOLD;
			} else {
				valBold = Font.PLAIN;
			}
		}
		if (e.getSource() == italic) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				valItalic = Font.ITALIC;
			} else {
				valItalic = Font.PLAIN;
			}
		}
		Font font = new Font("Courier", valBold | valItalic, 12);
		txt.setFont(font);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new EjemploItemListener();
		});
	}
}

