package view;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Font;

public class JBarraArriba extends JPanel{
	
	GridBagConstraints constraints = new GridBagConstraints();
	Color lightblue = new Color(135,136,255);

	JBarraArriba(){
		this.setBackground(lightblue);
		this.setLayout(new GridBagLayout());
		this.setSize(300,500);
		/*
		JButton cuenta = new JButton("Info");
		addButton(cuenta, cuenta);
		
		JButton proyecto = new JButton("Proyecto");
		addButton(proyecto ,  proyecto);
		
		JButton ayuda = new JButton("Ayuda");
		addButton(ayuda, ayuda);
		*/
		JLabel prin = new JLabel("Proyect Manager");
		prin.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		this.add(prin);
	
		
		
	}
	void addButton(Component component, JButton button) {
		
        add(component, constraints);
      }

}
