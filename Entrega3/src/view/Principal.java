package view;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Principal extends JFrame{
	
	JBarraIzquierda izquierda = new JBarraIzquierda();
	PBotones pBotones = new PBotones(this);
	
	public Principal() {
		this.setSize(620, 500);
		this.setTitle("Project Manager");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		this.add(izquierda, BorderLayout.WEST);
		this.add(pBotones, BorderLayout.EAST);
}
	
	public static void main(String[] args) {
		Principal fPrincipal = new Principal();
		fPrincipal.volverVisible();
	}
	
	public void volverInvisible() {
		this.setVisible(false);
	}
	
	public void volverVisible() {
		this.setVisible(true);
	}
	
}
