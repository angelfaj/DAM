package vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends JFrame {
    private JTextField txtNombre, txtEdad, txtPeso;
    private JComboBox<String> comboEspecie;
    private JRadioButton rbtnMacho, rbtnHembra;
    private ButtonGroup grupoSexo;
    private JButton btnGuardarTxt, btnGuardarObj, btnCargarTxt, btnCargarObj;
    private JTextArea areaAnimales;

    public VentanaPrincipal() {
        setTitle("Gestor de Animales");
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelSuperior.setBackground(Color.ORANGE);
        panelSuperior.setBounds(0, 0, 484, 243);
        panelSuperior.setLayout(null);

        JLabel label = new JLabel("Nombre:");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(0, 0, 164, 33);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panelSuperior.add(label);
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        txtNombre.setBounds(162, 0, 322, 33);
        panelSuperior.add(txtNombre);

        JLabel label_1 = new JLabel("Edad:");
        label_1.setFont(new Font("Arial", Font.PLAIN, 14));
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setBounds(0, 33, 164, 33);
        panelSuperior.add(label_1);
        txtEdad = new JTextField();
        txtEdad.setFont(new Font("Arial", Font.PLAIN, 14));
        txtEdad.setBounds(162, 33, 322, 33);
        panelSuperior.add(txtEdad);

        JLabel label_2 = new JLabel("Peso:");
        label_2.setFont(new Font("Arial", Font.PLAIN, 14));
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setBounds(0, 66, 164, 33);
        panelSuperior.add(label_2);
        txtPeso = new JTextField();
        txtPeso.setFont(new Font("Arial", Font.PLAIN, 14));
        txtPeso.setBounds(162, 66, 322, 33);
        panelSuperior.add(txtPeso);

        JLabel label_3 = new JLabel("Especie:");
        label_3.setFont(new Font("Arial", Font.PLAIN, 14));
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        label_3.setBounds(0, 99, 164, 33);
        panelSuperior.add(label_3);
        comboEspecie = new JComboBox<>(new String[] { "Perro", "Gato", "Conejo", "Ave" });
        comboEspecie.setFont(new Font("Arial", Font.PLAIN, 14));
        comboEspecie.setBounds(162, 99, 322, 33);
        panelSuperior.add(comboEspecie);

        JLabel label_4 = new JLabel("Sexo:");
        label_4.setFont(new Font("Arial", Font.PLAIN, 14));
        label_4.setHorizontalAlignment(SwingConstants.CENTER);
        label_4.setBounds(0, 132, 164, 33);
        panelSuperior.add(label_4);
        JPanel panelSexo = new JPanel();
        panelSexo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        panelSexo.setBounds(162, 132, 322, 33);
        rbtnMacho = new JRadioButton("Macho");
        rbtnMacho.setFont(new Font("Arial", Font.PLAIN, 14));
        rbtnMacho.setBounds(42, 5, 93, 23);
        rbtnHembra = new JRadioButton("Hembra");
        rbtnHembra.setFont(new Font("Arial", Font.PLAIN, 14));
        rbtnHembra.setBounds(150, 5, 93, 23);
        grupoSexo = new ButtonGroup();
        getContentPane().setLayout(null);
        grupoSexo.add(rbtnMacho);
        grupoSexo.add(rbtnHembra);
        panelSexo.setLayout(null);
        panelSexo.add(rbtnMacho);
        panelSexo.add(rbtnHembra);
        panelSuperior.add(panelSexo);

        getContentPane().add(panelSuperior);

        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(0, 176, 484, 60);
        panelSuperior.add(panelBotones);
        btnGuardarTxt = new JButton("Guardar TXT");
        btnGuardarTxt.setFont(new Font("Arial", Font.PLAIN, 14));
        btnGuardarTxt.setBounds(0, 0, 121, 60);
        btnGuardarObj = new JButton("Guardar OBJ");
        btnGuardarObj.setFont(new Font("Arial", Font.PLAIN, 14));
        btnGuardarObj.setBounds(121, 0, 121, 60);
        btnCargarTxt = new JButton("Cargar TXT");
        btnCargarTxt.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCargarTxt.setBounds(242, 0, 121, 60);
        btnCargarObj = new JButton("Cargar OBJ");
        btnCargarObj.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCargarObj.setBounds(363, 0, 121, 60);
        panelBotones.setLayout(null);
        panelBotones.add(btnGuardarTxt);
        panelBotones.add(btnGuardarObj);
        panelBotones.add(btnCargarTxt);
        panelBotones.add(btnCargarObj);

        areaAnimales = new JTextArea();
        areaAnimales.setText("Carga la información de un fichero pulsando el botón correspondiente.");
        areaAnimales.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        areaAnimales.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaAnimales);
        scroll.setEnabled(false);
        scroll.setBounds(0, 254, 484, 50);
        getContentPane().add(scroll);
    }
    
    //una forma de mostrar los mensajes más elegante
    public void mostrarMensaje(String sms) {
    	JOptionPane.showMessageDialog(this, sms);
    }

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	public JTextField getTxtPeso() {
		return txtPeso;
	}

	public void setTxtPeso(JTextField txtPeso) {
		this.txtPeso = txtPeso;
	}

	public JComboBox<String> getComboEspecie() {
		return comboEspecie;
	}

	public void setComboEspecie(JComboBox<String> comboEspecie) {
		this.comboEspecie = comboEspecie;
	}

	public JRadioButton getRbtnMacho() {
		return rbtnMacho;
	}

	public void setRbtnMacho(JRadioButton rbtnMacho) {
		this.rbtnMacho = rbtnMacho;
	}

	public JRadioButton getRbtnHembra() {
		return rbtnHembra;
	}

	public void setRbtnHembra(JRadioButton rbtnHembra) {
		this.rbtnHembra = rbtnHembra;
	}

	public ButtonGroup getGrupoSexo() {
		return grupoSexo;
	}

	public void setGrupoSexo(ButtonGroup grupoSexo) {
		this.grupoSexo = grupoSexo;
	}

	public JButton getBtnGuardarTxt() {
		return btnGuardarTxt;
	}

	public void setBtnGuardarTxt(JButton btnGuardarTxt) {
		this.btnGuardarTxt = btnGuardarTxt;
	}

	public JButton getBtnGuardarObj() {
		return btnGuardarObj;
	}

	public void setBtnGuardarObj(JButton btnGuardarObj) {
		this.btnGuardarObj = btnGuardarObj;
	}

	public JButton getBtnCargarTxt() {
		return btnCargarTxt;
	}

	public void setBtnCargarTxt(JButton btnCargarTxt) {
		this.btnCargarTxt = btnCargarTxt;
	}

	public JButton getBtnCargarObj() {
		return btnCargarObj;
	}

	public void setBtnCargarObj(JButton btnCargarObj) {
		this.btnCargarObj = btnCargarObj;
	}

	public JTextArea getAreaAnimales() {
		return areaAnimales;
	}

	public void setAreaAnimales(JTextArea areaAnimales) {
		this.areaAnimales = areaAnimales;
	}
    
    
    
}
