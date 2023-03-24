package Main;

import javax.swing.*;

public class Frame extends JFrame{

private static final long serialVersionUID = 1L;
	
	Frame() {
		
		int frameWidth = 600;
		int frameHeight = 620;
		
		//características da janela principal
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("JMIDI");
		this.setSize(frameWidth, frameHeight);
		this.setResizable(false);
			
		//estanciamento das componentes visuais
		//labels
		Label textLabel = new Label("JMIDI - Texto para Sons");
		Label GlossaryLabel = new Label();

		ImageIcon image = new ImageIcon("inf.png");
		Label imageLabel = new Label(image);
		
		//campo de texto
		TextBox textBox = new TextBox();
		
		//botão
		Button button = new Button(textBox);
		
		//barra lateral e correções
		JScrollPane scrollPane = new JScrollPane(textBox);
		scrollPane.setBounds(textBox.getBounds());
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		FileHandler fileBar = new FileHandler(textBox);
		
		//Adição dos componentes visuais à janela
		this.setJMenuBar(fileBar);
		this.add(imageLabel);
		this.add(textLabel);
		this.add(GlossaryLabel);
		this.add(button);
		this.add(scrollPane);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
