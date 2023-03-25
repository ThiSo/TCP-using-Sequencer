package main;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

public class Label extends JLabel{

	private static final long serialVersionUID = 1L;
	
	//construtor da label de texto
	Label(String text){
		
		int labelPosX = 10;
		int labelPosY = 10;
		int labelWidth =375;
		int labelHeight = 30;
		int labelFontSize = 20;
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		
		this.setText(text);
		this.setBorder(border);
		this.setBounds(labelPosX, labelPosY, labelWidth, labelHeight);
		this.setOpaque(false);
		this.setBackground(Color.black);
		this.setForeground(Color.black);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.TOP);
		this.setFont(new Font("Arial", Font.PLAIN, labelFontSize));
	}
	
	//Construtor da Label de glossário
	Label(){
		
		int labelPosX = 390;
		int labelPosY = 50;
		int labelWidth = 190;
		int labelHeight = 360;
		int labelFontSize = 13;
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		
		this.setText("<html>"
					+ "Glossário de notas:<br><br>"
					+ "A = nota La<br>"
					+ "B = nota Si<br>"
					+ "C = nota Do<br>"
					+ "D = nota Re<br>"
					+ "E = nota Mi<br>"
					+ "F = nota Fa<br>"
					+ "G = nota Sol<br><br>"
					+ "Glossário de Instrumentos:<br><br>"
					+ "; = instrumento Pan Flute<br>"
					+ ", = instrumento Church Organ<br>"
					+ "NL = instrumento Tubular Bells<br><br>"
					+ "Outras opções:<br><br>"
					+ "?/. = aumenta oitava<br>"
					+ "consoantes/a/e = repete<br>"
					+ "&emsp;&emsp;&emsp;&ensp;&nbsp;nota ou silêncio<br>"
					+ "BACKSPACE = dobra volume</html>");
		this.setBorder(border);
		this.setBounds(labelPosX, labelPosY, labelWidth, labelHeight);
		this.setOpaque(false);
		this.setBackground(Color.black);
		this.setForeground(Color.black);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.TOP);
		this.setFont(new Font("Arial", Font.PLAIN, labelFontSize));
	}
	
	//construtor da Label de imagem
	Label(ImageIcon image){
				
		int labelPosX = 435;
		int labelPosY = 460;
		int labelWidth = 100;
		int labelHeight = 100;
		
		this.setIcon(image);
		this.setBounds(labelPosX, labelPosY, labelWidth, labelHeight);
	}
}
