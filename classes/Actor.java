/* 
 * An interface used for both players and mobs
 */
package classes;

 /*
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public interface Actor{
    
//Set Methods ==================================================================

    public void setCurHp(int hp);   
    public void setCurMp(int mp);
    public void setStr(int str);
    public void setMag(int mag);
    public void setDex(int dex);
    public void setMaxHp(int maxHp);
    public void setMaxMp(int maxMp);
    public void setBaseStr(int bp);
    public void setBaseMag(int bm);
    public void setBaseDex(int bd);
    public void setSpeed(int spd);
    
    //Get Methods ==============================================================
    
    public int getCurHp();
    public int getLevel();
    public int getMaxHp();
    public int getStr();
    public int getMag();
    public int getDex();
    public int getCurMp();
    public String getName();
    public String getRole();
    public int getSpeed();
    public int getMaxMp();
    public int getBaseStr();
    public int getBaseMag();
    public int getBaseDex();
    
    //Utility Methods ==========================================================
    
    /**
     * Checks to see if the actor's current hit points are greater than 0;
     * @return true if the hit points are less than one otherwise return false 
     */
    public boolean yaDead();   
}

