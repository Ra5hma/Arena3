/*
 * Class to test the BalancedRangedShift class
 */
package abilities;

import classes.Battle;
import classes.Player;
import collections.Abilities;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Shawn Ferdig
 */
public class BalancedRangedShiftTest {
    
    private Battle battle;
    private Player player;
    private final int str = 19;
    private final int mag = 5;
    private final int dex = 5;
    private final int expectedHigh = 12;
    private final int expectedLow = 10;
    
    public BalancedRangedShiftTest() {
    }

    @Before
    public void init(){
        player = new Player("Test", "Any", 1, str, mag, dex);
        battle = new Battle(player);
    }
    
    /**
     * Test of the empty constructor, of class BalancedRangedShift.
     */
    @Test
    public void testDefaultConstructor() {
        BalancedRangedShift instance = new BalancedRangedShift();
        assertNotNull("Testing the default constructor",instance);
    }
    
    /**
     * Test of getName method, of class BalancedRangedShift.
     */
    @Test
    public void testGetName() {
        BalancedRangedShift instance = new BalancedRangedShift();
        String expResult = Abilities.BALANCED_RANGED_SHIFT.getName();
        String result = instance.getName();
        assertEquals("Testing getName()", expResult, result);
    }

    /**
     * Test of getCost method, of class BalancedRangedShift.
     */
    @Test
    public void testGetCost() {
        
        BalancedRangedShift instance = new BalancedRangedShift();
        double expResult = Abilities.BALANCED_RANGED_SHIFT.getCost();
        double result = instance.getCost();
        assertEquals("Testing getCost()", expResult, result, 0.0);
    }

    /**
     * Test of getType method, of class BalancedRangedShift.
     */
    @Test
    public void testGetType() {
        
        BalancedRangedShift instance = new BalancedRangedShift();
        String expResult = Abilities.BALANCED_RANGED_SHIFT.getType();
        String result = instance.getType();
        assertEquals("Testing getType()", expResult, result);
    }

    /**
     * Test of getSoundFile method, of class BalancedRangedShift.
     */
    @Test
    public void testGetSoundFiles() {
        int index = 0;
        BalancedRangedShift instance = new BalancedRangedShift();
        int expResult = 8;
        int result = instance.getSoundFile(index);
        assertEquals("Testing getSoundFiles()",expResult, result);
    }

    /**
     * Test of getSoundFilesNumber method, of class BalancedRangedShift.
     */
    @Test
    public void testGetSoundFilesNumber() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int expResult = 1;
        int result = instance.getSoundFilesNumber();
        assertEquals("Testing getSoundFilesNumber()", expResult, result);
    }

    /**
     * Test of getDesciption method, of class BalancedRangedShift.
     */
    @Test
    public void testGetDesciption() {
        BalancedRangedShift instance = new BalancedRangedShift();
        String expResult = Abilities.BALANCED_RANGED_SHIFT.getDescription();
        String result = instance.getDescription();
        assertEquals("Testing getDescription()", expResult, result);
    }
    
        /**
     * Test of getSoundFile method for index about of bounds, 
 of class BalancedRangedShift.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetSoundFilesException() {
        int index = 10;
        BalancedRangedShift instance = new BalancedRangedShift();
        instance.getSoundFile(index);
    }

            /**
     * Test of use method(battle), of class BalancedRangedShift.
     */
    @Test
    public void testUseStrBattle() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int expResult = expectedLow;
        instance.use(battle);
        int result = battle.getHero().getStr();
        assertEquals("Testing player's Str after using balancd ranged shift", expResult, result);
    }

    /**
     * Test of use method(battle), of class BalancedRangedShift.
     */
    @Test
    public void testUseMagBattle() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int expResult = expectedLow;
        instance.use(battle);
        int result = battle.getHero().getMag();
        assertEquals("Testing player's Mag after using balancd ranged shift", expResult, result);    
    }
    
    /**
     * Test of use method(battle), of class BalancedRangedShift.
     */
    @Test
    public void testUseDexBattle() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int expResult = expectedHigh;
        instance.use(battle);
        int result = battle.getHero().getDex();
        assertEquals("Testing player's Dex after using balancd ranged shift", expResult, result);    
    }
    
    /**
     * Test of use method(battle), of class BalancedRangedShift.
     */
    @Test
    public void testBattleApConsumption() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int ap = mag*10+10;
        int expResult = (int)(ap - ap*instance.getCost());
        instance.use(battle);
        int result = battle.getHero().getCurMp();
        assertEquals("Testing player's AP after using balancd ranged shift", expResult, result);    
    }
    
     /**
     * Test of use method(player), of class BalancedRangedShift.
     */
    @Test
    public void testUseStrPlayer() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int expResult = expectedLow;
        instance.use(player);
        int result = player.getStr();
        assertEquals("Testing player's Str after using balancd Ranged shift", expResult, result);
    }

    /**
     * Test of use method(player), of class BalancedRangedShift.
     */
    @Test
    public void testUseMagPlayer() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int expResult = expectedLow;
        instance.use(player);
        int result = player.getMag();
        assertEquals("Testing player's Mag after using balancd ranged shift", expResult, result);    
    }
    
    /**
     * Test of use method(player), of class BalancedRangedShift.
     */
    @Test
    public void testUseDexBattlePlayer() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int expResult = expectedHigh;
        instance.use(player);
        int result = player.getDex();
        assertEquals("Testing player's Dex after using balancd ranged shift", expResult, result);    
    }
    
    /**
     * Test of use method(player), of class BalancedPhysicalShift.
     */
    @Test
    public void testPlayerApConsumption() {
        BalancedRangedShift instance = new BalancedRangedShift();
        int ap = mag*10+10;
        int expResult = (int)(ap - ap*instance.getCost());
        instance.use(battle);
        int result = battle.getHero().getCurMp();
        assertEquals("Testing player's AP after using balancd ranged shift", expResult, result);    
    }
}
