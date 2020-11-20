/* 
 * Instance of a player controlled character
 */
package classes;

import abilities.*;
import collections.DexWeapons;
import collections.Items;
import collections.MagWeapons;
import collections.PhyWeapons;
import collections.Roles;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import weapon.*;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public final class Player implements Actor, Serializable{
    
    private String name;
    private String role;
    private int level = 1;
    private int str = 3;
    private int mag = 3;
    private int dex = 3;
    private int maxHp = 80;                                                      
    private int curHp = 30;                                                          
    private int speed  = 30;                                                                    
    private int maxMp =30;                                         
    private int curMp = 10;
    private int baseStr = 3;
    private int baseMag = 3;
    private int baseDex = 3;
    //number of fights completed
    private int floor;                                                          
    private int gold = 100000;                                                    
    private int xp = 0;                                                        
    private int xpCredits = 0;
    private Map<String, Weapon> equip = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();
    private final Map<String, Ability> abilities = new HashMap<>();
    private int tnl = 20;
    private Bet bet;
    private int additionalStr = 0;
    private int additionalMag = 0;
    private int additionalDex = 0;
    private final int[] phySounds = {12};
    private final int[] magSounds = {13};
    private final int[] rngSounds = {14};
    
    /**
     * Constructor is used when the game starts.
     */
    public Player(){
        
        bet = new Bet();
        equip.put("PHYSICAL", new PhyWeapon(PhyWeapons.BASTARD_SWORD, 
                this.getLevel()));
        equip.put("MAGICAL", new MagWeapon(MagWeapons.WIZARDS_STAFF, 
                this.getLevel()));
        equip.put("RANGED", new DexWeapon(DexWeapons.LONG_BOW, this.getLevel()));
        items.put(Items.HEALTH.getName(), new Item(Items.HEALTH));
        items.put(Items.ABILITY.getName(), new Item(Items.ABILITY));
        items.put(Items.COMBO.getName(), new Item(Items.COMBO));

    }

    /**
     * Used for New character creation
     * @param name - String Player's name
     * @param role - String role type
     * @param level - int Player's level
     * @param str - int Player's strength stat
     * @param mag - int Player's Magic stat
     * @param dex - int Player's dexterity stat
     */
    public Player(String name, String role, int level, int str, 
            int mag, int dex){
        
        this.name = name;
        this.role = role;
        this.level = level;
        this.baseStr = str;
        this.baseMag = mag;
        this.baseDex = dex;
        this.setMaxHp(this.baseStr*10+50);
        this.setCurHp(this.maxHp);
        this.setMaxMp(this.baseMag*10);
        this.setCurMp(this.maxMp);
        bet = new Bet();
        equip.put("PHYSICAL", new PhyWeapon(PhyWeapons.BASTARD_SWORD,
                this.getLevel()));
        equip.put("MAGICAL", new MagWeapon(MagWeapons.WIZARDS_STAFF,
                this.getLevel()));
        equip.put("RANGED", new DexWeapon(DexWeapons.LONG_BOW, this.getLevel()));
        items.put(Items.HEALTH.getName(), new Item(Items.HEALTH));
        items.put(Items.ABILITY.getName(), new Item(Items.ABILITY));
        items.put(Items.COMBO.getName(), new Item(Items.COMBO));        
        this.setAdditionalStats();
        this.applyEuipmentStats();

    }
    
    /**
     * Used for display on the character creation menu
     * @param name
     * @param role
     * @param str
     * @param mag
     * @param dex
     */
    public Player(String name, String role, int str, int mag, int dex){
        
        this.name = name;
        this.role = role;
        this.str = str;
        this.mag = mag;
        this.dex = dex;
        this.baseStr = str;
        this.baseMag = mag;
        this.baseDex = dex;
        this.setMaxHp(str*10+50);
        this.setMaxMp(mag*10);
        this.setSpeed(dex*10);
    }
    
//Set Methods ==================================================================
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    @Override
    public void setCurHp(int hp){
        this.curHp = hp;
    }
    
    @Override
    public void setCurMp(int mp){
        this.curMp = mp;
    }
    
    public void setLevel(int lvl){
        this.level = lvl;
    }
    
    @Override
    public void setStr(int str){
        this.str = str;
    }
    
    @Override
    public void setMag(int mag){
        this.mag = mag;
    }
    
    @Override
    public void setDex(int dex){
        this.dex = dex;
    }
    
    @Override
    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }
    
    public void setGoldWagered(int gold, int rounds){
        bet.setWager(gold, rounds);
    }
    
    public void setRoundsWagered(int gold, int rounds){
        bet.setRounds(gold, rounds);
    }
    
    @Override
    public void setMaxMp(int maxMp){
        this.maxMp = maxMp;
    }
    
    public void setXpCredits(int xpc){
        xpCredits = xpc;
    }

    /** 
     * Set the number of floors cleared
     * @param flr cleared
     */
    public void setFloor(int flr){
        floor = flr;
    }
    
    public void setXp(int exp){
        xp = exp;
    }
    
    public void setGold(int gld){
        gold = gld;
    }
    
    public void setTnl(int x){
        tnl = x;
    }
    
    @Override
    public void setBaseStr(int baseStr){
        this.baseStr = baseStr;
    }
    @Override
    public void setBaseDex(int baseDex){
        this.baseDex = baseDex;
    }
    @Override
    public void setBaseMag(int baseMag){
        this.baseMag = baseMag;
    }
    
    /**
     * Set a new list of equipment;      
     */
    public void setEquip(Map<String, Weapon> newEquip){
        equip = newEquip;
    }
    
    /**
     * set new physical type weapon and recalculate stats
     * @param sword - physical weapon
     */
    public void setSword(PhyWeapon sword){
        equip.put(PhyWeapons.DAGGER.getType(), sword);
        this.setAdditionalStats();
    }
    
    /**
     * set new magical type weapon and recalculate stats
     * @param gem - magical weapon        
     */
    public void setGem(MagWeapon gem){
        equip.put(MagWeapons.WAND.getType(), gem);
        this.setAdditionalStats();
    }
    
    /**
     * set new ranged type weapon and recalculate stats
     * @param bow - ranged weapon
     */
    public void setBow(DexWeapon bow){
        equip.put(DexWeapons.LONG_BOW.getType(), bow);
        this.setAdditionalStats();
    }
    
    /**
     * Set additional str stats from equipment
     */
    public void setAdditionalStr(){

        int prevAdditionStr = additionalStr;
        for ( Map.Entry<String, Weapon> weapon: equip.entrySet()){
           additionalStr = additionalStr + weapon.getValue().getStr();
        }  
        additionalStr = additionalStr - prevAdditionStr;
    }

    /**
     * Set additional mag stats from equipment
     */
    public void setAdditionMag(){
        
        int prevAdditionMag = additionalMag;
        for ( Map.Entry<String, Weapon> weapon: equip.entrySet()){
            additionalMag = additionalMag + weapon.getValue().getMag();
        }
        additionalMag = additionalMag - prevAdditionMag;
    }

    /**
     * Set additional dex stat from equipment
     */
    public void setAdditionalDex(){
        
        int prevAdditionDex = additionalDex;
        for ( Map.Entry<String, Weapon> weapon: equip.entrySet()){ 
            additionalDex = additionalDex + weapon.getValue().getDex();
        } 
        additionalDex = additionalDex - prevAdditionDex;
    } 
    
    public void setItems(Map<String, Item > itemsList){
       items = itemsList; 
    }
    
    public void setBetActive(boolean isActive){
        this.bet.setActive(isActive);
    }
    
    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

