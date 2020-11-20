/*
 * An ability class that balances stats but will favor the mag stat if 
 * not completely balanced
 */
package abilities;

import classes.Battle;
import classes.Player;
import collections.Abilities;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shawn Ferdig
 */
public class BalancedMagicalShift implements Ability, Serializable{
    
    private final String name = Abilities.BALANCED_MAGICAL_SHIFT.getName();
    private final String description = Abilities.BALANCED_MAGICAL_SHIFT.
            getDescription();
    private final double cost = Abilities.BALANCED_MAGICAL_SHIFT.getCost();
    private final String type = Abilities.BALANCED_MAGICAL_SHIFT.getType();
    private final double potency = Abilities.BALANCED_MAGICAL_SHIFT.getPotency();
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
    public double getPotency() {
        return potency;
    }
    
    @Override
    public int[] getSoundFiles() {
        return this.soundFiles;
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
        
        Map<String, Integer> results = new HashMap<>();
        battle.getHero().setCurMp(battle.getHero().getCurMp()-
                (int)(battle.getHero().getMaxMp()*cost));
        //get and sum the player's base stats
        int sumBaseStats = battle.getHero().getBaseStr()+
            battle.getHero().getBaseMag()+
            battle.getHero().getBaseDex();
        //find the remainder when averaged
        int overFlow = sumBaseStats%3;
        //find the average
        int averageBaseStats = sumBaseStats/3;
        //apply the average(remainder to str)
        battle.getHero().setBaseMag(averageBaseStats+overFlow);
        battle.getHero().setBaseStr(averageBaseStats);
        battle.getHero().setBaseDex(averageBaseStats);
        //set the stats
        battle.getHero().setStr(averageBaseStats+battle.getHero()
                .getAdditionalStr());
        battle.getHero().setMag(averageBaseStats+overFlow+battle.getHero()
                .getAdditionalMag());
        battle.getHero().setDex(averageBaseStats+battle.getHero()
                .getAdditionalDex());
        results.put(Abilities.BALANCED_MAGICAL_SHIFT.getName(), 0);
        return results;
    }

    /**
    * Uses the ability outside of a battle and reduces AP by the appropriate 
    * amount
    * @param player
    * @return a Map containing the ability name and an arbitrary integer
    */
    @Override
    public Map<String, Integer> use(Player player) {
        
        Map<String, Integer> results = new HashMap<>();
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
        player.setBaseStr(averageBaseStats);
        player.setBaseMag(averageBaseStats+overFlow);
        player.setBaseDex(averageBaseStats);
        //set the stats
        player.setStr(averageBaseStats+player.getAdditionalStr());
        player.setMag(averageBaseStats+overFlow+player.getAdditionalMag());
        player.setDex(averageBaseStats+player.getAdditionalDex());
        results.put(Abilities.BALANCED_MAGICAL_SHIFT.getName(), 0);
        return results;
    }
}
