/* Editted 4.14.19 3:49
 * A class that house varoius JFrame utilities
 */
package utilities;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Class to hold various JFrame tools
 * @author Shawn Ferdig
 */
public class FrameManipulator {
    
    public FrameManipulator(){   
    }
    
    /**
    * This method finds the center of the screen and place center of the frame
    * on it. Found at: 
    * https://stackoverflow.com/questions/144892/how-to-center-a-window-in-java
    * @param objFrame is the frame to be centered. 
    */
    public void centeredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY); 
    }
}
