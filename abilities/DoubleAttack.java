/*
 * this ability allows for two consective turns, the first turn is a ranged 
 * attack
 */
package abilities;

import classes.Battle;
import classes.Player;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import collections.Abilities;

/**
 *
 * @author Shawn Ferdig
 */
public class DoubleAttack implements Ability, Serializable{
    
    private final String name = Abilities.DOUBLE_ATTACK.getName();
    private final double cost = Abilities.DOUBLE_ATTACK.getCost();
    private final String type = Abilities.DOUBLE_ATTACK.getType();
    private final double potency = Abilities.DOUBLE_ATTACK.getPotency();
    private final String description = Abilities.DOUBLE_ATTACK.getDescription();
    private final int[] soundFiles = {12};
    
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
    public String getDescription() {
        return description;
    }

    @Override
    public int[] getSoundFiles(){
        return this.soundFiles;
    }
    
    @Override
    public double getPotency() {
        return potency;
    }
    
//Utility Methods ==============================================================
    
    /**
    * Uses the ability inside of a battle and reduces AP by the appropriate 
    * amount
    * @param battle
    * @return a Map containing the ability name and an arbitrary integer
    */
    @Override
    public Map<String, Integer> use(Battle battle) {
        Map<String, Integer> result = new HashMap<>();
        battle.getHero().setCurMp(battle.getHero().getCurMp()-(int)
                (battle.getHero().getMaxMp()*cost));
        battle.rngAtt(battle.getHero(), battle.getOpp());
        result.put(Abilities.DOUBLE_ATTACK.getName(), 0);
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
