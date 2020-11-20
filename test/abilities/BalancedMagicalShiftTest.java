/*
 * Class to test the BalancedMagicalShift class
 */
package abilities;

import classes.Battle;
import classes.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import collections.Abilities;

/**
 * @author Shawn Ferdig
 */
public class BalancedMagicalShiftTest {
    
    private Battle battle;
    private Player player;
    private final int str = 19;
    private final int mag = 7;
    private final int dex = 5;
    private final int expectedHigh = 12;
    private final int expectedLow = 10;
    
    
    public BalancedMagicalShiftTest() {
    }
    
    @Before
    public void init(){
        player = new Player("Test", "Any", 1, str, mag, dex);
        battle = new Battle(player);
    }
    
   
    @Test
    public void testUseStrBattle() {
        BalancedMagicalShift instance = new BalancedMagicalShift();
        int expResult = expectedLow;
        instance.use(battle);
        int result = battle.getHero().getStr();
        assertEquals("Testing player's Str after using balancd magical shift", expResult, result);
        System.out.println("Testing Str after using shift : ="+result);
    }

    /**
     * Test of use method(battle), of class BalancedMagicalShift.
     */
    @Test
    public void testUseMagBattle() {
        BalancedMagicalShift instance = new BalancedMagicalShift();
        int expResult = expectedHigh;
        instance.use(battle);
        int result = battle.getHero().getMag();
        assertEquals("Testing player's Mag after using balancd magical shift", expResult, result);  
        System.out.println("Mag after use should be = "+expResult + " and is = " + result);
    }
    
    /**
     * Test of use method(battle), of class BalancedMagicalShift.
     */
    @Test
    public void testUseDexBattle() {
        BalancedMagicalShift instance = new BalancedMagicalShift();
        int expResult = expectedLow;
        instance.use(battle);
        int result = battle.getHero().getDex();
        assertEquals(expResult, result);    
        System.out.println("Dex after use should be = "+expResult + " and is = " + result);
    } 
    
    /**
     * Test of use method(player), of class BalancedMagicalShift.
     */
    @Test
    public void testUseStrPlayer() {
        BalancedMagicalShift instance = new BalancedMagicalShift();
        int expResult = 10;
        instance.use(player);
        int result = player.getStr();
        assertEquals("Testing player's Str after using balancd magical shift", expResult, result);
        System.out.println("Str after use should be = "+expResult + " and is = " + result);
    }

    /**
     * Test of use method(player), of class BalancedMagicalShift.
     */
    @Test
    public void testUseMagPlayer() {
        BalancedMagicalShift instance = new BalancedMagicalShift();
        int expResult = 12;
        instance.use(player);
        int result = player.getMag();
        assertEquals("Testing player's Mag after using balancd magical shift", expResult, result);    
        System.out.println("The highest attribute = "+result);
    }
    
    /**
     * Test of use method(player), of class BalancedMagicalShift.
     */
    @Test
    public void testUseDexBattlePlayer() {
        BalancedMagicalShift instance = new BalancedMagicalShift();
        int expResult = 10;
        instance.use(player);
        int result = player.getDex();
        assertEquals("Testing player's Dex after using balancd magical shift", expResult, result);    
        System.out.println("hi"+result);

    }    
}
