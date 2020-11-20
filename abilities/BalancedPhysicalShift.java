/*
 * An ability class that balances stats but will favor the str stat if
 * not completely balanced
 */
package abilities;

import classes.Battle;
import classes.Player;
import java.io.Serializable;
import collections.Abilities;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shawn Ferdig
 */
public class BalancedPhysicalShift implements Ability, Serializable{
    
    private final String name = Abilities.BALANCED_PHYSICAL_SHIFT.getName();
    private final String description = Abilities.BALANCED_PHYSICAL_SHIFT.
            getDescription();
    private final double cost = Abilities.BALANCED_PHYSICAL_SHIFT.getCost();
    private final String type = Abilities.BALANCED_PHYSICAL_SHIFT.getType();
    private final int[] soundFiles = {8};
    private final double potency = Abilities.BALANCED_PHYSICAL_SHIFT.getPotency();

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
    public int[] getSoundFiles(){
        return this.soundFiles;
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
        battle.getHero().setCurMp(battle.getHero().getCurMp()-(int)
                (battle.getHero().getMaxMp()*cost));
        //get and sum the player's base stats
        int sumBaseStats = battle.getHero().getBaseStr()+
            battle.getHero().getBaseMag()+
            battle.getHero().getBaseDex();
        //find the remainder when averaged
        int overFlow = sumBaseStats%3;
        //find the average
        int averageBaseStats = sumBaseStats/3;
        //apply the average(remainder to str)
        battle.getHero().setBaseStr(averageBaseStats+overFlow);
        battle.getHero().setBaseMag(averageBaseStats);
        battle.getHero().setBaseDex(averageBaseStats);
        //set the stats
        battle.getHero().setStr(averageBaseStats+overFlow+battle.getHero()
                .getAdditionalStr());
        battle.getHero().setMag(averageBaseStats+battle.getHero()
                .getAdditionalMag());
        battle.getHero().setDex(averageBaseStats+battle.getHero()
                .getAdditionalDex());
        result.put(Abilities.BALANCED_PHYSICAL_SHIFT.getName(), 0);
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
        player.setCurMp(player.getCurMp()-(int)(player.getMaxMp()*cost));
        //get and sum the player's base stats
        int sumBaseStats = player.getBaseStr()+
            player.getBaseMag()+
            player.getBaseDex();
        //find the remainder when averaged
        int overFlow = sumBaseStats%3;
        //find the average
        int averageBaseStats = sumBaseStats/3;
        //apply the average(remainder to str)
        player.setBaseStr(averageBaseStats+overFlow);
        player.setBaseMag(averageBaseStats);
        player.setBaseDex(averageBaseStats);
        //set the stats
        player.setStr(averageBaseStats+overFlow+player.getAdditionalStr());
        player.setMag(averageBaseStats+player.getAdditionalMag());
        player.setDex(averageBaseStats+player.getAdditionalDex());
        result.put(Abilities.BALANCED_PHYSICAL_SHIFT.getName(), 0);
        return result;
    }  
}
