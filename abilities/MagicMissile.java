/*
 * This ability uses the lowest mob stat and the player's magic stat to 
 * determine damage
 */
package abilities;

import classes.Battle;
import classes.Player;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import collections.Abilities;

/**
 * @author Shawn Ferdig
 */
public class MagicMissile implements Ability, Serializable {
    
    private final String name = Abilities.MAGIC_MISSILE.getName();
    private final double cost = Abilities.MAGIC_MISSILE.getCost();
    private final String type = Abilities.MAGIC_MISSILE.getType();
    private final String description = Abilities.MAGIC_MISSILE.getDescription();
    private final double potency = Abilities.MAGIC_MISSILE.getPotency();
    private final int[] soundFiles = {15};
    
//Get Methods ==================================================================           

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getSoundFile(int index) {
        return soundFiles[index];
    }

    @Override
    public int getSoundFilesNumber() {
        return soundFiles.length;
    }

    @Override
    public int[] getSoundFiles(){
        return this.soundFiles;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPotency() {
        return this.potency;
    }
    
 //Utility Methods ==============================================================
    
    /**
    * Uses the ability inside of a battle and reduces AP by the appropriate 
    * amount
    * @param battle
    * @return a Map containing the ability name and the damage to the opponent
    */
    @Override
    public Map<String, Integer> use(Battle battle) {
        
        Map<String, Integer> result = new HashMap<>();
        int less = battle.getOpp().getStr();
        battle.getHero().setCurMp(battle.getHero().getCurMp()-
                (int)(battle.getHero().getMaxMp()*cost));
        
        if(less> battle.getOpp().getMag())
            less =battle.getOpp().getMag();
        if(less > battle.getOpp().getDex())
            less = battle.getOpp().getDex();
        int damage = battle.attack(battle.getHero().getMag(), less, 
                battle.getHero().getLevel());
        battle.displayDamage(battle.getOpp(), damage);
        result.put(Abilities.MAGIC_MISSILE.getName(), damage);
        return result;
    }
    
    /**
    * Uses the ability outside of a battle and reduces AP by the appropriate
    * This ability cannot be used out side of battle
    * amount
    * @param player
    * @return null
    */
    @Override
    public Map<String, Integer> use(Player player) {
        return null;
    }
   
}
