/*
 * This class manages the enteractions between the player and mob during arena
 * battles.
 */
package classes;

import utilities.Die;
import arena3.Arena;
import collections.*;
import java.util.Map;

/**
 * @author Shawn Ferdig
 */
public class Battle {

    private Player hero = Arena.CUR_PLAYER;                          
    private Mob opp = new Mob(hero.getLevel());                 
    private final Die six = new Die(6);                                     
    private int turnCount =0;
    private double turnRatio = hero.getBaseDex()/opp.getDex();
    private int round = 0;
    //holds orginal base strength used to reset players stats when exiting
    private int orgBaseStr; 
    //holds orginal base magic used to reset players stats when exiting
    private int orgBaseMag;
    //holds orginal base magic used to reset players stats when exiting
    private int orgBaseDex;
    private boolean extraTurn;

    public Battle(){
    }

    /**
     * This constructor is for test use only
     * @param player - test Player
     */
    public Battle(Player player){
        this.hero = player;
    }
    
    /**
     * This constructor is for test use only
     * @param player - test Player
     * @param mob - test opponent
     */
    public Battle(Player player, Mob mob){
        this.hero = player;
        this.opp = mob;
    }
//Set Methods ==================================================================

    
    public void setTurnRatio(){
        
        if(hero.getDex()/opp.getDex()==1)
            turnCount = 0;
        turnRatio = (double)hero.getDex()/opp.getDex();
    }


    
    public Player getHero() {
        return hero;
    }
    
    public Mob getOpp() {
        return opp;
    }
    
    public double getTurnRatio(){
        return turnRatio;
    }
    
    public int getTurnCount(){
        return this.turnCount;
    }
    
    public int getRound(){
        return this.round;
    }
    
    public boolean getExtraTurn(){
        return this.extraTurn;
    }

//Utility Methods ==============================================================
    
    /**
     * Uses mob and player dex stat to determine who takes the first turn
     * @return true if the player's dex is higher or equal to the mob's dex, 
     *         otherwise returns false
     */
    public boolean isPlayerFirst(){
        return hero.getDex() >= opp.getDex();
    }
    
    /**
     * Checks if the the bet should be paid out
     * @return true if the number 
     */
    public boolean winBet(){
        return this.round == this.hero.getRoundsWagered();
    }
    
    /**
     * Gets the gold awarded to the player for winning a bet and resets the 
     * player's bet.
     * @return the amount of gold the player has won
     */
    public int payOut(){
        int payOut = this.hero.getPayOut();
        this.hero.setGold(this.hero.getGold()+payOut);
        this.hero.setGoldWagered(0, 0);
        this.hero.setRoundsWagered(0, 0);
        return payOut;
    }
    
    /**
     * performs the physical attack action  
     * @param attacker the actor doing damage
     * @param defender the actor taking damage
     * @return calculated damage
    */
    public int phyAtt(Actor attacker, Actor defender){
        
        int damage = attack(attacker.getStr(),
                defender.getStr(), attacker.getLevel());
        displayDamage(defender, damage);
        //adjust stats
        if(statCheck(attacker.getBaseMag())){
            attacker.setStr(attacker.getStr()+1);
            attacker.setBaseStr(attacker.getBaseStr()+1);
            attacker.setMag(attacker.getMag()-1);
            attacker.setBaseMag(attacker.getBaseMag()-1);
            battleRoleAdjust();
            setTurnRatio();
        }
        return damage;
    }
    
    /**
     * performs the magical attack action  
     * @param attacker the actor doing damage
     * @param defender the actor taking damage
     * @return calculated damage
    */
    public int magAtt(Actor attacker, Actor defender){

        int damage = attack(attacker.getMag(),
                defender.getMag(), attacker.getLevel());
        displayDamage(defender, damage);
        //adjust stats
        if(statCheck(attacker.getBaseDex())){
            attacker.setMag(attacker.getMag()+1);
            attacker.setBaseMag(attacker.getBaseMag()+1);
            attacker.setDex(attacker.getDex()-1);
            attacker.setBaseDex(attacker.getBaseDex()-1);
            battleRoleAdjust();
            setTurnRatio();
        }
        return damage;
    }
    
