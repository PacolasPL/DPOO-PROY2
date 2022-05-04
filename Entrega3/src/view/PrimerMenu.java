package view;

import model.integrante;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PrimerMenu extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	
	private integrante usuario;
	private Principal principal;
	JLabel labelMensaje2 = new JLabel("¿Qué deseas hacer?");
	
	JButton botonCrear = new JButton("Crear un proyecto");
	JButton botonAbrir = new JButton("Abrir un proyecto existente");
	JButton botonConsultar = new JButton("Consultar mis proyectos");
	
	JButton botonAcabar = new JButton("Cerrar sesión");
		
    PrimerMenu(integrante usuario, Principal principal)
    {
    	this.setTitle("Project Manager");
    	
    	this.usuario = usuario;
		this.principal = principal;
    	
    	String name = usuario.getName();
    	String mensaje = "Bienvenido, " + name;
    	JLabel labelMensaje = new JLabel(mensaje);
    	
    	setLayoutManager();
    	setLocationAndSize(labelMensaje);
    	addComponentsToContainer(labelMensaje);
    	addActionEvent();
    	
		JPanel reg = new JPanel();
		labelMensaje.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		labelMensaje2.setFont(new Font("Yu Gothic", Font.PLAIN, 22));
		
		reg.setLayout(new GridBagLayout());
		reg.setBackground(new Color(160,200,255));
		
		this.setSize(450,300);
		this.getContentPane().add(reg);
		this.setResizable(false);
		
	
	}
    
    public void setLayoutManager()
    {
        container.setLayout(null);
    }
    
    public void setLocationAndSize(JLabel labelMensaje)
    {
        //Setting location and Size of each components using setBounds() method.
    	labelMensaje.setBounds(50,50,360,30);
    	labelMensaje2.setBounds(50,75,500,30);
    	
        botonCrear.setBounds(50,125,190,20);
        botonAbrir.setBounds(50,150,190,20);
        botonConsultar.setBounds(50,175,190,20);
        
        botonAcabar.setBounds(270,147,130,30);
  
    }
    
    public void addComponentsToContainer(JLabel labelMensaje)
    {
       //Adding each components to the Container
    	container.add(labelMensaje);
        container.add(labelMensaje2);
        
        container.add(botonCrear);
        container.add(botonAbrir);
        container.add(botonConsultar);
        
        container.add(botonAcabar);
    }

    public void addActionEvent() {
    	botonCrear.addActionListener(this);
    	botonAbrir.addActionListener(this);
		botonConsultar.addActionListener(this);
		botonAcabar.addActionListener(this);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonCrear) {
			CrearProyecto crearProy = new CrearProyecto(usuario);
	        crearProy.setVisible(true);
        }
		
		if (e.getSource() == botonAbrir) {
			AbrirProyecto abrirProy = new AbrirProyecto(this.usuario, this);
            abrirProy.setVisible(true);
        }

		if (e.getSource() == botonConsultar) {
			ConsultarProyectos conProy = new ConsultarProyectos(usuario, this);
			conProy.setVisible(true);
		}

		if (e.getSource() == botonAcabar) {
			this.setVisible(false);
			this.principal.setVisible(true);
		}
	}
    
}
  

