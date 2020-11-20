/*
 * This class facilitates interaction between the smithFrame and the player
 * object.
 */
package classes;

import arena3.Arena;
import collections.DexWeapons;
import collections.MagWeapons;
import collections.PhyWeapons;
import java.util.ArrayList;
import weapon.DexWeapon;
import weapon.MagWeapon;
import weapon.PhyWeapon;
import weapon.Weapon;

/**
 * @author Shawn Ferdig
 */
public class Smith {
    
    ArrayList<Weapon> inventory;
    int inventoryLevel = 0;
    
    public Smith(){}
    
//Set Methods ==================================================================
    
    /**
     * Creates a new inventory if the player's level does not equal the player's
     * level form when the inventory was created.
     * @param playerLevel 
     */
    public void setInventory(int playerLevel){
        
        if(outdated(playerLevel)){    
            inventory = new ArrayList<>();
            inventoryLevel = playerLevel;
            for (DexWeapons dexWeapon : DexWeapons.values()) {
                inventory.add(new DexWeapon(dexWeapon, 
                        Arena.CUR_PLAYER.getLevel()));
            }
            for (MagWeapons magWeapon : MagWeapons.values()) {
                inventory.add(new MagWeapon(magWeapon, 
                        Arena.CUR_PLAYER.getLevel()));
            }
            for (PhyWeapons phyWeapon : PhyWeapons.values()) {
                inventory.add(new PhyWeapon(phyWeapon, 
                        Arena.CUR_PLAYER.getLevel()));
            }
        }
    }
    
//Get Methods ==================================================================
    
    public ArrayList<Weapon> getInventory(){
        return this.inventory;
    }
    
    public int getInventoryLevel(){
        return this.inventoryLevel;
    }
    
//Utilities Methods ============================================================

    /**
     * Checks to see if the player's level is different than the player's level 
     * when the inventory was created
     * @param playerLevel
     * @return true if player's level does not equal the inventory level,
     *         otherwise return false
     */
    public boolean outdated(int playerLevel){
        return playerLevel != this.inventoryLevel;
    }
    
    /**
     * Checks to see if the player can afford the selected item with the
     * inclusion of the value of the item currently occupying the same slot.
     * @param index - the index of the selected item in the inventory
     * @return true if the player can afford the item, otherwise false
     */
    public boolean canAfford(int index){
        
        int totalCost;
        totalCost = this.inventory.get(index).getCost() + Arena.CUR_PLAYER.
                getEquip().get(this.inventory.get(index).getType()).getValue();
        return totalCost <= Arena.CUR_PLAYER.getGold();
    }
    
    /**
     * Replaces the weapon type from the players equipment that matches the 
     * weapon type in the smith's inventory at the supplied index with the
     * weapon at that index if the player can afford the weapon.
     * @param index - index of the weapon in the smith's inventory
     * @return - true if the player can afford the weapon, otherwise return
     *           false
     */
    public boolean purchase(int index){
        
        if(canAfford(index)){
            switch(this.inventory.get(index).getType()){
                case("RANGED"):
                    Arena.CUR_PLAYER.getEquip().remove("RANGED");
                    Arena.CUR_PLAYER.getEquip().put("RANGED", this.inventory
                            .get(index));
                    break;
                case("MAGICAL"):
                    Arena.CUR_PLAYER.getEquip().remove("MAGICAL");
                    Arena.CUR_PLAYER.getEquip().put("MAGICAL", this.inventory
                            .get(index));
                    break;
                case("PHYSICAL"):
                    Arena.CUR_PLAYER.getEquip().remove("PHYSICAL");
                    Arena.CUR_PLAYER.getEquip().put("PHYSICAL", this.inventory
                            .get(index));
                    break;     
            }
            Arena.CUR_PLAYER.setAdditionalStats();
            return true;   
        }
        return false;
    }
    
    /**
     * Returns the value player's weapon of type specified by the weapon type of
     * the smith's inventory at the provided index
     * @param index - index of the weapon in the smith's inventory
     * @return - value of the player's weapon
     */
    public int selectionType(int index){
        
        int tradeIn = 0;
        switch(this.inventory.get(index).getType()){
                case("RANGED"):
                    tradeIn = Arena.CUR_PLAYER.getEquip().get("RANGED")
                            .getValue();
                    break;
                case("MAGICAL"):
                    tradeIn = Arena.CUR_PLAYER.getEquip().get("MAGICAL")
                            .getValue();
                    break;
                case("PHYSICAL"):
                    tradeIn = Arena.CUR_PLAYER.getEquip().get("PHYSICAL")
                            .getValue();
                    break;
        }
        return tradeIn;
    }
}
