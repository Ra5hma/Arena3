/*
 * An ability class that does the maximum physical damage.
 * 
 */
package abilities;

import classes.Battle;
import classes.Player;
import java.io.Serializable;
import collections.Abilities;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn Ferdig
 */
public class CriticalAttack implements Ability, Serializable{
    
    
    private final String name = Abilities.CRITICAL_ATTACK.getName();
    private final Double cost = Abilities.CRITICAL_ATTACK.getCost();
    private final String type = Abilities.CRITICAL_ATTACK.getType();
    private final String description = Abilities.CRITICAL_ATTACK.getDescription();
    private final double potency = Abilities.CRITICAL_ATTACK.getPotency();
    private final int[] soundFiles = {9};
    
//Get Methods ==================================================================
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getSoundFile(int index) {
        return this.soundFiles[index];
    }

    @Override
    public int[] getSoundFiles(){
        return this.soundFiles;
    }
    
    @Override
    public int getSoundFilesNumber() {
        return this.soundFiles.length;
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
    * @return a Map containing the ability name and an it's potency
    */
    @Override
    public Map<String, Integer> use(Battle battle) {
        Map<String, Integer> result = new HashMap<>();
        battle.getHero().setCurMp(battle.getHero().getCurMp()-
                (int)(battle.getHero().getMaxMp()*cost));
        battle.getOpp().setCurHp((int) (battle.getOpp().getCurHp()-
                (battle.getHero().getLevel()+potency)));
        result.put(Abilities.CRITICAL_ATTACK.getName(),battle.getHero().
                getLevel()+(int)potency);
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
