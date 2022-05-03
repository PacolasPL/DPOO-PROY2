package view;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Principal extends JFrame{
	public Principal() {
		this.setSize(620, 500);
		this.setTitle("Project Manager");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JBarraIzquierda arriba = new JBarraIzquierda();
		this.add(arriba, BorderLayout.WEST);
		PBotones pBotones = new PBotones();
		this.add(pBotones, BorderLayout.EAST);
		
}
	
	public static void main(String[] args) {
		Principal fPrincipal = new Principal();
		fPrincipal.setVisible(true);
		
		
	}
}