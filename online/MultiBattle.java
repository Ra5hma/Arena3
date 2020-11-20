/*
 * Battle.java communicates with the Arena III client application to facilites
 * a match between 2 users. This class was modified from the orginal code found 
 * at http://cs.lmu.edu/~ray/notes/javanetexamples/.
 */
package online;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import utilities.Die;

/**
 * The Battle class is the match, and contains the player object.
 * @author Shawn Ferdig
 */
public class MultiBattle{
    

    //private final int playerNumber;
    public MultiBattle (){};
        private Player curPlayer;                                               //the current user 
  
    /**
     * the Player class represents the users 
     * @author Shawn Ferdig
     */
    public class Player implements Runnable{
        
        private final int playerNumber;                                         //the number assigned to the thread when the user logs into the server
        private final Socket addy;                                              //the player's socket address
        private Scanner in;                                                     //scanner for input from the user
        private PrintWriter outy;                                               //writer for output to the user
        private String name;                                                    //the player's name
        private String role;
        private int lvl;                                                        //player's level
        private int maxHp;                                                      //player's maximum hit points
        private int hp;                                                         //player's current hit points
        private int maxMp;                                                      //player's maximum magic points
        private int mp;                                                         //player's current magic points
        private int speed;                                                      //player's speed
        private int str;                                                        //player's physical stat value
        private int mag;                                                        //player's magical stat value
        private int dex;                                                        //player's ranged stat value
        private Player opponent;                                                //the current player's oppoenent
        private final Die d6 = new Die(6);                                      //die object used for calulating damage
        
        /**
         * Creates a player object for the user 
         * @author Shawn Ferdig
         * @param x The user's socket address
         * @param y The player number assigned to the thread
        */
        public Player(Socket x, int y){
                 addy = x;                                                      //assigns Socket address
                 playerNumber = y;                                              //assignms the player number
        }

        @Override
        public void run() {
            try {
                setup();
                System.out.println("Player "+name+" battle set up complete");
                processRequest();
                System.out.println("send quit message");
            } 
            
            catch (Exception e) {e.printStackTrace();} 
            
            finally {
        
                if (opponent != null && opponent.outy != null) {
                    System.out.println("send quit message");
                    outy.println("dc");
                    //outy.println("qt");  
                }
                
                try {addy.close();} 
                
                catch (IOException e) { e.printStackTrace();}
            }
        }
        /**
         * Populates player attributes from the client
         * @author Shawn Ferdig
         * @param x The user's socket address
         * @param y The player number assigned to the thread
        */
        private void setup() throws IOException, InterruptedException {
            
            in = new Scanner(addy.getInputStream());
            in.useDelimiter(":");
            outy = new PrintWriter(addy.getOutputStream(), true);
            name = in.next();
            role = in.next();
            lvl = in.nextInt();
            hp = in.nextInt();
            maxHp = in.nextInt();
            str = in.nextInt();
            mag = in.nextInt();
            dex = in.nextInt();
            
            if(playerNumber == 1){curPlayer = this;} 
            
            else{
                opponent = curPlayer;
                opponent.opponent = this;
                //opponent.name = "time is it?";
                //opponent.opponent.name = "what?";
                //send opponent attributes to the client(s)
                outy.println("oce:"+opponent.name+":"+opponent.role+":"
                    +opponent.lvl+":"+opponent.hp+":"+opponent.maxHp+":"
                    +opponent.str+":"+opponent.mag+":"+opponent.dex+":");
                //System.out.println(playerNumber+ " "+opponent.playerNumber);
                opponent.outy.println("oce:"+opponent.opponent.name+":"
                    +opponent.opponent.role+":"+opponent.opponent.lvl+":"
                    +opponent.opponent.hp+":"+opponent.opponent.maxHp+":"
                    +opponent.opponent.str+":"+opponent.opponent.mag+":"
                    +opponent.opponent.dex+":");
                opponent.outy.println("stt:");
            }
        }
        
