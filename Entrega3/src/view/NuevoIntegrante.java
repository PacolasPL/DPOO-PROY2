package view;

import controller.controladorProyecto;
import controller.fileWriter;
import model.integrante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class NuevoIntegrante extends JFrame implements ActionListener {

	Container container = getContentPane();

	private integrante usuario;
	private controladorProyecto control;

	JLabel labelMensaje = new JLabel("Escriba el usuario a añadir al proyecto: ");

    JTextField campoUsuario = new JTextField();

    JButton botonAnadir = new JButton("Añadir integrante");

    NuevoIntegrante(integrante amigo, controladorProyecto control)
    {
		this.control = control;
    	
    	String[] actividades = amigo.mostrarPendientes();
		System.out.println(actividades);

    	this.usuario = amigo;
    	
    	this.setTitle("Project Manager");
    	setLayoutManager();
    	setLocationAndSize();
    	addComponentsToContainer();
    	addActionEvent();

		JPanel reg = new JPanel();
		labelMensaje.setFont(new Font("Yu Gothic", Font.PLAIN, 14));

		reg.setLayout(new GridBagLayout());
		reg.setBackground(new Color(160,200,255));
		
		this.setSize(380,250);
		this.getContentPane().add(reg);
		this.setResizable(true);
	}
    
    public void setLayoutManager()
    {
        container.setLayout(null);
    }
    
    public void setLocationAndSize()
    {
        //Setting location and Size of each components using setBounds() method.
    	labelMensaje.setBounds(20,20,280,30);
        
        campoUsuario.setBounds(20,50,320,30);

        botonAnadir.setBounds(210,170,140,20);
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);
    	
        container.add(campoUsuario);

        container.add(botonAnadir);
    }
    
    public void addActionEvent() {
    	botonAnadir.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAnadir) {
			String nombre = campoUsuario.getText();

			integrante nuevo = this.control.getUsuario(nombre);
			control.agregarIntegrante(nuevo);

			this.setVisible(false);
        }	
	}
}
