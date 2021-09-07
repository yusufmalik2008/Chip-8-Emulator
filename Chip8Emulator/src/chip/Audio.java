package chip;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;

public class Audio {

	public static void playSound(String file) {
		/*try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(file));
			clip.open(audioStream);
			FloatControl fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			fc.setValue(-19.9f);
			clip.start();
			System.out.println("beep");
		} catch(Exception e) {
			System.err.println("Failed to play sound file " + e.getMessage());
		}*/
		
		java.awt.Toolkit.getDefaultToolkit().beep();
	}
}
