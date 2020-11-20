/*
 * This class facilitate the interactions between the player and the 
 * frame.
 */
package classes;

import abilities.*;
import arena3.Arena;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public class Trainer {
    
    private final ArrayList<Ability> warAbilities = new ArrayList<>();
    private final ArrayList<Ability> magAbilities = new ArrayList<>();
    private final ArrayList<Ability> rngAbilities = new ArrayList<>();
    private int cost;
    
    public Trainer(){
        
        warAbilities.add(new PhysicalShift());
        magAbilities.add(new MagicalShift());
        rngAbilities.add(new RangedShift());
        rngAbilities.add(new DoubleAttack());
        magAbilities.add(new Cure());
        magAbilities.add(new MagicMissile());
        warAbilities.add(new CriticalAttack());
        warAbilities.add(new BalancedPhysicalShift());
        magAbilities.add(new BalancedMagicalShift());
        rngAbilities.add(new BalancedRangedShift());  
        this.cost = (Arena.CUR_PLAYER.getAbilites().size()+Arena.CUR_PLAYER
                .getBaseDex()+Arena.CUR_PLAYER.getBaseMag()+
                Arena.CUR_PLAYER.getBaseStr()-9)*20;

    }
//Set Methods ==================================================================
    
    /**
     * Creates a list of war abilities by determining what war abilities a
     * player already has and removing them from the list
     * @param abilitiesMap - players abilities
     * @return - trainer's abilities
     */
    public ArrayList<Ability> setWarAbilityList(Map<String, Ability> 
            abilitiesMap){
        
        ArrayList<Ability> delete = new ArrayList<>();
        for(Ability ability: warAbilities){
            if(abilitiesMap.containsKey(ability.getName())){
                delete.add(ability);
            }   
        }
        for(Ability ability: delete){
            warAbilities.remove(ability);
        }  
        return warAbilities;  
    }
    
    /**
     * Creates a list of mag abilities by determining what mag abilities a
     * player already has and removing them from the list
     * @param abilitiesMap - players abilities
     * @return - trainer's abilities
     */
    public ArrayList<Ability> setMagAbilityList(Map<String, 
            Ability> abilitiesMap){
        
        ArrayList<Ability> delete = new ArrayList<>();
        for(Ability ability: magAbilities){
            if(abilitiesMap.containsKey(ability.getName())){
                delete.add(ability);
            }   
        }
        for(Ability ability: delete){
            magAbilities.remove(ability);
        }  
        return magAbilities;  
    }
    
    /**
     * Creates a list of rng abilities by determining what rng abilities a
     * player already has and removing them from the list
     * @param abilitiesMap - players abilities
     * @return - trainer's abilities
     */
    public ArrayList<Ability> setRngAbilityList(Map<String, 
            Ability> abilitiesMap){
        
        ArrayList<Ability> delete = new ArrayList<>();
        for(Ability ability: rngAbilities){
            if(abilitiesMap.containsKey(ability.getName())){
                delete.add(ability);
            }   
        }
        for(Ability ability: delete){
            rngAbilities.remove(ability);
        }
        return rngAbilities;  
    }
    
//Get Methods ==================================================================
    
    public ArrayList<Ability> getWarAbilitiesList(){
        return this.warAbilities;
    }
    
    public ArrayList<Ability> getMagAbilitiesList(){
        return this.magAbilities;
    }
    
    public ArrayList<Ability> getRngAbilitiesList(){
        return this.rngAbilities;
    }
    
    public int getCost(){
        return this.cost;
    }
    
//Utilities Methods ============================================================
    
    /**
     * Add ability at supplied index from the trainer's abilities to the
     * player's abilities, remove it from the trainer's abilities, remove the
     * cost of the abilities from the player's xpCredits and calculate the new
     * cost
     * @param index - index of the selected trainer's ability 
     */
    public void buyWarAbility(int index){

          Ability temp = warAbilities.get(index);
          Arena.CUR_PLAYER.getAbilites().put(temp.getName(), temp);
          warAbilities.remove(index);
          Arena.CUR_PLAYER.setXpCredits(Arena.CUR_PLAYER.getXpCredits()-cost);
          this.setCost();
    }
    
    /**
     * Add ability at supplied index from the trainer's abilities to the
     * player's abilities, remove it from the trainer's abilities, remove the
     * cost of the abilities from the player's xpCredits and calculate the new
     * cost
     * @param index - index of the selected trainer's ability 
     */
    public void buyMagAbility(int index){

          Ability temp = magAbilities.get(index);
          Arena.CUR_PLAYER.getAbilites().put(temp.getName(), temp);
          magAbilities.remove(index);
          Arena.CUR_PLAYER.setXpCredits(Arena.CUR_PLAYER.getXpCredits()-cost);
         this.setCost();
    }
    
    /**
     * Add ability at supplied index from the trainer's abilities to the
     * player's abilities, remove it from the trainer's abilities, remove the
     * cost of the abilities from the player's xpCredits and calculate the new
     * cost
     * @param index - index of the selected trainer's ability 
     */
    public void buyDexAbility(int index){

          Ability temp = rngAbilities.get(index);
          Arena.CUR_PLAYER.getAbilites().put(temp.getName(), temp);
          rngAbilities.remove(index);
          Arena.CUR_PLAYER.setXpCredits(Arena.CUR_PLAYER.getXpCredits()-cost);
          this.setCost();
    }
    
    /**
     * Determines if the player can afford ability
     * @return true if the player's xpXredits not < cost, otherwise returns
     * false
     */
    public boolean canAfford(){
        return(!(Arena.CUR_PLAYER.yaNub(cost)));
    }
    
    /**
     * Adds one point to baseStr and str, adds 10 to maxHp, restores all hp to 
     * the new maxHp, removes cost from player xpCredits, and set's new cost
     */
    public void trainStr(){
       Arena.CUR_PLAYER.setBaseStr(Arena.CUR_PLAYER.getBaseStr()+1);
       Arena.CUR_PLAYER.setStr(Arena.CUR_PLAYER.getStr()+1);
       Arena.CUR_PLAYER.setMaxHp(Arena.CUR_PLAYER.getMaxHp()+10);
       Arena.CUR_PLAYER.setCurHp(Arena.CUR_PLAYER.getMaxHp());
       Arena.CUR_PLAYER.setXpCredits(Arena.CUR_PLAYER.getXpCredits()-cost);
       this.setCost();
    }
    
    /**
     * Adds one point to baseMag and strMag, adds 10 to maxMp, restores all mp 
     * to the new maxMP, removes cost from player xpCredits, and set's new cost
     */
    public void trainMag(){
       Arena.CUR_PLAYER.setBaseMag(Arena.CUR_PLAYER.getBaseMag()+1);
       Arena.CUR_PLAYER.setMag(Arena.CUR_PLAYER.getMag()+1);
       Arena.CUR_PLAYER.setMaxMp(Arena.CUR_PLAYER.getMaxMp()+10);
       Arena.CUR_PLAYER.setCurMp(Arena.CUR_PLAYER.getMaxMp());
       Arena.CUR_PLAYER.setXpCredits(Arena.CUR_PLAYER.getXpCredits()-cost);
       this.setCost();
    }
    
    /**
     * Adds one point to baseDex and dex, adds 10 to speed, removes cost from
     * player xpCredits, and set's new cost
     */
    public void trainDex(){
       Arena.CUR_PLAYER.setBaseDex(Arena.CUR_PLAYER.getBaseDex()+1);
       Arena.CUR_PLAYER.setDex(Arena.CUR_PLAYER.getDex()+1);
       Arena.CUR_PLAYER.setSpeed(Arena.CUR_PLAYER.getSpeed()+10);
       Arena.CUR_PLAYER.setXpCredits(Arena.CUR_PLAYER.getXpCredits()-cost);
       this.setCost();
    }
    
    /**
     * Calculates cost based on how many abilities and stat points a player has 
     * purchased
     */
    public void setCost(){
        this.cost = (Arena.CUR_PLAYER.getAbilites().size() + 
                Arena.CUR_PLAYER.getBaseDex() + Arena.CUR_PLAYER.getBaseMag() +
                Arena.CUR_PLAYER.getBaseStr()-9)*20;
    }
            
}
    

