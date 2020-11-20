/*
 * Test class for the Smith class
 */
package classes;

import arena3.Arena;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Shawn Ferdig
 */
public class SmithTest {
    
    Smith smith;
    
    public SmithTest() {
    }

    @Before
    public void init(){
        smith = new Smith();
    }

    /**
     * Test of setInventory method, of class Smith.
     */
    @Test
    public void testSetInventory() {
        int expResult = 4;
        smith.setInventory(4);
        int result = smith.getInventoryLevel();
        assertEquals("Testing if inventory level and player level is equal after"
                + "calling setInventory", expResult, result);
    }

    /**
     * Test of outdated method, of class Smith.
     */
    @Test
    public void testOutdated() {
        
        smith.setInventory(4);
        boolean result = smith.outdated(3);
        assertTrue("Testing if inventory level and player level not are equal",
                result);
    }

    /**
     * Test of canAfford method, of class Smith.
     */
    @Test
    public void testCanAfford() {
        Arena.CUR_PLAYER.setGold(0);
        smith.setInventory(1);
        assertFalse("Testing if player can afford the seleceted weapon",
                smith.canAfford(1));
    }

    /**
     * Test of purchase method, of class Smith.
     */
    @Test
    public void testPurchase() {
        
        Arena.CUR_PLAYER.setGold(100000);
        Arena.CUR_PLAYER.setStr(3);
        Arena.CUR_PLAYER.setMag(3);
        Arena.CUR_PLAYER.setDex(3);
        Arena.CUR_PLAYER.setBaseStr(3);
        Arena.CUR_PLAYER.setBaseMag(3);
        Arena.CUR_PLAYER.setBaseDex(3);
        smith.setInventory(2);
        boolean purchased = smith.purchase(2);
        int str = Arena.CUR_PLAYER.getStr();
        int mag = Arena.CUR_PLAYER.getMag();
        int dex = Arena.CUR_PLAYER.getDex();
        int totalStats = str + mag + dex;
        boolean statsApplied = totalStats == 12 || totalStats == 13;
        assertTrue("Testing if stats have been applied", statsApplied);
        assertTrue("Testing if player can afford purchase", purchased);
    }

    /**
     * Test of selectionType method, of class Smith.
     */
    @Test
    public void testSelectionType() {
        
        smith.setInventory(1);
        int tradeInValue = smith.selectionType(1);
        assertEquals("Testing trade in value of current weapon", 2, tradeInValue);
    }
    
}
