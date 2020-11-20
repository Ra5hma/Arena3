/*
 * Class to test the AudioPlayer
 */
package utilities;

import collections.SoundTracks;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Shawn Ferdig
 */
public class AudioPlayerTest {
    
    private AudioPlayer audioPlayer;
    
    public AudioPlayerTest() {}
    
    @Before
    public void initiate(){
        
        try {
            audioPlayer = new AudioPlayer();
        } 
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Enountered: "+ex);
        }
    }
    

    /**
     * Test of setTrack and getTrackPath methods, of class AudioPlayer.
     */
    @Test
    public void testTracks() {
        
        int trackNum = 5;
        int trackNum1 = -1;
        int trackNum2 = 100000;
        
        audioPlayer.setTrack(trackNum);
        String trackPath = SoundTracks.values()[trackNum].getFilePath();
        assertEquals("testing get track path", trackPath, audioPlayer.getTrackPath());
        audioPlayer.setTrack(trackNum1);
        trackPath = SoundTracks.values()[0].getFilePath();
        assertEquals("testing get track to low", trackPath, audioPlayer.getTrackPath());
        audioPlayer.setTrack(trackNum2);      
        trackPath = SoundTracks.values()[0].getFilePath();
        assertEquals("testing get track to high", trackPath, audioPlayer.getTrackPath());
    }   
}
