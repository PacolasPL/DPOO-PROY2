package view;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Principal extends JFrame{
	public Principal() {
		this.setSize(500, 500);
		this.setTitle("Project Manager");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JBarraArriba arriba = new JBarraArriba();
		this.add(arriba, BorderLayout.WEST);
		PBotones pBotones = new PBotones();
		this.add(pBotones, BorderLayout.EAST);
		
}
	
	public static void main(String[] args) {
		Principal fPrincipal = new Principal();
		fPrincipal.setVisible(true);
		
		
	}
}
