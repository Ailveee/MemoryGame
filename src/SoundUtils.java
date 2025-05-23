import javax.sound.sampled.*;
import java.io.File;

public class SoundUtils {
    public static void playSound(String path) {
        try {
            File soundFile = new File(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            System.err.println("Error playing sound: " + path);
        }
    }

    public static Clip playBackgroundMusic(String path) {
        try {
            File soundFile = new File(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            return clip;
        } catch (Exception e) {
            System.err.println("Error playing background music: " + path);
            return null;
        }
    }

    public static void stopBackgroundMusic(Clip clip) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
