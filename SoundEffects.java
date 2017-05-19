//Class to produce sound effects

import java.io.*;
import javax.sound.sampled.*;

public class SoundEffects {
	// Constructor
	public void SoundEffects(int mode) 
	{
		String str;
		if(mode == 1)
			str = "Win.wav";
		else if(mode == 2)
			str = "Lost.wav";
		else if(mode == 3)
			str = "Draw.wav";
		else
			str = "Move.wav";
	      try 
	      {
	    	  // Open an audio input stream.
	    	  File  soundFile = new File(str);
	    	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	          // Get a sound clip resource.
	          Clip clip = AudioSystem.getClip();
	          // Open audio clip and load samples from the audio input stream.
	          clip.open(audioIn);
	          clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}
}
