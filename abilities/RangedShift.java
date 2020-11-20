/*
 * This Ability moves the player's role to the Ranged role
 */
package abilities;

import classes.Battle;
import classes.Player;
import collections.Abilities;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn Ferdig
 */
public class RangedShift implements Ability, Serializable{
    private final String name = Abilities.RANGED_SHIFT.getName();
    private final double cost = Abilities.RANGED_SHIFT.getCost();
    private final String type = Abilities.RANGED_SHIFT.getType();
    private final String description = Abilities.RANGED_SHIFT.getDescription();
    private final double potency = Abilities.RANGED_SHIFT.getPotency();
    private final int[] soundFiles = {8};

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

 //Utility Methods =============================================================
    
    /**
    * Uses the ability inside of a battle and reduces AP by the appropriate 
    * amount
    * @param battle
    * @return a Map containing the ability name and an arbitrary integer
    */
    @Override
    public Map<String, Integer> use(Battle battle){
        
        Map<String, Integer> result = new HashMap<>();
        int extraStr = 0;
        int extraMag = 0;
        //reduce ability point pool by the cost of the ability
        battle.getHero().setCurMp((int)(battle.getHero().getCurMp()-battle
                .getHero().getMaxMp()*cost));
        if(battle.getHero().getBaseStr()>1){
            extraStr = battle.getHero().getBaseStr()-1;
            battle.getHero().setBaseStr(1);
            battle.getHero().setStr(1+battle.getHero().getAdditionalStr());
        }
        if(battle.getHero().getBaseMag()>1){
            extraMag = battle.getHero().getBaseMag()-1;
            battle.getHero().setBaseMag(1);
            battle.getHero().setMag(1+battle.getHero().getAdditionalMag()); 
        }
        battle.getHero().setBaseDex(extraStr+extraMag+battle.getHero()
                .getBaseDex());
        battle.getHero().setDex(battle.getHero().getBaseDex()+battle.getHero()
                .getAdditionalDex());
        result.put(Abilities.RANGED_SHIFT.getName(), 0);
        return result;
    }

    /**
    * Uses the ability outside of a battle and reduces AP by the appropriate 
    * amount
    * @param player
    * @return a Map containing the ability name and an arbitrary integer
    */
    @Override
    public Map<String, Integer> use(Player player) {
        
        Map<String, Integer> result = new HashMap<>();
        int extraStr = 0;
        int extraMag = 0;
        //reduce ability point pool by the cost of the ability
        player.setCurMp((int)(player.getCurMp()-player.getMaxMp()*cost));
        if(player.getBaseStr()>1){
            extraStr = player.getBaseStr()-1;
            player.setBaseStr(1);
            player.setStr(1+player.getAdditionalStr());
        }
        if(player.getBaseMag()>1){
            extraMag = player.getBaseMag()-1;
            player.setBaseMag(1);
            player.setMag(1+player.getAdditionalMag());
        }
        player.setBaseDex(extraStr+extraMag+player.getBaseDex());
        player.setDex(player.getBaseDex()+player.getAdditionalDex());
        result.put(Abilities.RANGED_SHIFT.getName(), 0);
        return result;
    }
}
