/*
 * Implementation of weapon and the parent class for all weapon types
 */
package weapon;

import collections.DexWeapons;
import collections.MagWeapons;
import collections.PhyWeapons;
import java.io.Serializable;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public class WeaponImp implements Serializable, Weapon{

    private final String desription;
    private final String type;
    private String prefix;
    private int str;
    private int mag;
    private int dex;
    private int cost;
    private int value;
    private final int baseCost = 25;


    /**
     * Creates a customized  weapon
     * @param description - i.e Heavy Cross bow
     * @param type - i.e ranged
     * @param prefix - condition
     * @param str - str value the weapon will add to the player's stats
     * @param mag - mag  value the weapon will add to the player's stats
     * @param dex - dex value the weapon will add to the player's stats
     * @param cost - the amount of gold required to purchase 
     * @param value - the amount of gold received when selling
     */
    public WeaponImp(String description, String type, String prefix, int str,
            int mag, int dex, int cost, int value){
        
        this.desription = description;
        this.type = type;
        this.prefix = prefix;
        this.str = str;
        this.mag = mag;
        this.dex = dex;
        this.cost = cost;
        this.value = cost;
    }
    
    /**
     * Creates a new dex based weapon with the random number of stat points
     * based on the player's level.  
     * Assigns the appropriate prefix based on the number of stat points. 
     * @param enumDexWeapons 
     * @param level player's level
     */
    public WeaponImp(DexWeapons enumDexWeapons, int level){
       
        int sumStats;
        this.desription = enumDexWeapons.getDescription();
        this.type = enumDexWeapons.getType();
        int totalStats = (int)(level * Math.random())+1;

        dex = (int)Math.ceil(totalStats*enumDexWeapons.getDexPercent());
        mag = (int)Math.floor(totalStats*enumDexWeapons.getMagPercent());
        str = (int)Math.floor(totalStats*enumDexWeapons.getStrPercent());
        //redistribute lost informat do to integer conversion
        sumStats = dex+mag+str;
        if(sumStats != totalStats){
            dex = dex+totalStats-sumStats;
            sumStats = dex+mag+str;
        }
        this.setCommonAttributes(level, sumStats);
    }
    
    /**
     * Creates a new mag based weapon with the random number of stat points
     * based on the player's level.  
     * Assigns the appropriate prefix based on the number of stat points. 
     * @param enumMagWeapons 
     * @param level player's level
     */
     public WeaponImp(MagWeapons enumMagWeapons, int level){

        int sumStats;
        this.desription = enumMagWeapons.getDescription();
        this.type = enumMagWeapons.getType();
        int totalStats = (int)(level * Math.random())+1;
        mag = (int)Math.ceil(totalStats*enumMagWeapons.getMagPercent());
        dex = (int)Math.floor(totalStats*enumMagWeapons.getDexPercent());
        str = (int)Math.floor(totalStats*enumMagWeapons.getStrPercent());
        //redistribute lost informat do to integer conversion
        sumStats = dex+mag+str;
        if(sumStats != totalStats){
            mag = mag+totalStats-sumStats;
            sumStats = dex+mag+str;
        }
        this.setCommonAttributes(level, sumStats);
    }
     
    /**
     * Creates a new phy based weapon with the random number of stat points
     * based on the player's level.  
     * Assigns the appropriate prefix based on the number of stat points. 
     * @param enumPhyWeapons 
     * @param level player's level
     */   
    public WeaponImp(PhyWeapons enumPhyWeapons, int level){
        
        int sumStats;
        this.desription = enumPhyWeapons.getDescription();
        this.type = enumPhyWeapons.getType();
        int totalStats = (int)(level * Math.random())+1;
        str = (int)Math.ceil(totalStats*enumPhyWeapons.getStrPercent());
        mag = (int)Math.floor(totalStats*enumPhyWeapons.getMagPercent());
        dex = (int)Math.floor(totalStats*enumPhyWeapons.getDexPercent());
        //redistribute lost informat do to integer conversion
        sumStats = dex+mag+str;
        if(sumStats != totalStats){
            str = str+totalStats-sumStats;
            sumStats = dex+mag+str;
        }
        this.setCommonAttributes(level, sumStats);
    }
    
//Get Methods ==================================================================
    
    @Override
    public String getDescription(){
        return this.desription;
    }
    
    @Override
    public String getType(){
        return this.type;
    }
    
    @Override
    public int getStr(){
        return this.str;
    }
    
    @Override
    public int getMag(){
        return this.mag;
    }
    
    @Override
    public int getDex(){
        return this.dex;
    }
    
    @Override
    public String getPrefix() {
        return this.prefix;
    }
    
    @Override
    public int getCost() {
        return this.cost;
    }
    
    @Override
    public int getValue() {
        return this.value;
    }
    
    @Override
    public String getName(){
        return (this.prefix+" "+this.desription);
    }
    
//SetMethods ===================================================================
    
    /**
     * Sets attributes common to all weapon types
     * @param level - player's level
     * @param totalStats - total allocated stat points
     */
    private void setCommonAttributes(int level, int totalStats){
        
        double prefixNumber = (double)(totalStats)/level;
        if(prefixNumber == 1.0){
            this.prefix = "Wonderous";
        }
        else if(prefixNumber >= 0.67 && prefixNumber <1){
            this.prefix = "Extraordinary";
        }
        else if(prefixNumber >= 0.34 && prefixNumber <=0.66){
            this.prefix = "Ordinary";
        }
        else if(prefixNumber >= 0.11 && prefixNumber <=0.33){
            this.prefix = "Rough";
        }
        else{
            this.prefix = "Broken";
        }
        cost = (int)(baseCost*totalStats);
        value = (int)(0.1*cost);
    }
}
