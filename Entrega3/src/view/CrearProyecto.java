package view;

import javax.swing.JTextField;

import controller.controladorProyecto;
import controller.fileWriter;
import model.integrante;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CrearProyecto extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	private fileWriter escritor = new fileWriter();
	private controladorProyecto controlador = new controladorProyecto();
	private integrante usuario;
	
	JLabel labelMensaje = new JLabel("Ingrese el nombre de su nuevo proyecto");
    
    JLabel nombreLabel = new JLabel("Nombre del proyecto");
    JLabel disponibleLabel = new JLabel("");
    JTextField nombreField = new JTextField();
    
    JButton botonRevisar = new JButton("Revisar disponibilidad");
    JButton botonCrear = new JButton("Crear proyecto");
		
    CrearProyecto(integrante usuario)
    {
    	this.usuario = usuario;
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
		this.setResizable(false);

	
	}
    
    public void setLayoutManager()
    {
        container.setLayout(null);
    }
    
    public void setLocationAndSize()
    {
        //Setting location and Size of each components using setBounds() method.
    	labelMensaje.setBounds(20,50,360,30);
        
        nombreField.setBounds(20,100,200,20);
        disponibleLabel.setBounds(230,120,125,30);
        nombreLabel.setBounds(20,120,125,30);
        
        botonRevisar.setBounds(20,160,160,30);
        botonCrear.setBounds(200,160,130,30);
  
  
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);
    	
        container.add(nombreField);
        container.add(disponibleLabel);
        container.add(nombreLabel);
        
        container.add(botonRevisar);
        container.add(botonCrear);
    }
    
    public void addActionEvent() {
    	botonRevisar.addActionListener(this);
    	botonCrear.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonRevisar) {
            if(usuario.getProyect() == null) {
            	disponibleLabel.setText("¡Disponible!");
            }
            else if(usuario.getProyect().contains(nombreField.getText())) {
            	disponibleLabel.setText("¡No disponible!");
            }
            else {
            	disponibleLabel.setText("¡Disponible!");
            }
        }
		
		if (e.getSource() == botonCrear) {
            String nombre = nombreField.getText();
            try {
				escritor.writeProy(nombre, usuario);
				controlador.addProyectsOfAmi(usuario, nombre, true);
				this.setVisible(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
	}
}