    /**
     * performs the ranged attack action  
     * @param attacker the actor doing damage
     * @param defender the actor taking damage
     * @return calculated damage
    */
    public int rngAtt(Actor attacker, Actor defender){

        int damage = attack(attacker.getDex(),
                defender.getDex(), attacker.getLevel());
        displayDamage(defender, damage);
        //adjust stats
        if(statCheck(attacker.getBaseStr())){
            attacker.setDex(attacker.getDex()+1);
            attacker.setBaseDex(attacker.getBaseDex()+1);
            attacker.setStr(attacker.getStr()-1);
            attacker.setBaseStr(attacker.getBaseStr()-1);
            battleRoleAdjust();
            setTurnRatio();
        }
        return damage;
    }

    /**
     * Determines the mob's action for the mobs turn
     * @return as string that is the mob's action
     */
    public String mobAttack(){
        
        this.turnCount = this.turnCount+1;
        this.setTurnRatio();
        if(this.turnRatio > 1){
            if(this.extraAtt()){
                this.turnCount = 0;
                return "Speed Attack";
            }
        }
        if(this.extraTurn){
            this.extraTurn = false;
            return "skip";
        }
        //determine mob attack type
        double max = opp.getStr()/(double)hero.getStr();
        if(max > opp.getMag()/(double)hero.getMag() && max > 
                opp.getDex()/(double)hero.getDex()){
            phyAtt(opp, hero); 
            if(this.turnRatio < 1){
                if(this.extraAtt()){
                    turnCount = 0;
                    return "phyExtra";
                }
            }
            return "phy";
        }
        else if(max > opp.getMag()/(double)hero.getMag() && max < 
                opp.getDex()/(double)hero.getDex()){
            rngAtt(opp,hero);         
            if(this.turnRatio < 1){
                if(this.extraAtt()){
                    turnCount = 0;
                    return "rngExtra";
                }
            }
            return "rng";    
        }
        else{
            magAtt(opp,hero);
            if(this.turnRatio < 1){
                if(this.extraAtt()){
                    turnCount = 0;
                    return "magExtra";
                } 
            }
            return "mag";
        }
    }
    
    /**
     * Calculates the amount of damage
     * @param att attacker's appropriate stat
     * @param def defender's appropriate stat
     * @param lvl attacker's level
     * @return the amount of damage 
     */
    public int attack(int att, int def, int lvl){

        double ratio = att/(double)def;
        int rangeFloor = lvl;
        int rangeCeiling = lvl + 9;
        if(ratio > 1){
            if((int)(rangeFloor + ((ratio-1)*10))<rangeCeiling)
                rangeFloor=(int)(rangeFloor + ((ratio-1)*10));
            else
                rangeFloor = rangeCeiling;
        } 
        if(ratio < 1)
            if(rangeCeiling - (int)(rangeCeiling - (ratio*10))>rangeFloor)
                 rangeCeiling = rangeCeiling - (int)(rangeCeiling - (ratio*10));
            else
                rangeCeiling = rangeFloor;
        int rangeDistance;
        if(rangeCeiling - rangeFloor == 0)
              rangeDistance = 1;
        else
           rangeDistance = rangeCeiling - rangeFloor;
        int attackAdd = (int)(rangeDistance/12.0*six.multiRoll(2));
        int attack = attackAdd + rangeFloor; 
        return attack;
    }

    /**
     * Determines if the given stat is one
     * @param y  given stat
     * @return true if the given stat is not one, otherwise return false
     */
    public boolean statCheck(int y){
        return y != 1;
    }
    
    /**
     * checks for hp reduced below zero, displays zero instead of negative 
     * @param defender
     * @param damage
     */
    public void displayDamage(Actor defender, int damage){

        if((defender.getCurHp()-damage) < 0)
            defender.setCurHp(0);
        else
            defender.setCurHp(defender.getCurHp()-damage);
    }

    /**
     * Check the extra turn status
     * @return 
     */
    public boolean extraAtt(){
        if(turnRatio >1)
            return turnCount >= 11-(int)(turnRatio);
        return turnCount >= 11-(int)(turnRatio*10);
    }
    
    /**
     * Rewards the player with experience points, gold at the end of a round
     * Checks the xp  and the tnl values to determine if the player has leveled
     * up
     * @return - true if the player has leveled, otherwise return false 
     */
    public boolean drops(){
        
        hero.setXp(hero.getXp()+opp.getXpValue());
        hero.setGold(hero.getGold()+opp.getGoldValue());
        if(hero.getXp() >= hero.getTnl()){
            hero.levelUp();
            return true;
        }
        return false;
    }
    
