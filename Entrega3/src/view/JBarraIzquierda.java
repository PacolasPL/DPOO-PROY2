package view;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Font;

public class JBarraIzquierda extends JPanel{
	
	GridBagConstraints constraints = new GridBagConstraints();
	Color orange = new Color(255,115,0);

	JBarraIzquierda(){
		this.setBackground(orange);
		this.setLayout(new GridBagLayout());
		this.setSize(300,500);
		
		JLabel prin = new JLabel("Project Manager");
		prin.setFont(new Font("Yu Gothic", Font.PLAIN, 22));
		
		this.add(prin);
	
		
		
	}
	void addButton(Component component, JButton button) {
		
        add(component, constraints);
      }

}
