package view;

import model.integrante;
import model.proyecto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.controladorProyecto;
import controller.loaderProyect;


public class MenuPrincipal extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	private integrante usuario;
	private boolean isJefe;
	private controladorProyecto control;
	
	JLabel labelCreacion;
	JLabel labelCreador;
	
	JLabel labelMensaje2 = new JLabel("?C?mo vas a iniciar?");
	
	JButton botonPendientes = new JButton("Ver tareas pendientes");
	JButton botonIniciar = new JButton("Iniciar una actividad");
	JButton botonConsultarRegistros = new JButton("Consultar registros");
	JButton botonAnadir = new JButton("A?adir integrante");
	JButton botonCrear = new JButton("Crear actividad");
		
    MenuPrincipal(integrante usuario, String[] actividades, controladorProyecto control)
    {
    	String name = control.getName();
		this.usuario = usuario;
		this.control = control;
		
    	boolean isJefe = usuario.getName().equals(control.getLider().getName());
    	this.isJefe = isJefe;
    	
    	this.labelCreacion = new JLabel("Fecha de creaci?n: " + control.getStartTime());
    	this.labelCreador = new JLabel("Creador del proyecto: " + control.getLider().getName());
    	
    	this.setTitle("Project Manager - en " + name);
    	
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
    	labelMensaje.setBounds(50,30,360,30);
    	
    	labelCreacion.setBounds(50,50,360,20);
    	labelCreador.setBounds(50,65,360,20);
    	
    	labelMensaje2.setBounds(50,90,500,30);
    	
        botonPendientes.setBounds(50,125,190,20);
        botonIniciar.setBounds(50,150,190,20);
		botonConsultarRegistros.setBounds(50,175,190,20);
		botonAnadir.setBounds(50,200,190,20);
		botonCrear.setBounds(50,225,190,20);
  
    }
    
    public void addComponentsToContainer(JLabel labelMensaje)
    {
       //Adding each components to the Container
    	container.add(labelMensaje);
    	
    	container.add(labelCreacion);
    	container.add(labelCreador);
    	
        container.add(labelMensaje2);
        
        container.add(botonPendientes);
        container.add(botonIniciar);
		container.add(botonConsultarRegistros);
		container.add(botonAnadir);
		container.add(botonCrear);
    }

	public void addActionEvent() {
		botonPendientes.addActionListener(this);
		botonIniciar.addActionListener(this);
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
		if (e.getSource() == botonIniciar) {
			IniciarActividad inAct = new IniciarActividad(this.usuario, this, this.control);
			inAct.setVisible(true);
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
  

