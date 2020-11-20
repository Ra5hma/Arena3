/*
 * Test Class for Bet Class
 */
package classes;



import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Shawn Ferdig
 */

public class BetTest {

       @Test
	public void negativeWager(){
		Bet bet = new Bet(-56,1);
		assertEquals("Testing negative wager",0, bet.getWager());
	}
        
       @Test
	public void zeroWager(){
		Bet bet = new Bet(0,1);
		assertEquals("Testing zero wager",0, bet.getWager());
	}
       
        @Test
	public void negativeRounds(){
		Bet bet = new Bet(5,-1);
		assertEquals("Testing negative rounds" , 0, bet.getRounds());
	}
        
        @Test
	public void zeroRounds(){
		Bet bet = new Bet(20000,0);
		assertEquals("Testing zero rounds",0, bet.getRounds());
	}
        @Test
	public void positveParameters(){
		Bet bet = new Bet(500,6);
		assertEquals(1125, bet.getPayout());
	}
       
        @Test
	public void wager(){
		Bet bet = new Bet(500, 7);
		assertEquals(500, bet.getWager());
	}
        
}
