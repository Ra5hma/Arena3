/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author doctr
 */
public class DieTest {
    
    public DieTest() {
    }

    /**
     * Test of roll method, of class Die.
     */
    @Test
    public void testRoll() {
        
        Die die = new Die(3, 9);
        die.roll();
        int value = die.getValue();
        boolean result = value >0 && value < 10;
        assertTrue("Testing value", result);
    }

    /**
     * Test of setSides method, of class Die.
     */
    @Test
    public void testSetSides() {
        
        Die die = new Die(3, 12);
        int result = die.getSides();
        assertEquals("Testing sides", 12, result);
    }

    /**
     * Test of toString method, of class Die.
     */
    @Test
    public void testToString() {
        Die die = new Die(2, 5);
        String expResult = "Die: " + 2;
        String result = die.toString();
        assertEquals("Testing to string", expResult, result);
    }

    /**
     * Test of multiRoll method, of class Die.
     */
    @Test
    public void testMultiRoll() {
        Die die = new Die(3, 6);
        int multRoll = die.multiRoll(3);
        boolean result = multRoll > 3 && multRoll <19;
        assertTrue("Testing mutliple rolls", result);
    }
    
}
