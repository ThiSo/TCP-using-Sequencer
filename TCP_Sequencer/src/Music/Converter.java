package Music;
import javax.sound.midi.*;

public class Converter {

	public static int[] convertTextToMusic(String text) {
		
		int[] noteArray = new int[text.length()];
		for(int i = 0; i < text.length(); i++) {
			noteArray[i] = (int) text.charAt(i);
			System.out.print(noteArray[i]);
		}
		
		return noteArray;
	}
	
	public void addEvent() {
		
	}
	
	public static Sequence createMidiSequence(int[] noteArray) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		
		int MIN_OCTAVE = 0;
		int MAX_OCTAVE = 9;
		int octave = MIN_OCTAVE;
		int defaultVolume = 25;
		int volume = defaultVolume;		     
		
		MidiEvent event;
		boolean lastValueIsNote = false;
		Sequencer sequencer = MidiSystem.getSequencer();
			 
		sequencer.open();
	    Sequence sequence = new Sequence(Sequence.PPQ, 2); 
	    Track track = sequence.createTrack();
	    
	    for (int i = 0; i < noteArray.length; i++) {
	    		    	
	    	int offsetOctave = 12*octave;
	        switch(noteArray[i]) {
	        	case ((int) ' '):
	        		lastValueIsNote = false;
		        	if(volume >= 100) {
	        			volume = defaultVolume;
	        		}
	        		else {
	        			volume = volume * 2;
	        		}
	        		event = new MidiEvent(new ShortMessage(ShortMessage.CONTINUE), i);
	    	        track.add(event);
	    	        break;
	        	case ((int) 'A'):
	        		lastValueIsNote = true;
	        		noteArray[i] = 21 + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);	
	    	        break;
	        	case ((int) 'B'):
	        		lastValueIsNote = true;
	        		noteArray[i] = 23 + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);	
	        		break;
	        	case ((int) 'C'):
	        		lastValueIsNote = true;
	        		noteArray[i] = 12 + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	        		break;
	        	case ((int) 'D'):
	        		lastValueIsNote = true;
	        		noteArray[i] = 14 + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);	 
    	            break;
	        	case ((int) 'E'):
	        		lastValueIsNote = true;
	        		noteArray[i] = 16 + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);	   
	        		break;
	        	case ((int) 'F'):
	        		lastValueIsNote = true;
	        		noteArray[i] = 17 + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);		    	        
    	            break;
	        	case ((int) 'G'):
	        		lastValueIsNote = true;
	        		noteArray[i] = 19 + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);	
    	            break;
	        	case ((int) '!'): // Muda instrumento, o terceiro parametro do ShortMessage é o código do instrumento
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, 113, 0), i);
    	            track.add(event);
    	            break;
	        	case ((int) 'O'), ((int) 'o'), ((int) 'U'), ((int) 'u'), ((int) 'I'), ((int) 'i'):
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, 6, 0), i);
    	            track.add(event);
    	            break;
	        	case ((int) '0'), ((int) '1'), ((int) '2'), ((int) '3'), ((int) '4'), ((int) '5'), ((int) '6'), ((int) '7'),((int) '8'),((int) '9'):
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.CONTINUE), i);
	        		track.add(event);
	        		break;
	        	case ((int) '?'), ((int) '.'):
	        		lastValueIsNote = false;
	        		octave = octave + 1;
	        		if (octave > MAX_OCTAVE){
	        			octave = MIN_OCTAVE;
	        		}
	        		event = new MidiEvent(new ShortMessage(ShortMessage.CONTINUE), i);
    	            track.add(event);
    	            break;
	        	case ((int) '\n'): // Muda instrumento, o terceiro parametro do ShortMessage é o código do instrumento
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, 14, 0), i);
    	            track.add(event);
    	            break;
	        	case ((int) ';'): // Muda instrumento, o terceiro parametro do ShortMessage é o código do instrumento
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, 75, 0), i);
    	            track.add(event);
    	            break;
	        	case ((int) ','): // Muda instrumento, o terceiro parametro do ShortMessage é o código do instrumento
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, 19, 0), i);
	        		track.add(event);
	        		break;
	        	default:
	        		if(	lastValueIsNote == true) { // Se o último evento foi uma nota, repete ela
	        			lastValueIsNote = false;
	        			event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i - 1], volume), i);
	        			track.add(event);
	        		}
	        		else { // Em teoria deveria fazer o silencio entre as notas
	        			event = new MidiEvent(new ShortMessage(ShortMessage.CONTROL_CHANGE, 0, 123, 0), 2000);
		        		track.add(event);
	        		}
	        	}
	            
	        }
	        sequencer.setSequence(sequence);
	 		sequencer.close();
	         
	 		return sequence;
	}
}
