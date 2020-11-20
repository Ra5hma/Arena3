/*
 * This Ability moves the player's role to the Physical role
 */
package abilities;

import classes.*;
import java.io.Serializable;
import collections.Abilities;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn Ferdig
 */
public class PhysicalShift implements Ability, Serializable{
    private final String name = Abilities.PHYSICAL_SHIFT.getName();
    private final double cost = Abilities.PHYSICAL_SHIFT.getCost();
    private final String type = Abilities.PHYSICAL_SHIFT.getType();
    private final String description = Abilities.PHYSICAL_SHIFT.getDescription();
    private final double potency = Abilities.PHYSICAL_SHIFT.getPotency();
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
    public int getSoundFilesNumber() {
        return this.soundFiles.length;
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
    * @return a Map containing the ability name and an arbitrary integer
    */
    @Override
    public Map<String, Integer> use(Battle battle) {
        
        Map<String, Integer> result = new HashMap<>();
        int extraMag = 0;
        int extraDex = 0;
        battle.getHero().setCurMp((int)(battle.getHero().getCurMp()-battle
                .getHero().getMaxMp()*cost));
        if(battle.getHero().getBaseMag()>1){
            extraMag = battle.getHero().getBaseMag()-1;
            battle.getHero().setBaseMag(1);
            battle.getHero().setMag(1+battle.getHero().getAdditionalMag());
        }
        if(battle.getHero().getBaseDex()>1){
            extraDex = battle.getHero().getBaseDex()-1;
            battle.getHero().setBaseDex(1);
            battle.getHero().setDex(1+battle.getHero().getAdditionalDex());  
        }
        battle.getHero().setBaseStr(extraMag+extraDex+battle.getHero()
                .getBaseStr());
        battle.getHero().setStr(battle.getHero().getBaseStr()+battle.getHero()
                .getAdditionalStr());
        result.put(Abilities.PHYSICAL_SHIFT.getName(), 0);
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
        int extraMag = 0;
        int extraDex = 0;
        player.setCurMp((int)(player.getCurMp()-player.getMaxMp()*cost));
        if(player.getBaseMag()>1){
            extraMag = player.getBaseMag()-1;
            player.setBaseMag(1);
            player.setMag(1+player.getAdditionalMag());
        }
        if(player.getBaseDex()>1){
            extraDex = player.getBaseDex()-1;
            player.setBaseDex(1);
            player.setDex(1+player.getAdditionalDex());  
        }
        player.setBaseStr(extraMag+extraDex+player.getBaseStr());
        player.setStr(player.getBaseStr()+player.getAdditionalStr());
        result.put(Abilities.PHYSICAL_SHIFT.getName(), 0);
        return result;
    }   
}
