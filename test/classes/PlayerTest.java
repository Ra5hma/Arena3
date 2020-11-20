/*
 * Test class for Player class
 */
package classes;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Shawn Ferdig
 */
public class PlayerTest {
    
    Player player;
    
    public PlayerTest() {
    }
    
    @Before
    public void init(){
        
        player = new Player("Test", "Any", 1, 3, 6, 3);

    }

    /**
     * Test of setAdditionalStr method, of class Player.
     */
    @Test
    public void testSetAdditionalStr() {
        
        int expResult = 1;
        player.setAdditionalStr();
        int result = player.getAdditionalStr();
        assertEquals("Testing str from equipment is being calculated correctly",
                expResult, result);
    }

    /**
     * Test of setAdditionMag method, of class Player.
     */
    @Test
    public void testSetAdditionMag() {
                
        int expResult = 1;
        player.setAdditionMag();
        int result = player.getAdditionalMag();
        assertEquals("Testing mag from equipment is being calculated correctly",
                expResult, result);
    }

    /**
     * Test of setAdditionalDex method, of class Player.
     */
    @Test
    public void testSetAdditionalDex() {
                
        int expResult = 1;
        player.setAdditionalDex();
        int result = player.getAdditionalDex();
        assertEquals("Testing dex from equipment is being calculated correctly",
                expResult, result);
    }

    /**
     * Test of yaBroke method, of class Player.
     */
    @Test
    public void testYaBroke() {
        
        boolean result = player.yaBroke(1000000);
        assertTrue("Testing gold is < cost", result);
    }

    /**
     * Test of yaDead method, of class Player.
     */
    @Test
    public void testYaDead() {  
                
        player.setCurHp(1);
        boolean result = player.yaDead();
        assertFalse("Testing if player's curHp is below 1", result);
    }

    /**
     * Test of yaNub method, of class Player.
     */
    @Test
    public void testYaNub() {
        
        boolean result = player.yaNub(1000000);
        assertTrue("Testing xpCredits is < cost", result);
    }

    /**
     * Test of yaDumz method, of class Player.
     */
    @Test
    public void testYaDumz() {
        
        boolean result = player.yaDumz(1000000);
        assertTrue("Testing player's curMp is < cost", result);
    }

    /**
     * Test of levelUp method, of class Player.
     */
    @Test
    public void testLevelUp() {
        
        player.setXp(30);
        player.setXpCredits(10);
        player.levelUp();
        int result = player.getXp();
        int creditsXp = player.getXpCredits();
        int plevel = player.getLevel();
        int resultTnl = player.getTnl();
        assertEquals("Testing xp after level up", 10, result);
        assertEquals("Testing xpCredits after level up", 30, creditsXp);
        assertEquals("Testing lvl after level up", 2, plevel);
        assertEquals("Testing tnl after level up", 42, resultTnl);   
    }

    /**
     * Test of roleAdjust method, of class Player.
     */
    @Test
    public void testRoleAdjust() {
        
        player.setDex(1000);
        player.roleAdjust();
        String expResult = "Ranger";
        String result = player.getRole();
        assertEquals("Testing role after role adjust", expResult, result );
    }
    
    /**
     * Test of applyEuimentStats, of class Player.
     */
    @Test
    public void testApplyEuipmentStats(){
        player.setBaseStr(0);
        player.setBaseMag(0);
        player.setBaseDex(0);
        player.applyEuipmentStats();
        int resultStr = player.getStr();
        int resultMag = player.getMag();
        int resultDex = player.getDex();
        assertEquals("Testing str after applying equipment stats", 1, resultStr);
        assertEquals("Testing mag after applying equipment stats", 1, resultMag);
        assertEquals("Testing Dex after applying equipment stats", 1, resultDex);   
    }
    
}
