/*
 * Class to test the MagicalShift class
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
public class MagicalShiftTest {
    
    private Battle battle;
    private Player player;
    private final int str = 19;
    private final int mag = 5;
    private final int dex = 5;
    private final int expectedHigh = 28;
    private final int expectedLow = 2;
    
    public MagicalShiftTest() {
    }

    @Before
    public void init(){
        
        player = new Player("Test", "Any", 1, str, mag, dex);
        battle = new Battle(player);
    }
    
    /**
     * Test of the empty constructor, of class MagicalShift
     */
    @Test
    public void testDefaultConstructor() {
        
        MagicalShift instance = new MagicalShift();
        assertNotNull("Testing the default constructor",instance);
    }
    /**
     * Test of getName method, of class MagicalShift.
     */
    @Test
    public void testGetName() {
        MagicalShift instance = new MagicalShift();
        String expResult = Abilities.MAGICAL_SHIFT.getName();
        String result = instance.getName();
        assertEquals("Testing getName()", expResult, result);
    }

    /**
     * Test of getCost method, of class MagicalShift.
     */
    @Test
    public void testGetCost() {
        MagicalShift instance = new MagicalShift();
        double expResult = Abilities.MAGICAL_SHIFT.getCost();
        double result = instance.getCost();
        assertEquals("Testing getCost()", expResult, result, 0.0);
    }

    /**
     * Test of getType method, of class MagicalShift.
     */
    @Test
    public void testGetType() {
        MagicalShift instance = new MagicalShift();
        String expResult = Abilities.MAGICAL_SHIFT.getType();
        String result = instance.getType();
        assertEquals("Testing getType()", expResult, result);
    }
    
    /**
     * Test of getDesciption method, of class MagicalShift.
     */
    @Test
    public void testGetDesciption() {
        MagicalShift instance = new MagicalShift();
        String expResult = Abilities.MAGICAL_SHIFT.getDescription();
        String result = instance.getDescription();
        assertEquals("Testing getdescription()", expResult, result);
    }
    
    /**
     * Test of getSoundFile method for index about of bounds, 
 of class MagicalShift.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetSoundFilesException() {
        int index = 1;
        MagicalShift instance = new MagicalShift();
        instance.getSoundFile(index);
    }
    
    /**
     * Test of getSoundFile method, of class MagicalShift.
     */
    @Test
    public void testGetSoundFiles() {
        int index = 0;
        MagicalShift instance = new MagicalShift();
        int expResult = 8;
        int result = instance.getSoundFile(index);
        assertEquals("Testing getSoundFiles()", expResult, result);
    }

    /**
     * Test of getSoundFilesNumber method, of class MagicalShift.
     */
    @Test
    public void testGetSoundFilesNumber() {
        MagicalShift instance = new MagicalShift();
        int expResult = 1;
        int result = instance.getSoundFilesNumber();
        assertEquals("Tessting getSoundFiles()", expResult, result);
    }
    
    /**
     * Test of use method(battle), of class MagicalShift.
     */
    @Test
    public void testUseBattleStr() {
        MagicalShift instance = new MagicalShift();
        instance.use(battle);
        int expResult = 2;
        int result = battle.getHero().getStr();
        assertEquals("Testing player's Str after using magical shift", expResult, result);
    }
    
    /**
     * Test of use method(battle), of class MagicalShift.
     */
    @Test
    public void testUseBattleMag() {
        MagicalShift instance = new MagicalShift();
        instance.use(battle);
        int expResult = 28;
        int result = battle.getHero().getMag();
        assertEquals("Testing player's Str after using magical shift", expResult, result);
    }
    
    /**
     * Test of use method(battle), of class MagicalShift.
     */
    @Test
    public void testUseBattleDex() {
        MagicalShift instance = new MagicalShift();
        instance.use(battle);
        int expResult = 2;
        int result = battle.getHero().getDex();
        assertEquals("Testing player's Dex after using magical shift", expResult, result);
    }

    /**
     * Test of use method(player), of class MagicalShift.
     */
    @Test
    public void testUsePlayerStr() {
        MagicalShift instance = new MagicalShift();
        instance.use(battle);
        int expResult = 2;
        int result = battle.getHero().getStr();
        assertEquals("Testing player's Str after using magical shift", expResult, result);
    }
    
    /**
     * Test of use method(player), of class MagicalShift.
     */
    @Test
    public void testUsePlayerMag() {
        MagicalShift instance = new MagicalShift();
        instance.use(battle);
        int expResult = 28;
        int result = battle.getHero().getMag();
        assertEquals("Testing player's Mag after using magical shift", expResult, result);
    }
    
    /**
     * Test of use method(player), of class MagicalShift.
     */
    @Test
    public void testUsePlayerDex() {
        MagicalShift instance = new MagicalShift();
        instance.use(battle);
        int expResult = 2;
        int result = battle.getHero().getDex();
        assertEquals("Testing player's Dex after using magical shift", expResult, result);
    }




    
}
