/*
 * This class manages the player's bets
 */
package classes;

import java.io.Serializable;

/**
 * @author Shawn Ferdig
 */
public class Bet implements Serializable{
    
    private boolean active = false;
    private int wager = 0;
    private int rounds = 0;
    private int payOut = 0;
    
    public Bet(){
    }
    
    /**
     * This constructor sets the attributes for the bet
     * If wager or rounds are invalid keeps the default values for the invalid
     * parameters, respectively
     * @param wager 
     * @param rounds 
     */
    public Bet (Integer wager, Integer rounds){
        if(wager > 1){
            this.wager = wager;
        }
        if(rounds > 1){
            this.rounds = rounds;
        }
        payOut = (int)(((this.rounds-1)/4.0 +1)*this.wager); 
   }
//Set Methods ==================================================================
    
    /**
     * Changes the active flag
     * @param isActive  
     */
    public void setActive(boolean isActive){
        this.active = isActive;
    }
    
    /**
     * Sets the wager and rounds, if rounds is less than one sets payout to zero 
     * @param wager the amount of gold wagered
     * @param rounds the number of rounds wagered
     */
    public void setWager(int wager, int rounds){
        
        this.wager = wager;
        if(rounds<1){
            payOut= 0;
        }
        else{
            payOut = (int)(((this.rounds-1)/4.0+1)*this.wager);
        }
    }
    
    /**
     * Sets the rounds, if the rounds is less the one sets payout
     * to zero
     * @param wager
     * @param rounds 
     */
    public void setRounds(int wager, int rounds){
        this.rounds = rounds;
        if(rounds<1){
            this.payOut= 0;
        }
        else{
            this.payOut = (int)(((this.rounds-1)/4.0+1)*this.wager);
        }
    }
    
//Get Methods ==================================================================

    public int getWager(){
        return wager;
    }
    
    public int getRounds(){
        return rounds;
    }
    
    public int getPayout(){
        return payOut;
    }


//Utilities Methods ============================================================ 
    
    /**
     * Returns the active flag
     * @return - active flag
     */
    public boolean isActive(){
        return this.active;
    }
}