        /**
         * listens for, parses, and responds to request from the clients
        */
        public void processRequest(){

            while(in.hasNextLine()){
                
                //System.out.println("Processing commmands");
                String request = in.nextLine();  
                switch(request){
                    case "qut":
                        System.out.println(curPlayer.name+" qut was recieved");
                        opponent.outy.println("oqt");
                        return;
                    case "pha": 
                        System.out.println(curPlayer.name+" pha was recieved");
                        attackTurn(str,opponent.str,lvl);
                        if(statCheck(mag)){
                            str = str +1;
                            mag = mag -1;
                        }
                        sendTurnInfo();
                        break;
                    case "mga":
                        System.out.println(curPlayer.name+" mga was recieved");
                        attackTurn(mag,opponent.mag,lvl);
                        if(statCheck(dex)){
                            mag = mag +1;
                            dex = dex -1;
                        }
                        sendTurnInfo();
                        break;
                    case "rga":
                        System.out.println(curPlayer.name+" rga was recieved");
                        attackTurn(dex,opponent.dex,lvl);
                        if(statCheck(str)){
                            dex = dex +1;
                            str = str -1;
                        }
                        sendTurnInfo();
                        break;       
                }         
            }
        }
        /**
         * Calculates the opponents hit points after an attack
         * @param x the offensive stat value
         * @param y the defensive stat value
         * @param z the attacker's level
        */
        public void attackTurn(int x, int y, int z){
            
            int damage = attack(x,y,z);
            System.out.println(opponent.opponent.name+"attack "+damage);
            opponent.hp = opponent.hp - damage; 
            curPlayer = opponent;
            opponent.opponent = this;
        }
        
        /**
         * sends the appropriate player info to the appropriate player
        */
        public void sendTurnInfo(){
            
            if(isDead()){
                opponent.outy.println("dhp:"+opponent.hp+":"
                        +opponent.opponent.str+":"+opponent.opponent.mag+":"
                        +opponent.opponent.dex+":");
                System.out.println(opponent.name+" was sent dhp");
                opponent.opponent.outy.println("vhs:"+opponent.hp+":"
                        +opponent.opponent.str+":"+opponent.opponent.mag+":"
                        +opponent.opponent.dex+":");
                System.out.println(opponent.opponent.name+" was sent vhs");
                
            }
            else{
                opponent.outy.println("uhp:"+opponent.hp+":"
                        +opponent.opponent.str+":"+opponent.opponent.mag+":"
                        +opponent.opponent.dex+":");
                System.out.println(opponent.name+" was sent uhp");
                opponent.opponent.outy.println("uhs:"+opponent.hp+":"
                        +opponent.opponent.str+":"+opponent.opponent.mag+":"
                        +opponent.opponent.dex+":");
                System.out.println(opponent.opponent.name+" was sent uhs");
            }
        }
        
        /**
         * Checks if the opponent's HP is less than 0
         * @return true if the opponent's HP is less than 0 false if it is not
        */
        public boolean isDead(){
            return opponent.hp <= 0;                                             
        }
        
        
        /**
         * Calculates the attack value
         * @param x the offensive stat value
         * @param y the defensive stat value
         * @param z the attacker's level
         * @return attack is the attack value
        */
        public int attack(int x, int y, int z){

           int sum=d6.multiRoll(2);
           double ratio = x/(double)y;
           int rangeFloor = z;
           int rangeCeiling = z + 9;
           int rangeDistance;
           int attackAdd;
           int attack;
           
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
           //System.out.println(rangeFloor+" to "+rangeCeiling);
           
           if(rangeCeiling - rangeFloor == 0)
              rangeDistance = 1;
           else
              rangeDistance = rangeCeiling - rangeFloor;
           
           //System.out.println("Range Disntance "+rangeDistance);
           attackAdd = (int)(rangeDistance/12.0*sum);
           //System.out.println("Attack Adder "+attackAdd);
           attack = attackAdd + rangeFloor; 
           //System.out.println(attack);
           return attack;
        }
        
        /**
         * Checks to see if the passed stat value is 1
         * @param y stat value to be checked
         * @return true if the value is one, false if it is not.
        */
        public boolean statCheck(int y){
            return y != 1;
      }
    }
}