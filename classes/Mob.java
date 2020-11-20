/* 
 * This class is the CPU oppenent for the player in the Arena.
 */
package classes;
import collections.MobTypes;
import collections.Roles;
import utilities.Die;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public final class Mob implements Actor{
    private String name;
    String role;
    private int str = 3;                                                        
    private int mag = 3; 
    private int dex = 3; 
    private int level = 1;
    private int curHp = 30;
    private int curMp = 30;
    private int speed = 30;
    private int maxHp = 30;
    private int maxMp = 30;
    private int mobDif = 1;                                              
    private int type;
    private final Die dn = new Die(MobTypes.values().length);
    private final Die d6 = new Die(6);                                          
    private String staticImage;
    private String physicalImage;
    private String magicalImage;
    private String rangedImage;
    private String magicalProjectileImage;
    private String rangedProjectileImage;
    private String physicalSound;
    private String magicalSound;
    private String rangedSound;
    private int xpValue;
    private int goldValue;

    /**
     * This constructor derives mob sets based on the given player level
     * @param lvl - player's level
     */
    public Mob(int lvl){
        this.level = lvl;
        this.setLevel();
        this.setType();
        this.setName();
        this.setStaticImage();
        this.setPhysicalImage();
        this.setMagicalImage();
        this.setRangedImage();
        this.setRangedProjectileImage();
        this.setMagicalProjectileImage();
        this.setStats();
        this.setRole();
        this.setPhysicalSound();
        this.setMagicalSound();
        this.setRangedSound();
        this.setXpValue();
        this.setGoldValue(); 
    }  
    
    /**
     * Constructor intended for testing purposes only
     * @param name
     * @param role
     * @param level
     * @param str
     * @param mag
     * @param dex 
     * @param xpValue 
     * @param goldValue
     */
    public Mob(String name, String role, int level, int str, int mag, 
            int dex, int xpValue, int goldValue){
        this.name = name;
        this.role = role;
        this.level = level;
        this.str = str;
        this.mag = mag;
        this.dex = dex;
        this.xpValue = xpValue;
        this.goldValue = goldValue;
    }
    
//Set Methods ==================================================================
 
    /**
     * Sets a random mob type
     */
    private void setType(){
        
        dn.roll();
        type = dn.getValue()-1;
    }
    
    /**
    * Randomly sets a name for the mob based on the names determined in the 
    * MobType Enum
    */
    private void setName(){    
        name = MobTypes.values()[type].getName();  
    }
    
    /**
     * Sets mob's static image based on mob type
     */
    public void setStaticImage(){
        staticImage = MobTypes.values()[type].getStaticImage();

    }

    /**
     * Sets mob's physical image based on mob type
     */
    private void setPhysicalImage(){
        physicalImage = MobTypes.values()[type].getPhysicalImage();
    }
    
    /**
     * Sets mob's magical image based on mob type
     */
    private void setMagicalImage(){
        magicalImage = MobTypes.values()[type].getMagicalImage();
    }
    
    /**
     * Sets mob's ranged image based on mob type
     */
    private void setRangedImage(){
        rangedImage = MobTypes.values()[type].getRangedImage();
    }
    
    /**
     * Sets mob's magical projectile based on mob type
     */
    private void setMagicalProjectileImage(){   
        magicalProjectileImage = MobTypes.values()[type]
                .getMagicalProjectileImage();
    }
    
    /**
     * Sets mob's ranged projectile image based on mob type
     */
    private void setRangedProjectileImage(){
        rangedProjectileImage = MobTypes.values()[type]
                .getRangedProjectileImage();
    }
    
    /**
     * Sets mob's physical sound based on mob type
     */
    private void setPhysicalSound(){
        physicalSound = MobTypes.values()[type].getPhysicalSound();
    }
    
    /**
     * Sets mob's magical sound based on mob type
     */
    private void setMagicalSound(){
        magicalSound = MobTypes.values()[type].getMagicalSound();
    }
    
    /**
     * Sets mob's ranged sound based on mob type
     */
    private void setRangedSound(){
        rangedSound = MobTypes.values()[type].getRangedSound();
    }
    
    /**
    * Sets a role for the mob  determined in the 
    * role array based on the stat rolls
    */
    public void setRole(){

        if(str/(double)(mag + str + dex)>=.5){
            role = Roles.PHYSICAL.getRole();
        }
        else if(mag/(double)(mag + str + dex)>=.5){
            role = Roles.MAGICAL.getRole();
        }
        else if(dex/(double)(mag + str + dex)>=.5){
                role = Roles.RANGED.getRole();
        }        
        else{ role = Roles.BALANCED.getRole();}
    }
    
    /**
    * Mob difficulty is based on a regular distribution where the mob will most 
    * often be a player's level, but can sometimes be a level above or below.
    */
    private void setLevel(){
        
        mobDif = (d6.multiRoll(2)-1)/4;
        switch(mobDif){
            case(0):
                if(level>1){
                    this.level--;
                    break;
                }
            case(2):
                this.level++;
                break;
        }
    }
    
    /**
     * Set the mobs xp value based on the player's level
     */
    private void setXpValue(){
        this.xpValue = (int)((this.level+10)+((this.level+10)*0.1));
    }
    
    /**
     * Set the mobs gold value based on the player's level
     */
    private void setGoldValue(){
        this.goldValue = (int)(this.level*10*1.5);
    }
    
    /**
     * Set the mobs stat value based on the player's level
     */
    private void setStats(){
        
        Die statDie = new Die(this.level+6);
        this.str = statDie.getValue();
        statDie.setSides(this.level+7-this.str);
        statDie.roll();
        this.mag = statDie.getValue();
        this.dex = this.level+8-this.str-this.mag;
        this.maxHp = this.str*10+50;
        this.curHp = this.maxHp;
        this.maxMp = this.mag*10;
        this.curMp = this.maxMp;
        this.speed = this.dex*10;
    }
        
    @Override
    public void setMaxHp(int maxHp){
       this.maxHp = maxHp;
    }
    
    @Override
    public void setMaxMp(int maxMp){
        this.maxMp = maxMp;
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
    public void setBaseStr(int baseStr) {}

    @Override
    public void setBaseMag(int baseMag) {}

    @Override
    public void setBaseDex(int baseDex) {}

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
//Get Methods ==================================================================
    
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
    public int getMaxMp() {
        return this.maxMp;
    }
    
    public int getType(){
        return type;
    }
    
    public String getStaticImage(){
        return staticImage;
    }
    
    public String getPhysicalImage(){
        return this.physicalImage;
    }
    
    public String getMagicalImage(){
        return this.magicalImage;
    }
    
    public String getRangedImage(){
        return this.rangedImage;
    }
    
    public String getMagicalProjectileImage(){
        return this.magicalProjectileImage;
    }
    
    public String getRangedProjectileImage(){
        return this.rangedProjectileImage;
    }
    
    public String getPhysicalSound(){
        return this.physicalSound;
    }
    
    public String getMagicalSound(){
        return this.magicalSound;
    }
    
    public String getRangedSound(){
        return this.rangedSound;
    }
    
    public int getXpValue(){
        return this.xpValue;
    }
    
    public int getGoldValue(){
        return this.goldValue;
    }
    
    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getBaseStr() {
        return this.str;
    }

    @Override
    public int getBaseMag() {
        return this.mag;
    }

    @Override
    public int getBaseDex() {
        return this.dex;
    }
    
//Utility Methods ==============================================================
    
    /**
     * Checks to see if the actor's current hit points are greater than 0;
     * @return true if the hit points are less than one otherwise return false 
     */
    @Override
    public boolean yaDead() {
        return curHp<1;
    }
}
