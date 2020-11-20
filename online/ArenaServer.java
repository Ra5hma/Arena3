/*
 * Arena3Server.java is a server aplication that is facilitates the networked
 * multiplayer componenet of the Arena III software.  It utilized thread pools
 * to allow many player pairs to interact simultianously. This class was 
 * modified from the orginal code found at 
 * http://cs.lmu.edu/~ray/notes/javanetexamples/.
 */
package online;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Utilizes a thread pool to allow many player pairs to interact simultianously
 * @author Shawn Ferdig
 */
public class ArenaServer {
   private final static int  DEST_PORT = 5938;                                  

    public static void main(String[] args) {
        try{
            ServerSocket svrSocket = new ServerSocket(DEST_PORT);               //server socket(just listens)
            System.out.println("The server has started.");                      //acknowleges the sever is listening to the port                     
            ExecutorService pool = Executors.newFixedThreadPool(2);             //creates a pool of excutable threads, the integer represent total availible threads in the pool     
            while (true) {                                                      //starts infinite loop    
                MultiBattle fight = new MultiBattle();                          //Ceates a new Battle object
                pool.execute(fight.new Player(svrSocket.accept(), 1));          //directs the first thread to create a new player object within the battle object
                System.out.println("Player 1 has connected");                   //acknowledges the first player has entered the battle
                pool.execute(fight.new Player(svrSocket.accept(),2));           //directs the second thread to create a new player object within the battle object
                System.out.println("Player 2 has connected");                   //acknowledges the second player has entered the battle
            }		
        }
	catch (Exception e){
            e.printStackTrace();
	}
    }
}
