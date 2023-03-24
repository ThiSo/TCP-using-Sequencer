package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileHandler extends JMenuBar implements ActionListener{

	private static final long serialVersionUID = 1L;

	static JMenuItem openFile;
	static JMenuItem saveFile;
	static JMenuItem close;
	JTextArea textBox;
	
	FileHandler(JTextArea textBox){
		
		JMenu fileMenu = new JMenu("Arquivo");
		openFile = new JMenuItem("Abrir");
		saveFile = new JMenuItem("Salvar");
		close = new JMenuItem("close");
		
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		saveFile.setEnabled(false);
		close.addActionListener(this);
		
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(close);
		
		this.textBox = textBox;
		this.add(fileMenu);
	}

	public void openFileFunc() {
	
		JFileChooser textOpener =  new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos texto", "txt");
		textOpener.setCurrentDirectory(new File("."));
		textOpener.setFileFilter(filter);
		
		int openOption = textOpener.showOpenDialog(null);
		
		if(openOption == JFileChooser.APPROVE_OPTION) {
			File textFile = new File(textOpener.getSelectedFile().getAbsolutePath());
			Scanner inputText = null;
			
			try {
				inputText = new Scanner(textFile);
				if(textFile.isFile()) {
					while(inputText.hasNextLine()) {
						String line = inputText.nextLine()+"\n";
						textBox.append(line);
					}
				}
			}
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			finally {
				inputText.close();
			}
		}
	}
	
	public void saveFileFunc(Sequence sequence) throws IOException {
		
		JFileChooser midiSaver =  new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo Midi", "mid");
		midiSaver.setCurrentDirectory(new File("."));
		midiSaver.setFileFilter(filter);
		int saveOption = midiSaver.showSaveDialog(null);
		
		if(saveOption == JFileChooser.APPROVE_OPTION) {
			MidiSystem.write(sequence, 1, new File(midiSaver.getSelectedFile().getAbsolutePath()));
		}
	}
	
	public void closeSoftware() {
		
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Se o botão de abrir arquivo for pressionado
		if(e.getSource() == openFile) {
			
			openFileFunc();
		}
		
		//Se o botão de salvar arquivo for pressionado
		else if(e.getSource() == saveFile) {
			
			try {
				saveFileFunc(Button.sequence);
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
		}
		
		//Se o botão de close for pressionado	
		else if(e.getSource() == close) {
		
			closeSoftware();
		}
				
	}
}
