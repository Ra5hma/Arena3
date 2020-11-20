/*
 * Test class for Inn class
 */
package classes;

import arena3.Arena;
import collections.Items;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Shawn Ferdig
 */
public class InnTest {
    Inn inn;
    public InnTest() {
    }
    
    @Before
    public void init(){        
        inn = new Inn(1);
    }
    /**
     * Test of getHealthPotionCost method, of class Inn.
     */
    @Test
    public void testGetHealthPotionCost() {
       assertEquals("testing get hp potion cost", 5, inn.getHealthPotionCost());
    }

    /**
     * Test of getAbilityPotionCost method, of class Inn.
     */
    @Test
    public void testGetAbilityPotionCost() {
        assertEquals("testing get ap potion cost", 5, inn.getAbilityPotionCost());
    }

    /**
     * Test of getComboPotionCost method, of class Inn.
     */
    @Test
    public void testGetComboPotionCost() {
        assertEquals("testing get combo potion cost", 11,
                inn.getComboPotionCost());
    }

    /**
     * Test of getRoomCost method, of class Inn.
     */
    @Test
    public void testGetRoomCost() {
        assertEquals("testing get room cost", 11, inn.getRoomCost());  
    }

    /**
     * Test of rentRoom method, of class Inn.
     */
    @Test
    public void testRentRoom() {
        
        Arena.CUR_PLAYER.setCurHp(5);
        Arena.CUR_PLAYER.setCurMp(1);
        Arena.CUR_PLAYER.setGold(15);
        boolean result = inn.rentRoom();
        boolean maxHp = Arena.CUR_PLAYER.getCurHp() == 
                Arena.CUR_PLAYER.getMaxHp();
        boolean maxMp = Arena.CUR_PLAYER.getCurMp() ==
                Arena.CUR_PLAYER.getMaxMp();
        int gold = Arena.CUR_PLAYER.getGold();
        assertTrue("Testing if player has enough gold to rent room", result);
        assertTrue("Testing if player's curHp match player's maxHp", maxHp);
        assertTrue("Testing if player's curMp match player's maxMp", maxMp);
        assertEquals("Testing if the currect amount of gold was deducted from"
                + "the player", 4, gold);
    }

    /**
     * Test of buyHealthPotion method, of class Inn.
     */
    @Test
    public void testBuyHealthPotion() {
        
        Arena.CUR_PLAYER.setGold(15);
        boolean result = inn.buyHealthPotion();
        int gold = Arena.CUR_PLAYER.getGold();
        int quantity = Arena.CUR_PLAYER.getItems().get(Items.HEALTH.getName())
                .getQuantity();
        assertTrue("Testing if player has enough gold buy a potion", result);
        assertEquals("Testing if the currect amount of gold was deducted from"
                + "the player", 10, gold);
        assertEquals("Testing if potion was added to the player's items", 1, 
                quantity);
    }

    /**
     * Test of buyAbilityPotion method, of class Inn.
     */
    @Test
    public void testBuyAbilityPotion() {
        
        Arena.CUR_PLAYER.setGold(15);
        boolean result = inn.buyAbilityPotion();
        int gold = Arena.CUR_PLAYER.getGold();
        int quantity = Arena.CUR_PLAYER.getItems().get(Items.ABILITY.getName())
                .getQuantity();
        assertTrue("Testing if player has enough gold buy a potion", result);
        assertEquals("Testing if the currect amount of gold was deducted from"
                + "the player", 10, gold);
        assertEquals("Testing if potion was added to the player's items", 1, 
                quantity);
    }

    /**
     * Test of buyComboPotion method, of class Inn.
     */
    @Test
    public void testBuyComboPotion() {
        
        Arena.CUR_PLAYER.setGold(15);
        boolean result = inn.buyComboPotion();
        int gold = Arena.CUR_PLAYER.getGold();
        int quantity = Arena.CUR_PLAYER.getItems().get(Items.COMBO.getName())
                .getQuantity();
        assertTrue("Testing if player has enough gold buy a potion", result);
        assertEquals("Testing if the currect amount of gold was deducted from"
                + "the player", 4, gold);
        assertEquals("Testing if potion was added to the player's items", 1, 
                quantity);
    }

    /**
     * Test of canAfford method, of class Inn.
     */
    @Test
    public void testCanAfford() {
        
        Arena.CUR_PLAYER.setGold(15);
        boolean result = inn.canAfford(20);
        assertFalse("testing of player's less than cost", result);
    }
    
}
