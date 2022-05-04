package view;

import controller.controladorProyecto;
import model.integrante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuActividadCargada extends JFrame implements ActionListener {

	Container container = getContentPane();
	private integrante usuario;
	private boolean isJefe;
	private controladorProyecto control;

	JLabel labelActividad;
	JLabel labelCreacion;
	JLabel labelCreador;

	JLabel labelMensaje2 = new JLabel("¿Cómo vas a iniciar?");

	JButton botonPendientes = new JButton("Ver tareas pendientes");
	JButton botonAcabar = new JButton("Acabar una actividad");
	JButton botonConsultarRegistros = new JButton("Consultar registros");
	JButton botonAnadir = new JButton("Añadir integrante");
	JButton botonCrear = new JButton("Crear actividad");

    MenuActividadCargada(integrante usuario, controladorProyecto control)
    {
		String name = control.getName();
		String nameAct = control.getActividadActual().getName();
		this.usuario = usuario;
		this.control = control;
		
    	boolean isJefe = usuario.getName().equals(control.getLider().getName());
    	this.isJefe = isJefe;

		this.labelActividad = new JLabel("Actividad activa: " + nameAct);
    	this.labelCreacion = new JLabel("Fecha de creación: " + control.getStartTime());
    	this.labelCreador = new JLabel("Creador del proyecto: " + control.getLider().getName());
    	
    	this.setTitle("Project Manager - '" + nameAct + "'");
    	
    	String mensaje = "Bienvenido a " + name;
    	JLabel labelMensaje = new JLabel(mensaje);
    	
    	setLayoutManager();
    	setLocationAndSize(labelMensaje);
    	addComponentsToContainer(labelMensaje);
    	
		JPanel reg = new JPanel();
		labelMensaje.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelMensaje2.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		
		reg.setLayout(new GridBagLayout());
		reg.setBackground(new Color(160,200,255));
		
		this.setSize(450,300);
		this.getContentPane().add(reg);
		this.setResizable(false);
		this.addActionEvent();
	
	}
    
    public void setLayoutManager()
    {
        container.setLayout(null);
    }
    
    public void setLocationAndSize(JLabel labelMensaje)
    {
        //Setting location and Size of each components using setBounds() method.
		labelActividad.setBounds(50,10,360,20);

		labelMensaje.setBounds(50,30,360,30);
    	
    	labelCreacion.setBounds(50,50,360,20);
    	labelCreador.setBounds(50,65,360,20);
    	
    	labelMensaje2.setBounds(50,90,500,30);
    	
        botonPendientes.setBounds(50,125,190,20);
        botonAcabar.setBounds(50,150,190,20);
		botonConsultarRegistros.setBounds(50,175,190,20);
		botonAnadir.setBounds(50,200,190,20);
    }
    
    public void addComponentsToContainer(JLabel labelMensaje)
    {
       //Adding each components to the Container
		container.add(labelActividad);

    	container.add(labelMensaje);
    	
    	container.add(labelCreacion);
    	container.add(labelCreador);
    	
        container.add(labelMensaje2);
        
        container.add(botonPendientes);
        container.add(botonAcabar);
		container.add(botonConsultarRegistros);
		container.add(botonAnadir);
		container.add(botonCrear);
    }

	public void addActionEvent() {
		botonPendientes.addActionListener(this);
		botonAcabar.addActionListener(this);
		botonConsultarRegistros.addActionListener(this);
		botonAnadir.addActionListener(this);
		botonCrear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonPendientes) {
			VerPendientes verPend = new VerPendientes(this.usuario, this.control);
			verPend.setVisible(true);
		}
		if (e.getSource() == botonAcabar) {
			AcabarActividad acabarAct = new AcabarActividad(usuario, this, this.control);
			acabarAct.setVisible(true);
		}
		if (e.getSource() == botonConsultarRegistros) {
			ConsultarRegistros conReg = new ConsultarRegistros(this.usuario, this.control);
			conReg.setVisible(true);
		}
		if (e.getSource() == botonAnadir) {
			NuevoIntegrante nvInteg = new NuevoIntegrante(this.usuario, this.control);
			nvInteg.setVisible(true);
		}
		if (e.getSource() == botonCrear) {
			JOfflineAct offlineAct = new JOfflineAct(this.control, this.usuario);
			offlineAct.setVisible(true);
		}
	}
}
  

