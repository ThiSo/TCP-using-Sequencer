package Main;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class TextBox extends JTextArea{

	private static final long serialVersionUID = 1L;

	TextBox(){
		
		//template da caixa de texto
		int boxPosX = 10;
		int boxPosY = 50;
		int boxWidth = 375;
		int boxHeight = 500;
		
		this.setBounds(boxPosX, boxPosY, boxWidth, boxHeight);
		this.setFont(new Font("FreeMono", Font.PLAIN, 20));
		this.setForeground(Color.white);
		this.setBackground(Color.black);
		this.setCaretColor(Color.white);
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		
	}
}
