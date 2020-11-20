/*
 * An ability class that shifts roles from balanced to Magical
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
public class MagicalShift implements Ability, Serializable {

    private final String name = Abilities.MAGICAL_SHIFT.getName();
    private final double cost = Abilities.MAGICAL_SHIFT.getCost();
    private final String type = Abilities.MAGICAL_SHIFT.getType();
    private final String description = Abilities.MAGICAL_SHIFT.getDescription();
    private final double potency = Abilities.MAGICAL_SHIFT.getPotency();
    private final int[] soundFiles = {8};
    
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
        return this.description ;
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
        int extraStr = 0;
        int extraDex = 0;
        battle.getHero().setCurMp((int)(battle.getHero().getCurMp()-battle
                .getHero().getMaxMp()*cost));
        if(battle.getHero().getBaseStr()>1){
            extraStr = battle.getHero().getBaseStr()-1;
            battle.getHero().setBaseStr(1);
            battle.getHero().setStr(1+battle.getHero().getAdditionalStr());
        }
        if(battle.getHero().getBaseDex()>1){
            extraDex = battle.getHero().getBaseDex()-1;
            battle.getHero().setBaseDex(1);
            battle.getHero().setDex(1+battle.getHero().getAdditionalDex()); 
        }
        battle.getHero().setBaseMag(extraStr+extraDex+battle.getHero()
                .getBaseMag());
        battle.getHero().setMag(battle.getHero().getBaseMag()+battle.getHero()
                .getAdditionalMag());   
        result.put(Abilities.MAGICAL_SHIFT.getName(), 0);
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
        int extraDex = 0;
        player.setCurMp((int)(player.getCurMp()-player.getMaxMp()*cost));
        if(player.getBaseStr()>1){
            extraStr = player.getBaseStr()-1;
            player.setBaseStr(1);
            player.setStr(1+player.getAdditionalStr());
        }
        if(player.getBaseDex()>1){
            extraDex = player.getBaseDex()-1;
            player.setBaseDex(1);
            player.setDex(1+player.getAdditionalDex());    
        }
        player.setBaseMag(extraStr+extraDex+player.getBaseMag());
        player.setMag(player.getBaseMag()+player.getAdditionalMag()); 
        result.put(Abilities.MAGICAL_SHIFT.getName(), 0);
        return result;
    }
}
