/*
 * This class makes a simple die object that can be used to randomize
 * outcomes with disired distributions.
 */
package utilities;

import java.util.Random;

/**
 * @author Shawn Ferdig
 * 4.3.2018
 */
public class Die {
     
   private static Random rand = new Random();
   private int value;
   private int sides = 6;
   
    /**
    * Creates a die with a value between 1-6
    */
    public Die(){
        this.roll();
    }
    
    /**
    * Creates a die with a value between 1 and the parameter value
    * If the side value is only changed is the supplied value is larger than one 
    * @param x is the value of the number of sides on the die object
    */
    public Die(int x){
        if(x > 1) sides = x;
        this.roll();
    }
   
    /**
    * Creates a die with a value for a specific integer and sets the 
    * number of sides, if the specified integer is not in the 
    * appropriate range sets the die value with a roll
    * @param v is the value of the die
    * @param w is the number of sides
    */
    public Die(int v, int w){
        sides = w;
        if ( v < 1 || v > sides ){
            this.roll();
      }
      else
         value = v;
   }
    
//Set Methods ==================================================================
    
    /**
    * Creates a random number between 1 and the side value simulating a die roll
    */
    public void roll(){
        value = rand.nextInt(sides)+1;
    }
    
    public void setSides(int x){
        sides = x;
        this.roll();
    }
    
//Get Methods ==================================================================
    
    /**
    * Gets the die value
    * @return the die value
    */
    public int getValue(){
        return value;
    }
    
    public int getSides() {
        return this.sides;
    }
    
//Utility Methods ==============================================================
   
    /**
    * Converts the Die to a string displaying it's value
    * @return a String describing the Die
    */
    @Override
    public String toString(){
        return "Die: " + value;
    }
    
    /**
    * Rolls the die the specified number of times and sums the result
    * @param x the number of times to die is to be rolled
    * @return the sum of the die rolls
    */
    public int multiRoll(int x){
        
        int sum = 0;
        for(int i = 0; i<x; i++){
            this.roll();
            sum = sum+this.getValue();
        }
        return sum;
    }
    
}
