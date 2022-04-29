package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PBotones extends JPanel implements ActionListener{
	
	GridBagConstraints constraints = new GridBagConstraints();
	Color lightblue = new Color(51,136,255);

	PBotones(){
		this.setLayout(new GridBagLayout());
		
		JButton buttonNuevo = new JButton("Iniciar Sesion");
		JButton buttonRegistrar = new JButton("Registrarse");
		addButton(buttonNuevo, 1, 0, buttonNuevo);
		addButton(buttonRegistrar , 1,  1, buttonRegistrar);
		
		buttonNuevo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JRegistro registro = new JRegistro();
				registro.setVisible(true);
				
			}
			
		});
		
	}
	
	void addButton(Component component, int x, int y,JButton button) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.insets = new Insets(5, 80, 5, 80);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        button.setAlignmentX(this.CENTER_ALIGNMENT);
        button.setBackground(new Color(0,2,222));
        button.setForeground(Color.black);
        
        add(component, constraints);
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	

}
