package view;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class JRegistrar extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	
	JLabel labelMensaje = new JLabel("¿No tienes una cuenta en la app?");
	JLabel labelMensaje2 = new JLabel("Crea un usuario");
	
	
    JLabel userLabel = new JLabel("Usuario");
    JLabel passwordLabel = new JLabel("Contraseña");
    JLabel mailLabel = new JLabel("Dirección email");
    JTextField userTextField = new JTextField();
    JTextField mailField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Iniciar sesión");
    JButton resetButton = new JButton("Borrar todo");
    JCheckBox showPassword = new JCheckBox("Mostrar constraseña");
		
    JRegistrar()
    {
    	this.setTitle("Registro de usuario");
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
        passwordLabel.setBounds(50,240,100,30);
        
        mailLabel.setBounds(50,195,100,30);
        mailField.setBounds(150,195,150,30);
        
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,240,150,30);
        showPassword.setBounds(150,270,150,30);
        loginButton.setBounds(50,320,120,30);
        resetButton.setBounds(200,320,100,30);
  
  
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);
        container.add(labelMensaje2);
        container.add(userLabel);
        container.add(passwordLabel);
        
        container.add(mailLabel);
        container.add(mailField);
        
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
		if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            mailField.setText("");
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
