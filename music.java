import java. io.File;
import java. io.*;
import javax.sound.sampled.*;

public class music {
    
    private Clip clip;
    
    public void musicStartGame() {
        try {
            File soundFile = new File("openstartgame.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            
        }catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void stopMusic() {
        if(clip.isActive())
            clip.stop();
    }
    
    public void playMusic(boolean playAgain) {
        clip.start();
        if(playAgain)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
       