//Get Methods ==================================================================
    
    public int getXpCredits(){
        return xpCredits;
    }
    
    @Override
    public int getCurHp(){
        return this.curHp;
    }
    
    @Override
    public int getLevel(){
        return this.level;
    }
    
    @Override
    public int getMaxHp(){    
        return this.maxHp;
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
    public int getBaseStr(){
        return this.baseStr;
    }
    
    @Override
    public int getBaseMag(){
        return this.baseMag;
    }
    
    @Override
    public int getBaseDex(){
        return this.baseDex;
    }
    
    @Override
    public int getCurMp(){
        return this.curMp;
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public String getRole(){
        return this.role;
    }
    
    @Override
    public int getSpeed(){
        return this.speed;
    }
    
    @Override
    public int getMaxMp(){
        return this.maxMp;
    }
    
    public int getAdditionalStr(){
        return additionalStr;
    }
    
    public int getAdditionalMag(){
        return additionalMag;
    }
    
    public int getAdditionalDex(){
        return additionalDex;
    }
    
    public int[] getPhySounds(){ 
        return this.phySounds;
    }
    
    public int[] getPlayerMagSounds(){ 
        return this.magSounds;
    }
    
    public int[] getPlayerRngSounds(){ 
        return this.rngSounds;
    } 
    
    /** 
     * Get the number of fights cleared
     * @return the number of fights cleared 
     */
    public int getFloor(){
        return floor;
    }
    
    public int getXp(){
        return xp;
    }
    
    public int getGold(){
        return gold;
    }
    
    public int getTnl(){
        return tnl;
    }
    
    public int getGoldWagered(){
        return bet.getWager();
    }
    
    public int getRoundsWagered(){
        return bet.getRounds();
    }
    
    public int getPayOut(){
        return bet.getPayout();
    }
    
    /**
     * Get the current equipped items as an array list
     * @return equip
     */
    public Map<String, Weapon> getEquip(){
        return equip;
    }
    
    public Map<String, Ability> getAbilites(){
        return abilities;
    }
    
    public Map<String, Item> getItems(){
        return items;
    }
    
    /**
     * Get the physical weapon
     * @return equipment object for str weapon
     */
    public Weapon getSword(){
        return equip.get("PHYSICAL");
    }
    /**
     * Get the magical weapon
     * @return equipment object for mag weapon
     */
    public Weapon getGem(){
        return equip.get("MAGICAL");
    }
    /** 
     * Get the ranged weapon
     * @return equipment object for dex weapon
     */
    public Weapon getBow(){
        return equip.get("RANGED");
    }
    
//Utility Methods ==============================================================
    
    public boolean isBetActive(){
        return this.bet.isActive();
    }
    
    /**
     * Checks to see if the actor's current gold is < the cost;
     * @return true if player's gold is less than cost, otherwise return false 
     */
    public boolean yaBroke(int cost){
        return cost>gold;
    }
    
    /**
     * Checks to see if the actor's current hit points are greater than 0;
     * @return true if the hit points are less than one otherwise return false 
     */
    @Override
    public boolean yaDead(){
        return curHp<1;
    }
    
    /**
     * Checks to see if the actor's xpCredits is < the cost;
     * @return true if player's xpCredits is less than cost, 
     * otherwise return false 
     */
    public boolean yaNub(int cost){
        return cost>xpCredits;
    }
    
    /**
     * Checks to see if the actor's curMp is < the cost;
     * @return true if player's curMp is less than cost, 
     * otherwise return false 
     */
    public boolean yaDumz(int cost){
        return cost>curMp;
    }
    
    /**
     * Increments level, setXp, adds xpCredits, calculates xp to next level
     */
    public void levelUp(){
        xp = xp-tnl;
        xpCredits = xpCredits+tnl;
        tnl = (int)(tnl+tnl*0.1+20);
        level ++;
    }
    
    /**
     * Set all additional stats from the equipment list
     */
    public void setAdditionalStats(){
        this.setAdditionalStr();
        this.setAdditionMag();
        this.setAdditionalDex();
        this.applyEuipmentStats();       
    }
    
    /**
     * Evaluates stats and assigns the appropriate role
     */
    public void roleAdjust(){

        if(str/(double)(mag+str+dex)>=.5)
            role = Roles.PHYSICAL.getRole();
        else if(mag/(double)(mag+str+dex)>=.5)
            role = Roles.MAGICAL.getRole();
        else if(dex/(double)(mag+str+dex)>=.5)
            role = Roles.RANGED.getRole();
        else
            role = Roles.BALANCED.getRole();
    }
    
    /**
   * Uses specified potion. This method decrements the quantity but does
   * not provide means to check if the quantity 0 before running 
   * @param type - the type of potion to be used
   * @return restored - a Map containing the hp and ap restored
   */
    public Map<String, Integer> useItem(String type){  
        return this.getItems().get(type).use(this);
    }
    
    /**
     * Applies the additional stat values from equipment to the players stats
     */
    public void applyEuipmentStats(){
        this.str = this.baseStr + this.additionalStr;
        this.mag = this.baseMag + this.additionalMag;
        this.dex = this.baseDex + this.additionalDex;

    }   
  
}
