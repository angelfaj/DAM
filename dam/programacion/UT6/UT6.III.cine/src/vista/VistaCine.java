package vista;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class VistaCine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JRadioButton rdbtnSi, rdbtnNo;
	private ButtonGroup rdbtnGroup;
	
	public VistaCine() {
		setTitle("Compra de butacas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setSize(151, 20);
		textFieldEmail.setLocation(21, 48);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(21, 120, 50, 23);
		contentPane.add(rdbtnNo);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(100, 120, 50, 23);
		contentPane.add(rdbtnSi);

		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnSi);
		rdbtnGroup.add(rdbtnNo);
		
		
		setVisible(true);
		setResizable(false);
	}
}