    /**
     * Creates a new mob object and resets the turn ration and turn count
     * @param - the players level 
     */
    public void nextOpp(int lvl){
        
        opp = new Mob(lvl);
        turnRatio = (double)hero.getDex()/opp.getDex();
        turnCount = 0;
    }
    
    /**
     * Adjusts the player's role
     */
    public void battleRoleAdjust(){
        this.hero.roleAdjust();
    }
    
    /**
     * Uses specified potion. This method decrements the quantity but does
     * not provide means to check if the quantity 0 before running 
     * @param type - the type of potion to be used
     * @return restored - a Map containing the hp and ap restored
     */
    public Map<String, Integer> useItem(String type){
        return this.hero.useItem(type);   
    }
    
    /**
     * Use an ability based on the provided string and returns the result of 
     * that ability and adjusts the player's role
     * @param type  - the name of the ability to be used
     * @return - the result of the ability
     */
    public Map<String, Integer> useAbility(String type){
        Map<String, Integer> result = this.hero.getAbilites().get(type).use(this);
        if(type.equals(Abilities.CRITICAL_ATTACK.getName())){
            this.strShift(hero);
        }
        else if(type.equals(Abilities.MAGIC_MISSILE.getName())){
            this.magShift(hero);
        }
        else if(type.equals(Abilities.CURE.getName())){
            this.magShift(hero);
        }
        else if(type.equals(Abilities.DOUBLE_ATTACK.getName())){
            this.extraTurn = true;
        }
        this.battleRoleAdjust();
        return result;
    }
    
    /**
     * Shifts one point of stats to str  and adjust the player's role
     * @param attacker - the actor who's stats are to be adjusted
     */
    public void strShift(Actor attacker){
        
         if(statCheck(attacker.getBaseMag())){
            attacker.setStr(attacker.getStr()+1);
            attacker.setBaseStr(attacker.getBaseStr()+1);
            attacker.setMag(attacker.getMag()-1);
            attacker.setBaseMag(attacker.getBaseMag()-1);
            battleRoleAdjust();
            setTurnRatio();
         }
    }
    
    /**
     * Shifts one point of stats to mag  and adjust the player's role
     * @param attacker - the actor who's stats are to be adjusted
     */
    public void magShift(Actor attacker){
        if(statCheck(attacker.getBaseDex())){
            attacker.setMag(attacker.getMag()+1);
            attacker.setBaseMag(attacker.getBaseMag()+1);
            attacker.setDex(attacker.getDex()-1);
            attacker.setBaseDex(attacker.getBaseDex()-1);
            battleRoleAdjust();
            setTurnRatio();
        }
    }
 
    /**
     * Starts new round for the battel
     * @return - true if the player gets the first turn, otherwise returns false
     */
    
    public boolean startNewRound(){
        round++;
        nextOpp(this.hero.getLevel());
        return this.isPlayerFirst();
    }
    
    /**
     * At the start of the battle records the state of the player's stats
     */
    public void startNewBattle(){
 
        orgBaseStr = hero.getBaseStr();
        orgBaseDex = hero.getBaseDex();
        orgBaseMag = hero.getBaseMag(); 
    }
    /**
     * Resets player's stats to original state prior to entering the arena, 
     * sets player's hp to 0 if current hp is less than zero,
     * adjust player's role to to reflect stat state.
     */
    public void endBattle(){
        
        Arena.CUR_PLAYER.setBaseStr(orgBaseStr);
        Arena.CUR_PLAYER.setBaseMag(orgBaseMag);
        Arena.CUR_PLAYER.setBaseDex(orgBaseDex);
        Arena.CUR_PLAYER.setStr(orgBaseStr+this.hero.getAdditionalStr());
        Arena.CUR_PLAYER.setMag(orgBaseMag+this.hero.getAdditionalMag());
        Arena.CUR_PLAYER.setDex(orgBaseDex+this.hero.getAdditionalDex());
        if(this.hero.getCurHp()<1){
            Arena.CUR_PLAYER.setCurHp(1);
        }
    }   
}
    
