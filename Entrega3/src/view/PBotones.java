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
	
	private Principal principal;
	GridBagConstraints constraints = new GridBagConstraints();
	Color lightblue = new Color(255,255,255);

	PBotones(Principal principal){
		this.principal = principal;
		this.setLayout(new GridBagLayout());
		
		JLabel labelMensaje = new JLabel("Bienvenido, \npara iniciar, indique qué desea hacer");
		JButton buttonNuevo = new JButton("Iniciar sesión");
		JButton buttonRegistrar = new JButton("Registrarse");
		
		addLabel(labelMensaje, 1, 0, labelMensaje);
		addButton(buttonNuevo, 1, 1, buttonNuevo);
		addButton(buttonRegistrar , 1,  2, buttonRegistrar);
		
		buttonNuevo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JLogin registro = new JLogin(principal);
				registro.setVisible(true);
			}
			
		});
		
		buttonRegistrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JRegistrar registrar = new JRegistrar(principal);
				registrar.setVisible(true);
				
			}
			
		});
		
	}
	
	void addButton(Component component, int x, int y,JButton button) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.insets = new Insets(5, 80, 5, 80);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        button.setAlignmentX(this.CENTER_ALIGNMENT);
        button.setBackground(new Color(255,255,255));
        button.setForeground(Color.black);
        
        add(component, constraints);
      }
	
	void addLabel(Component component, int x, int y,JLabel label) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.insets = new Insets(5, 80, 5, 80);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        label.setAlignmentX(this.CENTER_ALIGNMENT);
        label.setBackground(new Color(255,255,255));
        label.setForeground(Color.black);
        
        add(component, constraints);
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	

}
