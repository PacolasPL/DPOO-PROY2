package view;

import javax.swing.JTextField;

import controller.controladorProyecto;
import controller.loaderProyect;
import model.integrante;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AbrirProyecto extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	
	PrimerMenu pMenu;
	integrante usuario;
	
	JLabel labelMensaje = new JLabel("Se encontraron los siguientes proyectos");
    
    JComboBox comboProyectos;
    
	JLabel labelSeleccion = new JLabel("Se seleccionó: ");
    JButton botonAbrir = new JButton("Abrir");
		
    AbrirProyecto(integrante amigo, PrimerMenu pMenu)
    {
    	this.pMenu = pMenu;
    	
    	String[] lista = amigo.getProyListAmi();
    	this.comboProyectos = new JComboBox(lista);
    	this.usuario = amigo;
    	comboProyectos.setSelectedIndex(0);
    	comboProyectos.addActionListener(this);
    	
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
        
        comboProyectos.setBounds(20,80,280,30);
        
        labelSeleccion.setBounds(20,160,200,30);
        botonAbrir.setBounds(275,170,75,20);
  
  
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);

    	
        container.add(comboProyectos);
        
        container.add(labelSeleccion);
        container.add(botonAbrir);
    }
    
    public void addActionEvent() {
    	botonAbrir.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == comboProyectos) {
			String nombreProyecto = (String) comboProyectos.getSelectedItem();
			labelSeleccion.setText("Se seleccionó: " + nombreProyecto);
        }
		
		if (e.getSource() == botonAbrir) {
			String nombreProyecto = (String) comboProyectos.getSelectedItem();
			try {
				controladorProyecto control = loaderProyect.cargarArchivo(nombreProyecto);
				if (control != null) {
					control = loaderProyect.cargarArchivo(nombreProyecto);
					boolean ingreso = control.iniciarSesionProyecto(usuario.getName());
					if (ingreso) {
						String[] actividades = control.getActividades(usuario);
						MenuPrincipal mPrincipal = new MenuPrincipal(usuario, actividades, control);
						mPrincipal.setVisible(true);
						this.pMenu.setVisible(false);
					}
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			this.setVisible(false);
			
        }	
	}
}
