package view;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JRegistro extends JFrame{
	GridBagConstraints bgc = new GridBagConstraints();
	JRegistro() {
		JPanel reg = new JPanel();
		
		reg.setLayout(new GridBagLayout());
		reg.setBackground(new Color(255,5,5));
		
		JLabel name = new JLabel();
		name.setText("Digite su usuario:");
		
		JTextField nombre = new JTextField();

		
		JLabel contra = new JLabel();
		contra.setText("Digite su contrasenia:");

		JTextField pass = new JTextField();
	
		reg.add(name, bgc);
		reg.add(nombre, bgc);
		reg.add(contra, bgc);
		reg.add(pass,bgc);
		
		this.setSize(300,300);
		this.getContentPane().add(reg);
		this.setResizable(false);

	
	}
}
