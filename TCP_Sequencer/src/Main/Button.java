package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.swing.*;

import Music.Converter;
import Music.Reproducer;

public class Button extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;

	JTextArea textBox;
	static Sequence sequence;
	
	Button(JTextArea textBox){
		
		//template comum dos botões
		this.textBox = textBox; 	//caixaTexto tem que ser re-instanciada para ser usada no actionListener
		this.setText("Tocar texto");
		this.setBounds(400,425,165,40);
		this.addActionListener(this);
		this.setFocusable(false);
		
	}
	
	//Ações a serem tomadas quando o botão é clicado
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==this) {
						
			System.out.println("Input: "+textBox.getText());
			textBox.setEditable(false);
			this.setEnabled(false);

			String textInput = textBox.getText();
			int[] noteArray = Converter.convertTextToMusic(textInput);
			try {
				sequence = Converter.createMidiSequence(noteArray);
				Reproducer.reproduzSomSynth(sequence);
			} catch (MidiUnavailableException | InvalidMidiDataException | InterruptedException e1) {
				e1.printStackTrace();
			} 

		}

		textBox.setEditable(true);
		FileHandler.saveFile.setEnabled(true);
		this.setEnabled(true);

	}
}
