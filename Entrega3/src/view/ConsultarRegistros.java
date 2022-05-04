package view;

import controller.controladorProyecto;
import model.integrante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConsultarRegistros extends JFrame implements ActionListener {

	Container container = getContentPane();

	PrimerMenu pMenu;
	integrante usuario;
	private controladorProyecto control;

	JLabel labelMensaje = new JLabel("Se encontraron los siguientes registros: ");
	JLabel labelActividad = new JLabel("");
	JLabel labelAmigo = new JLabel("");
	JLabel labelInicio = new JLabel("");
	JLabel labelFinal = new JLabel("");
	JLabel labelTranscurrido = new JLabel("");
	JLabel labelComentarios = new JLabel("");

    JComboBox comboRegistros;

	JLabel labelSeleccion = new JLabel("Se seleccionó: ");

    ConsultarRegistros(integrante amigo, controladorProyecto control)
    {
    	this.pMenu = pMenu;
		this.control = control;

    	String[] set = control.getLogData();
    	this.comboRegistros = new JComboBox(set);
    	this.usuario = amigo;

    	comboRegistros.setSelectedIndex(0);
    	comboRegistros.addActionListener(this);
    	
    	this.setTitle("Project Manager");
    	setLayoutManager();
    	setLocationAndSize();
    	addComponentsToContainer();
		JPanel reg = new JPanel();
		labelMensaje.setFont(new Font("Yu Gothic", Font.PLAIN, 14));

		reg.setLayout(new GridBagLayout());
		reg.setBackground(new Color(160,200,255));
		
		this.setSize(450,360);
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
        
        comboRegistros.setBounds(20,80,360,30);

		labelActividad.setBounds(20,110,360,20);
		labelAmigo.setBounds(20,130,360,20);
		labelInicio.setBounds(20,150,360,20);
		labelFinal.setBounds(20,170,360,20);
		labelTranscurrido.setBounds(20,190,360,20);
		labelComentarios.setBounds(20,210,360,60);
        
        labelSeleccion.setBounds(20,280,340,30);
    }
    
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(labelMensaje);
    	
        container.add(comboRegistros);

		container.add(labelActividad);
		container.add(labelAmigo);
		container.add(labelInicio);
		container.add(labelFinal);
		container.add(labelTranscurrido);
		container.add(labelComentarios);

        container.add(labelSeleccion);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == comboRegistros) {
			int indexProyecto = (int) comboRegistros.getSelectedIndex();
			String nombreProyecto = (String) comboRegistros.getSelectedItem();

			labelSeleccion.setText("Se seleccionó: " + nombreProyecto);

			String[] set = control.getByIndex(indexProyecto).createString();
			labelActividad.setText(set[0]);
			labelAmigo.setText(set[1]);
			labelInicio.setText(set[2]);
			labelFinal.setText(set[5]);
			labelTranscurrido.setText(set[4]);
			labelComentarios.setText(set[3]);
        }
	}
}
