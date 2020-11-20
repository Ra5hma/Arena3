/*
 * Class represents Phy type weapons
 */
package weapon;

import collections.PhyWeapons;
import java.io.Serializable;

/**
 * @author Scott Undersood
 * @author Shawn Ferdig
 */
public class PhyWeapon extends WeaponImp implements Serializable, Weapon{
    
     /**
     * Creates a new phy based weapon with the random number of stat points
     * based on the player's level.  
     * Assigns the appropriate prefix based on the number of stat points. 
     * @param enumPhyWeapons 
     * @param level player's level
     */
    public PhyWeapon(PhyWeapons enumPhyWeapons, int level){
        
        super(enumPhyWeapons, level);        
    }  
    
//Get Methods ==================================================================
    
    @Override
    public String getDescription(){
        return super.getDescription();
    }
    
    @Override
    public String getType(){
        return super.getType();
    }
    
    @Override
    public int getStr(){
        return super.getStr();
    }
    
    @Override
    public int getMag(){
        return super.getMag();
    }
    
    @Override
    public int getDex(){
        return super.getDex();
    }
    
    @Override
    public String getPrefix() {
        return super.getPrefix();
    }
    
    @Override
    public int getCost() {
        return super.getCost();
    }
    
    @Override
    public int getValue() {
        return super.getValue();
    }
    
    @Override
    public String getName(){
        return super.getName();
    }   
}
