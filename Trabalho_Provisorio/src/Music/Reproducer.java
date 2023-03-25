package Music;
import javax.sound.midi.*;

public class Reproducer {
	
	public static void reproduzSomSynth(Sequence sequence) throws MidiUnavailableException, InvalidMidiDataException {
		        
	    // Obtem um sequencer e o abre
		Sequencer sequencer = MidiSystem.getSequencer();
			
	    // Define a sequencia como a sequencia do sequencer
	    sequencer.setSequence(sequence);
	         
	    // Inicia a reproducao
		sequencer.open();		
		sequencer.setTempoInBPM(60);
	    sequencer.start();	         
	     
	 }
}
