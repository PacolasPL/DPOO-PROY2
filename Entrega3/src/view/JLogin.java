package view;

import javax.swing.JTextField;

import model.integrante;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import controller.*;

public class JLogin extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	private controladorProyecto controlador = new controladorProyecto();
	private integrante usuario;
	private Principal principal;
	
	JLabel labelMensaje = new JLabel("¿Ya tienes una cuenta en la app?");
	JLabel labelMensaje2 = new JLabel("Ingresa a tu usuario");
	
    JLabel userLabel = new JLabel("Usuario");
    JLabel passwordLabel = new JLabel("Contraseña");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Iniciar sesión");
    JButton resetButton = new JButton("Borrar todo");
    JCheckBox showPassword = new JCheckBox("Mostrar constraseña");
		
    JLogin(Principal principal)
    {
    	this.principal = principal;
    	this.setTitle("Inicio de sesión");
    	setLayoutManager();
    	setLocationAndSize();
    	addComponentsToContainer();
    	addActionEvent();
    	
		JPanel reg = new JPanel();
		labelMensaje.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		labelMensaje2.setFont(new Font("Yu Gothic", Font.PLAIN, 22));
		
		reg.setLayout(new GridBagLayout());
		reg.setBackground(new Color(160,200,255));
		
		this.setSize(380,500);
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
    	labelMensaje.setBounds(50,50,360,30);
    	labelMensaje2.setBounds(50,75,500,30);
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,120,30);
        resetButton.setBounds(200,300,100,30);
  
  
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);
        container.add(labelMensaje2);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
    
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			String nombre = userTextField.getText();
			char[] passChar = passwordField.getPassword();
			String pass = "";
			
			for(char x : passChar) {
				pass += x;
			}
            try {
				integrante logrado = controlador.iniciarSesion(nombre, pass);
				if(logrado != null) {
					this.usuario = logrado;
					principal.volverInvisible();
					
					PrimerMenu pMenu = new PrimerMenu(logrado);
					pMenu.setVisible(true);
					this.setVisible(false);
				}
				else {
					
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		
		if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
		
		if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
		
	}
  
}
