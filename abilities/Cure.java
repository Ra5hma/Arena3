/*
 * This class uses ability points to heal a portion of max hit points
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
public class Cure implements Ability, Serializable{
    private final int[] soundFiles = {5};
    private final String name = Abilities.CURE.getName();
    private final Double cost = Abilities.CURE.getCost();
    private final String type = Abilities.CURE.getType();
    private final double potency = Abilities.CURE.getPotency();
    private final String description = Abilities.CURE.getDescription();
 
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
    * @return a Map containing the ability name and the amount the player is 
    * healed for
    */
    @Override
    public Map<String, Integer> use(Battle battle) {
        Map<String, Integer> result = new HashMap<>();

        battle.getHero().setCurMp(battle.getHero().getCurMp()-
                (int)(battle.getHero().getMaxMp()*cost));
        if(battle.getHero().getMaxHp()< battle.getHero().getCurHp()+
                (int)(battle.getHero().getMaxHp()*potency)){
            result.put(Abilities.CURE.getName(), battle.getHero().
                    getMaxHp()-battle.getHero().getCurHp());
            battle.getHero().setCurHp(battle.getHero().getMaxHp());
        }   
        else{
            battle.getHero().setCurHp(battle.getHero().getCurHp()+
                    (int)(battle.getHero().getMaxHp()*potency));
            result.put(Abilities.CURE.getName(), (int)(battle.getHero().
                    getMaxHp()*potency));
        }
        return result;
    }

    /**
    * Uses the ability outside of a battle and reduces AP by the appropriate 
    * amount
    * @param player
    * @return a Map containing the ability name and the amount the player is 
    * healed for
    */
    @Override
    public Map<String, Integer>  use(Player player) {
        
        Map<String, Integer> result = new HashMap<>();
        player.setCurMp(player.getCurMp()-(int)(player.
                getMaxMp()*cost));
        if(player.getMaxHp()< player.getCurHp()+player.
                getMaxHp()*potency){
            result.put(Abilities.CURE.getName(), player.getMaxHp()-
                    player.getCurHp());
            player.setCurHp(player.getMaxHp());
        }
        else{
            player.setCurHp((int)(player.getCurHp()+player.
                    getMaxHp()*potency));
            result.put(Abilities.CURE.getName(), (int)(player.getMaxHp()
                    *potency));
        }
        return result;
    }
}
