package view;

import controller.controladorProyecto;
import model.actividad;
import model.integrante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VerPendientes extends JFrame implements ActionListener {

	Container container = getContentPane();

	integrante usuario;
	private controladorProyecto control;

	JLabel labelMensaje = new JLabel("Se encontraron las siguientes actividades");

    JComboBox comboActividades;

    JButton botonCerrar = new JButton("Cerrar");

    VerPendientes(integrante amigo, controladorProyecto control)
    {
		this.control = control;
    	
    	String[] actividades = amigo.mostrarPendientes();
		System.out.println(actividades);

    	this.comboActividades = new JComboBox(actividades);
    	this.usuario = amigo;

    	comboActividades.setSelectedIndex(0);
    	comboActividades.addActionListener(this);
    	
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
    	labelMensaje.setBounds(20,50,280,30);
        
        comboActividades.setBounds(20,80,280,30);

        botonCerrar.setBounds(275,170,75,20);
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);

    	
        container.add(comboActividades);

        container.add(botonCerrar);
    }
    
    public void addActionEvent() {
    	botonCerrar.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botonCerrar) {
			this.setVisible(false);
        }	
	}
}
