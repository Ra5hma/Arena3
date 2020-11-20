/*
 * Class that represents the Health, Ability, and Combo potions
 */
package classes;

import java.io.Serializable;
import collections.Items;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Shawn Ferdig
 */
public class Item implements Serializable{

    private final int[] soundFiles = {4,6};
    private final String name;
    private int quantity = 0;
    private final double hp;
    private final double mp;
    private final int value;

    
    public Item(Items enumItem){

        this.name = enumItem.getName();
        this.hp = enumItem.getHp();
        this.mp = enumItem.getMp();
        this.value = enumItem.getValue();
    }
    
    //Set Methods ==============================================================

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
    //Get Methods ==============================================================

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    public int getSoundFile(int index){
        return soundFiles[index];
    }
    
    public int getSoundFileNumber(){
        return soundFiles.length;
    }
    
    public int[] getSoundFiles(){
        return this.soundFiles;
    }
    
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return the hp
     */
    public double getHp() {
        return hp;
    }

    /**
     * @return the mp
     */
    public double getMp() {
        return mp;
    }
    
    /**
     * @return 
     *      - value the gold received upon sale
     */
    public int getValue(){
        return value;
    }
    
    //Utility Methods ==========================================================
    
    /**
     * This uses potions in the Items Enum. the return values will be dependent 
     * on which type if instance calls the method. This method decrements the 
     * quantity but doesn't provide means to check if the quantity 0 before running
     * @param player - owner of the the item 
     * @return restored - a Map containing the hp and ap restored
     */
    public Map<String, Integer> use(Player player){

        Map<String, Integer> restored = new HashMap<>();
        Integer hpRestored;
        Integer apRestored;
        quantity--;
        if((player.getCurHp()<= player.getMaxHp()) && (player.getMaxHp() 
                <= player.getCurHp()+player.getMaxHp()*hp))
        {
            
            hpRestored = player.getMaxHp()-player.getCurHp();
            restored.put("hp", hpRestored);
            player.setCurHp(player.getMaxHp());
        }
        else if (player.getMaxHp()> player.getCurHp()+player.getMaxHp()*hp){
            
            hpRestored = (int)(player.getMaxHp()*hp);
            restored.put("hp", hpRestored);
            player.setCurHp(player.getCurHp()+(int)(player.getMaxHp()*hp));
        }
        else
            restored.put("hp", 0);
        if((player.getCurMp()<= player.getMaxMp()) && (player.getMaxMp() 
                <= player.getCurMp()+player.getMaxMp()*mp)){
            
            apRestored = player.getMaxMp()-player.getCurMp();
            restored.put("ap", apRestored);
            player.setCurMp(player.getMaxMp());
        }
        else if(player.getMaxMp()> player.getCurMp()+player.getMaxMp()*mp){
            
            apRestored = (int)(player.getMaxMp()*mp);
            restored.put("ap", apRestored);  
            player.setCurMp(player.getCurMp()+(int)(player.getMaxMp()*mp));
        }
        else
            restored.put("ap", 0);
        return restored;
    }
}
