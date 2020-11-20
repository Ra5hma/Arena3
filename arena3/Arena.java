/*
 * The main method for application. Instantiates a global character and a global
 * audio player for main background music.
 * 
 */
package arena3;

import frames.StartFrame;
import classes.Player;
import classes.Smith;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import utilities.AudioPlayer;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public class Arena{
    
    public static Player CUR_PLAYER = new Player();
    public static Smith BLK_SMITH = new Smith();
    public static AudioPlayer BGM;
    
    /**
     * Main method
     * @param args - command line arguments 
     */
    public static void main(String[] args){

        try {
            BGM = new AudioPlayer();
        } 
        catch (UnsupportedAudioFileException | IOException | 
                LineUnavailableException ex){}
      
        BGM.setTrack(0);
        BGM.play();
        StartFrame game = new StartFrame();
        game.setVisible(true);    
    }
}