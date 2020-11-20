/*
 * An interface for all abilities
 */
package abilities;
import classes.*;
import java.util.Map;

/**
 * @author Shawn Ferdig
 */

public interface Ability{
 
//Get Methods ==============================================================  
    
   public String getName();
    
   public double getCost();
    
   public String getType();
   
   public int getSoundFile(int index);
   
   public int[] getSoundFiles();
   
   public int getSoundFilesNumber();
   
   public String getDescription();
   
   public double getPotency();
   
//Utility Methods ============================================================== 
   
   /**
    * Uses the ability inside of a battle
    * @param battle
    * @return a Map
    */
   public Map<String, Integer> use(Battle battle);
   
   /**
    * Uses the ability outside of a battle
    * @param player
    * @return 
    */
   public Map<String, Integer> use(Player player);
}
