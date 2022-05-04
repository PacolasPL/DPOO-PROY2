package view;

import javax.swing.JTextField;

import controller.controladorProyecto;
import controller.fileWriter;
import model.integrante;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class JOfflineAct extends JFrame implements ActionListener{
    private Principal principal;
    private fileWriter escritor = new fileWriter();
    private controladorProyecto control;
    Container container = getContentPane();

    JLabel labelMensaje = new JLabel("¿Faltan cosas por agregar?");
    JLabel labelMensaje2 = new JLabel("Crea una nueva actividad.");

    JLabel actLabel = new JLabel("Nombre de la actividad:");
    JLabel tipoLabel = new JLabel("Escriba el tipo de actividad:");
    JLabel integLabel = new JLabel("Nombre del integrante a cargo:");
    JLabel comLabel = new JLabel("Escriba una descripción:");


    JTextField actField = new JTextField();
    JTextField tipoField = new JTextField();
    JTextField userTField = new JTextField();
    JTextField comField = new JTextField();
    integrante user;
    JButton btnAgregar = new JButton("Agregar");
    JButton resetButton = new JButton("Borrar todo");

    JOfflineAct(controladorProyecto control, integrante user)
    {
        this.user = user;
        this.control = control;
        this.principal = principal;
        this.setTitle("Agregar actividades al proyecto.");
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        JPanel reg = new JPanel();
        labelMensaje.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
        labelMensaje2.setFont(new Font("Yu Gothic", Font.PLAIN, 22));

        reg.setLayout(new GridBagLayout());
        reg.setBackground(new Color(160,200,255));

        this.setSize(440,300);
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
        labelMensaje2.setBounds(50,80,360,30);

        actLabel.setBounds(20,120,200,20);
        tipoLabel.setBounds(20,140,200,20);
        integLabel.setBounds(20,160,200,20);
        comLabel.setBounds(20,180,200,20);

        actField.setBounds(240,120,150,20);
        tipoField.setBounds(240,140,150,20);
        userTField.setBounds(240,160,150,20);
        comField.setBounds(240,180,150,20);

        btnAgregar.setBounds(20,220,100,30);
        resetButton.setBounds(290,220,100,30);
    }

    public void addComponentsToContainer()
    {
        //Adding each components to the Container
        container.add(labelMensaje);
        container.add(labelMensaje2);

        container.add(actLabel);
        container.add(tipoLabel);
        container.add(integLabel);
        container.add(comLabel);

        container.add(actField);
        container.add(tipoField);
        container.add(userTField);
        container.add(comField);

        container.add(btnAgregar);
        container.add(resetButton);
    }

    public void addActionEvent() {
        resetButton.addActionListener(this);
        btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            actField.setText("");
            tipoField.setText("");
            userTField.setText("");
            comField.setText("");
        }

        if (e.getSource() == btnAgregar) {
            String usuario = userTField.getText().strip();
            integrante aCargoDe = user;
            if (control.isIntegrante(usuario))
            {
                String nameAct = actField.getText().strip();
                String tipoAct = tipoField.getText().strip();
                if (user.getName().equals(usuario)){
                    user =  control.getUsuario(usuario);
                    aCargoDe =  user;
                }
                control.agregarActividad(aCargoDe, nameAct, tipoAct);
                try {
                    control.guardarDatos();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                this.setVisible(false);
            }
        }

    }

}

