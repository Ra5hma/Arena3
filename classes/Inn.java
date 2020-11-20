/*
 * This Classes facilites interactions with the Inn GUI
 */
package classes;

import arena3.Arena;
import collections.Items;

import utilities.AudioPlayer;

/**
 * 
 * @author Shawn Ferdig
 */
public class Inn {
    int roomCost = 10;
    AudioPlayer audioPlayer;
    int healthPotionCost = Items.HEALTH.getValue();
    int abilityPotionCost = Items.ABILITY.getValue();
    int comboPotionCost = Items.COMBO.getValue();
    
    /**
     * This constructor sets the inn prices based on the player's level
     * @param lvl 
     */
    public Inn(int lvl){
        
        healthPotionCost = (int)(healthPotionCost*lvl*0.1+healthPotionCost);
        abilityPotionCost = (int)(abilityPotionCost*lvl*0.1+abilityPotionCost);
        comboPotionCost = (int)(comboPotionCost*lvl*0.1+comboPotionCost);
        roomCost = (int)(roomCost*lvl*0.1+roomCost);  
    }
       

//Get Methods ================================================================== 
    
    public int getHealthPotionCost(){
        return this.healthPotionCost;
    }
    
    public int getAbilityPotionCost(){
        return this.abilityPotionCost;
    }
    
    public int getComboPotionCost(){
        return this.comboPotionCost;
    }
    
    public int getRoomCost(){
        return this.roomCost;
    }
    
//Utility Methods ============================================================== 
    
    /**
     * Decreases player's gold, restores hP and Mp
     * @return - true if player can afford the room cost, otherwise returns 
     *           false
     */
    public boolean rentRoom(){
        
        if(this.canAfford(this.roomCost)){
            Arena.CUR_PLAYER.setCurHp(Arena.CUR_PLAYER.getMaxHp());
            Arena.CUR_PLAYER.setCurMp(Arena.CUR_PLAYER.getMaxMp());
            Arena.CUR_PLAYER.setGold(Arena.CUR_PLAYER.getGold()-roomCost);
            return true;
        }
        return false;
    }
    
    /**
     * Decreases player's gold and increases players health potions
     * @return - true if player can afford the potion, otherwise returns false           
     */
    public boolean buyHealthPotion(){
        if(this.canAfford(this.healthPotionCost)){
            Arena.CUR_PLAYER.setGold(Arena.CUR_PLAYER.getGold()-
                    this.getHealthPotionCost());
            Arena.CUR_PLAYER.getItems().get(Items.HEALTH.getName())
                    .setQuantity(Arena.CUR_PLAYER.getItems()
                            .get(Items.HEALTH.getName()).getQuantity()+1);
            return true;
        }
        return false;
    }
    
    /**
     * Decreases player's gold and increases players ability potions
     * @return - true if player can afford the potion, otherwise returns false           
     */
    public boolean buyAbilityPotion(){
             
        if(this.canAfford(this.abilityPotionCost)){
            Arena.CUR_PLAYER.setGold(Arena.CUR_PLAYER.getGold()
                    -getAbilityPotionCost());
            Arena.CUR_PLAYER.getItems().get(Items.ABILITY.getName())
                    .setQuantity(Arena.CUR_PLAYER.getItems()
                            .get(Items.ABILITY.getName()).getQuantity()+1);
            return true;
        }
        return false;
    }
    
    /**
     * Decreases player's gold and increases players combo potions
     * @return - true if player can afford the potion, otherwise returns false           
     */
    public boolean buyComboPotion(){
        
        if(this.canAfford(this.comboPotionCost)){
            Arena.CUR_PLAYER.setGold(Arena.CUR_PLAYER.getGold()
                    -getComboPotionCost());
            Arena.CUR_PLAYER.getItems().get(Items.COMBO.getName())
                    .setQuantity(Arena.CUR_PLAYER.getItems()
                            .get(Items.COMBO.getName()).getQuantity()+1);
            return true;
        }
        return false;
    }
    
    /**
     * return true if a players gold is not less than the given cost
     * @param cost of item or service
     * @return - true if a players gold is not less than the given cost, 
     *           otherwise returns false        
     */
    public boolean canAfford(int cost){
        return(!(Arena.CUR_PLAYER.yaBroke(cost)));
    }
}
