package view;

import controller.controladorProyecto;
import model.actividad;
import model.integrante;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IniciarActividad extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	
	MenuPrincipal mPrin;
	integrante usuario;
	private controladorProyecto control;
	
	JLabel labelMensaje = new JLabel("Elija la actividad en la que desea trabajar");
    
    JComboBox comboActividades;
    
	JLabel labelSeleccion = new JLabel("Se seleccionó: ");
    JButton botonIniciar = new JButton("Iniciar");
		
    IniciarActividad(integrante amigo, MenuPrincipal mPrin, controladorProyecto control)
    {
    	this.mPrin = mPrin;
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
        
        labelSeleccion.setBounds(20,160,200,30);
        botonIniciar.setBounds(275,170,75,20);
  
  
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);

    	
        container.add(comboActividades);
        
        container.add(labelSeleccion);
        container.add(botonIniciar);
    }
    
    public void addActionEvent() {
    	botonIniciar.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == comboActividades) {
			String nombreActividad = (String) comboActividades.getSelectedItem();
			labelSeleccion.setText("Se seleccionó: " + nombreActividad);
        }
		
		if (e.getSource() == botonIniciar) {
			String nombreActividad = (String) comboActividades.getSelectedItem();
			actividad act = this.usuario.getActividad(nombreActividad);
			control.iniciarActividad(this.usuario, act);

			MenuActividadCargada mActCargada = new MenuActividadCargada(this.usuario, control);
			mActCargada.setVisible(true);
			this.setVisible(false);
			this.mPrin.setVisible(false);
        }	
	}
}
