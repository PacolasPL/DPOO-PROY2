package view;

import controller.controladorProyecto;
import controller.fileWriter;
import model.actividad;
import model.integrante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class AcabarActividad extends JFrame implements ActionListener {

	Container container = getContentPane();

	MenuActividadCargada mActCargada;
	integrante usuario;
	private controladorProyecto control;

	JLabel labelMensaje = new JLabel("Escriba sus comentarios de finalización: ");

    JTextArea areaComentarios = new JTextArea();;

    JButton botonAcabar = new JButton("Acabar actividad");

    AcabarActividad(integrante amigo, MenuActividadCargada mActCargada, controladorProyecto control)
    {
    	this.mActCargada = mActCargada;
		this.control = control;
    	
    	String[] actividades = amigo.mostrarPendientes();
		System.out.println(actividades);

    	this.usuario = amigo;
    	
    	this.setTitle("Project Manager - '" + control.getActividadActual().getName() + "'");
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
        
        areaComentarios.setBounds(20,50,320,30);

        botonAcabar.setBounds(210,170,140,20);
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);
    	
        container.add(areaComentarios);

        container.add(botonAcabar);
    }
    
    public void addActionEvent() {
    	botonAcabar.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAcabar) {
			String comentarios = areaComentarios.getText();
			control.acabarActividad(comentarios, usuario);
			fileWriter fWriter = new fileWriter();
			try {
				fWriter.actualizarProy(control.getName(), control.getLider(), control.getStartTime(), control.getMinutes());
				control.guardarDatos();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

			this.mActCargada.setVisible(false);
			this.setVisible(false);
			MenuPrincipal mPrin = new MenuPrincipal(usuario, control.getActividades(usuario), control);
			mPrin.setVisible(true);
        }	
	}
}
