/*
 * Class to test the BalancedPhyiscalShift class
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
public class BalancedPhysicalShiftTest {
    
    private Battle battle;
    private Player player;
    private final int str = 19;
    private final int mag = 5;
    private final int dex = 5;
    private final int expectedHigh = 12;
    private final int expectedLow = 10;
    
    public BalancedPhysicalShiftTest() {
    }
    
    @Before
    public void init(){
        player = new Player("Test", "Any", 1, str, mag, dex);
        battle = new Battle(player);
    }
    
    @Test
    public void testGetCost() {
        BalancedPhysicalShift instance = new BalancedPhysicalShift();
        double expResult = Abilities.BALANCED_PHYSICAL_SHIFT.getCost();
        double result = instance.getCost();
        assertEquals("Testing getCost()", expResult, result, 0.0);
    }

    @Test
    public void testUseStrBattle() {
        BalancedPhysicalShift instance = new BalancedPhysicalShift();
        int expResult = expectedHigh;
        instance.use(battle);
        int result = battle.getHero().getStr();
        assertEquals("Testing player's Str after using balancd physical shift",expResult, result);
    }

    /**
     * Test of use method(battle), of class BalancedPhysicalShift.
     */
    @Test
    public void testUseMagBattle() {
        BalancedPhysicalShift instance = new BalancedPhysicalShift();
        int expResult = expectedLow;
        instance.use(battle);
        int result = battle.getHero().getMag();
        assertEquals("Testing player's Mag after using balancd physical shift", expResult, result);    
    }
    
    /**
     * Test of use method(battle), of class BalancedPhysicalShift.
     */
    @Test
    public void testUseDexBattle() {
        BalancedPhysicalShift instance = new BalancedPhysicalShift();
        int expResult = expectedLow;
        instance.use(battle);
        int result = battle.getHero().getDex();
        assertEquals("Testing player's Dex after using balancd physical shift", expResult, result);    
    }
    
    /**
     * Test of use method(battle), of class BalancedPhysicalShift.
     */
    @Test
    public void testBattleApConsumption() {
        BalancedPhysicalShift instance = new BalancedPhysicalShift();
        int ap = mag*10;
        int expResult = (int)(ap - ap*instance.getCost());
        instance.use(battle);
        int result = battle.getHero().getCurMp();
        assertEquals("Testing player's AP after using balancd Physical shift", expResult, result);    
    }
    
     /**
     * Test of use method(player), of class BalancedPhysicalShift.
     */
    @Test
    public void testUseStrPlayer() {
        BalancedPhysicalShift instance = new BalancedPhysicalShift();
        int expResult = expectedHigh;
        instance.use(player);
        int result = player.getStr();
        assertEquals("Testing player's Str after using balancd physical shift",expResult, result);
    }

    /**
     * Test of use method(player), of class BalancedPhysicalShift.
     */
    @Test
    public void testUseMagPlayer() {
        BalancedPhysicalShift instance = new BalancedPhysicalShift();
        int expResult = expectedLow;
        instance.use(player);
        int result = player.getMag();
        assertEquals("Testing player's Mag after using balancd physical shift", expResult, result);    
    }
    
    /**
     * Test of use method(player), of class BalancedPhysicalShift.
     */
    @Test
    public void testUseDexBattlePlayer() {
        BalancedPhysicalShift instance = new BalancedPhysicalShift();
        int expResult = expectedLow;
        instance.use(player);
        int result = player.getDex();
        assertEquals("Testing player's Dex after using balancd physical shift", expResult, result);    
    }

}
