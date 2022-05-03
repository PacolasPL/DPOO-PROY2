package view;

import javax.swing.JTextField;

import controller.controladorProyecto;
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


public class AbrirProyecto extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	
	JLabel labelMensaje = new JLabel("Se encontraron los siguientes proyectos");
    
    JComboBox comboProyectos ;
	JLabel labelSeleccion = new JLabel("Se seleccion�: ");
    JButton botonAbrir = new JButton("Abrir");
  
		
    AbrirProyecto(integrante amigo)
    {
    	String[] lista = amigo.getProyListAmi();
    	this.comboProyectos = new JComboBox(lista);
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
		
		
		
	}
  
}
