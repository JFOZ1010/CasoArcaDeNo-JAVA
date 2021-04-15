package misComponentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Titulos extends JLabel{
	
	public Titulos(String nombre, int tamanio, Color color) {
		
		this.setText(nombre);
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, tamanio);
		this.setFont(font);
		this.setBackground(color);
		this.setForeground(color.white);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
	}
}
