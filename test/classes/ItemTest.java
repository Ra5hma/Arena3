/*
 * Class to test the Items class
 */
package classes;

import collections.Items;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Shawn Ferdig
 */
public class ItemTest {
    
    Item instance = new Item(Items.COMBO);
    int testQuantity = 50;
    
    public ItemTest() {
    }

    /**
     * Test of setQuantity method, of class Item.
     */
    @Test
    public void testSetQuantity() {
        
        instance.setQuantity(testQuantity);
        int expResult = testQuantity;
        int result = instance.getQuantity();
        assertEquals("Testing setQuantity()", expResult, result);
    }

    /**
     * Test of getName method, of class Item.
     */
    @Test
    public void testGetName() {
        String expResult = Items.COMBO.getName();
        String result = instance.getName();
        assertEquals("Testing getName()", expResult, result);

    }

    /**
     * Test of getSoundFile method, of class Item.
     */
    @Test
    public void testGetSoundFile() {
        int index = 1;
        int expResult = 6;
        int result = instance.getSoundFile(index);
        assertEquals("Test getsoundFile()", expResult, result);
    }

    /**
     * Test of getSoundFileNumber method, of class Item.
     */
    @Test
    public void testGetSoundFileNumber() {
        int expResult = 2;
        int result = instance.getSoundFileNumber();
        assertEquals("Testing getSoundFileNumber()", expResult, result);
    }

    /**
     * Test of getHp method, of class Item.
     */
    @Test
    public void testGetHp() {

        double expResult = Items.COMBO.getHp();
        double result = instance.getHp();
        assertEquals("Testing getHp()", expResult, result, 0.0);
    }

    /**
     * Test of getMp method, of class Item.
     */
    @Test
    public void testGetMp() {

        double expResult = Items.COMBO.getMp();
        double result = instance.getMp();
        assertEquals("Testing getMp()", expResult, result, 0.0);
    }

    /**
     * Test of getValue method, of class Item.
     */
    @Test
    public void testGetValue() {

        int expResult = Items.COMBO.getValue();
        int result = instance.getValue();
        assertEquals("Testing getValue()", expResult, result);
    }

    /**
     * Test of use method, of class Item.
     */
    @Test
    public void testUse() {
        
        Player player = new Player();
        instance.setQuantity(100);   
        player.setMaxHp(100);
        player.setCurHp(100);
        player.setMaxMp(40);
        player.setCurMp(48);
        Map<String, Integer> expResult = new HashMap<>();
        expResult.put("hp", 0);
        expResult.put("ap", 0);
        Map<String, Integer> result = instance.use(player);
        int resultQuantity = instance.getQuantity();
        assertEquals("Testing use()", expResult, result);
        assertEquals("Testing quantity", 99, resultQuantity);
    }
    
    /**
     * Test of getQuantity method, of class Item.
     */
    @Test
    public void testGetQuantity() {
        instance.setQuantity(10);
        int expResult = 10;
        int result = instance.getQuantity();
        assertEquals("Testing getQuantity", expResult, result);
    }
}
