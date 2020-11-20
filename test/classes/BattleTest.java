/*
 * Test Class for the battle class
 */
package classes;

import abilities.DoubleAttack;
import arena3.Arena;
import collections.Abilities;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 * @author Shawn Ferdig
 */
public class BattleTest {
    
    private Battle battle;
    private Player player;
    private final int str = 19;
    private final int mag = 5;
    private final int dex = 200;
    private final int gold = 100;
    private final int goldWagered = 100;
    private int mobXpValue;
    private int mobGoldValue;
    
    public BattleTest() {
    }

    @Before
    public void init(){
        
        player = new Player("Test", "Any", 1, str, mag, dex);
        battle = new Battle(player);
        player.setGold(gold);
        player.setGoldWagered(goldWagered, 1);
        mobXpValue = battle.getOpp().getXpValue();
        mobGoldValue = battle.getOpp().getGoldValue();
    }

    /**
     * Test of isPlayerFirst method, of class Battle.
     */
    @Test
    public void testIsPlayerFirst() { 
        assertTrue("Testing isplayerFirst()", battle.isPlayerFirst());
    }

    /**
     * Test of winBet method, of class Battle.
     */
    @Test
    public void testWinBet() {   
        assertTrue("Testing winBet()", battle.winBet());
    }

    /**
     * Test of payOut method, of class Battle.
     */
    @Test
    public void testPayOut() {
        
        player.setGold(100);
        player.setGoldWagered(100, 1);
        player.setRoundsWagered(100, 1);
        int epPayOut = (int)(((1-1)/4.0 +1)*100);
        int expGold = 200;
        int rePayOut = battle.payOut();
        int reGold = battle.getHero().getGold();   
        int gwResult = battle.getHero().getGoldWagered();
        int grResult = battle.getHero().getRoundsWagered();
        assertEquals("Testing payOut()", epPayOut, rePayOut);
        assertEquals("Testing gold", expGold, reGold);
        assertEquals("Testing gold wagered", 0, gwResult);
        assertEquals("Testing rounds wagered", 0, grResult);
    }

    /**
     * Test of phyAtt method, of class Battle.
     */
    @Test
    public void testPhyAtt() {
        
        battle.getHero().setStr(4);
        battle.getHero().setMag(3);
        battle.getHero().setDex(3);
        battle.getOpp().setDex(3);
        int damage = battle.phyAtt(battle.getHero(), battle.getOpp());
        boolean result = damage > 0 || damage < 11;
        String reRole = battle.getHero().getRole();
        int reTurn = battle.getTurnCount();
        double reTurnRatio = battle.getTurnRatio();
        int expMag = 2;
        int reMag = battle.getHero().getMag();
        int expStr = 5;
        int reStr = battle.getHero().getStr();
        assertTrue("Testing phyAttack()",  result);
        assertEquals("Testing role", "Knight", reRole);
        assertEquals("Testing turn count", 0, reTurn);
        assertEquals("Testing turn ratio", 1.0, reTurnRatio, 0.0);
        assertEquals("Testing Mag", expMag, reMag);
        assertEquals("Testing Str", expStr, reStr);
    }
    
    /**
     * Test of magAtt method, of class Battle.
     */
    @Test
    public void testMagAtt() {
        
        battle.getHero().setStr(3);
        battle.getHero().setMag(5);
        battle.getHero().setDex(4);
        battle.getOpp().setDex(3);
        int damage = battle.magAtt(battle.getHero(), battle.getOpp());
        boolean result = damage > 0 || damage < 11;
        String reRole = battle.getHero().getRole();
        int reTurn = battle.getTurnCount();
        double reTurnRatio = battle.getTurnRatio();
        int expMag = 6;
        int reMag = battle.getHero().getMag();
        int expDex = 3;
        int reDex = battle.getHero().getDex();
        assertTrue("Testing magAttack()",  result);
        assertEquals("Testing role", "Mage", reRole);
        assertEquals("Testing turn count", 0, reTurn);
        assertEquals("Testing turn ratio", 1.0, reTurnRatio, 0.0);
        assertEquals("Testing dex", expDex, reDex);
        assertEquals("Testing mag", expMag, reMag);
    }

    /**
     * Test of rngAtt method, of class Battle.
     */
    @Test
    public void testRngAtt() {
        
        battle.getHero().setStr(3);
        battle.getHero().setMag(3);
        battle.getHero().setDex(5);
        battle.getOpp().setDex(3);
        int damage = battle.rngAtt(battle.getHero(), battle.getOpp());
        boolean result = damage > 0 || damage < 11;
        String reRole = battle.getHero().getRole();
        int reTurn = battle.getTurnCount();
        double reTurnRatio = battle.getTurnRatio();
        int expDex = 6;
        int reDex = battle.getHero().getDex();
        int expStr = 2;
        int reStr = battle.getHero().getStr();
        assertTrue("Testing rngAttack()",  result);
        assertEquals("Testing role", "Ranger", reRole);
        assertEquals("Testing turn count", 0, reTurn);
        assertEquals("Testing turn ratio", 2, reTurnRatio, 0.0);
        assertEquals("Testing dex", expDex, reDex);
        assertEquals("Testing Str", expStr, reStr);
    }

    /**
     * Test of mobAttack method, of class Battle.
     */
    @Test
    public void testMobAttack() {
        
        String action = battle.mobAttack();
        boolean result;
        switch(action){
            case ("Speed Attack"):
                result = true;
                break;
            case ("skip"):
                result = true;
                break;
            case ("phyExtra"):
                result = true;
                break;
            case ("phy"):
                result = true;
                break;
            case ("rngExtra"):
                result = true;
                break;
            case ("magExtra"):
                result = true;
                break;
            case ("mag"):
                result = true;
                break;
            default:
                result = false;
                break;
        }    
    assertTrue("Testing action string", result);
    }

    /**
     * Test of attack method, of class Battle.
     */
    @Test
    public void testAttack() {
        
        int damage = battle.attack(str, mag, 1);
        boolean result = damage > 0 && damage < 11; 
        assertTrue("Test if damage is in the correct range",  result);
    }

    /**
     * Test of statCheck method, of class Battle.
     */
    @Test
    public void testStatCheck() {
        
        boolean result = battle.statCheck(2);
        assertTrue("Testing if 2 is not 1", result);
    }

    /**
     * Test of displayDamage method, of class Battle.
     */
    @Test
    public void testDisplayDamage() {
        
        int expResult = 0;
        battle.displayDamage(battle.getHero(), 10000);
        int result = battle.getHero().getCurHp();
        assertEquals("Testing curHp is 0 if damage is greather than curHp",
                expResult, result);
    }

    /**
     * Test of extraAtt method, of class Battle.
     */
    @Test
    public void testExtraAtt() {
        
        boolean result = battle.getExtraTurn();
        assertFalse("Testing if turncount is >= 11 - turnRation*10", result);
    }

    /**
     * Test of drops method, of class Battle.
     */
    @Test
    public void testDrops() {
        
        boolean levelUp = battle.drops();
        int expPlayerXp = mobXpValue;
        int expPlayerGold = gold + mobGoldValue;
        int playerXp = battle.getHero().getXp();
        int playerGold = battle.getHero().getGold();
        assertFalse("Testing playerXp > playerTnl", levelUp);
        assertEquals("Testing playerXp after drops()", expPlayerXp, playerXp);
        assertEquals("Testing playerGold after drops()", expPlayerGold, 
                playerGold);
    }

    /**
     * Test of nextOpp method, of class Battle.
     */
    @Test
    public void testNextOpp() {
        
        battle.nextOpp(1);
        double turnRatio = battle.getTurnRatio();
        int expTurnCount = 0;
        int turnCount = battle.getTurnCount();
        boolean expTurnRatio = turnRatio >= 0.0 && turnRatio <= dex+1;
        assertEquals("Testing turn count returns to 0", expTurnCount, turnCount);
        assertTrue("Testing new turn ration is between 0 and playerDex + 1 "
                + "inclusive", expTurnRatio);
    }

    /**
     * Test of useAbility method, of class Battle.
     */
    @Test
    public void testUseAbility() {
        
        battle.getHero().getAbilites().put("Double Attack", new DoubleAttack());
        DoubleAttack dblAttk = new DoubleAttack();
        battle.useAbility("Double Attack");
        Map<String, Integer> result = dblAttk.use(battle);
        String expRole = "Ranger";
        String reRole = battle.getHero().getRole();
        int expResult = result.get("Double Attack");
        boolean expXTurn = battle.getExtraTurn();
        assertEquals("Testing role", expRole, reRole);
        assertTrue("Testing extra turn", expXTurn);
        assertEquals("Testing int return from ability", 0, expResult);
        
    }

    /**
     * Test of strShift method, of class Battle.
     */
    @Test
    public void testStrShift() {
        
        battle.getHero().setStr(4);
        battle.getHero().setMag(3);
        battle.getHero().setDex(3);
        battle.getOpp().setDex(3);
        
        battle.strShift(battle.getHero());
        String reRole = battle.getHero().getRole();
        int reTurn = battle.getTurnCount();
        double reTurnRatio = battle.getTurnRatio();
        int expMag = 2;
        int reMag = battle.getHero().getMag();
        int expStr = 5;
        int reStr = battle.getHero().getStr();
        assertEquals("Testing role", "Knight", reRole);
        assertEquals("Testing turn count", 0, reTurn);
        assertEquals("Testing turn ratio", 1.0, reTurnRatio, 0.0);
        assertEquals("Testing Mag", expMag, reMag);
        assertEquals("Testing Str", expStr, reStr);

    }

    /**
     * Test of magShift method, of class Battle.
     */
    @Test
    public void testMagShift() {
        
        battle.getHero().setStr(3);
        battle.getHero().setMag(4);
        battle.getHero().setDex(3);
        battle.getOpp().setDex(2);
        battle.magShift(battle.getHero());
        String reRole = battle.getHero().getRole();
        int reTurn = battle.getTurnCount();
        double reTurnRatio = battle.getTurnRatio();
        int expMag = 5;
        int reMag = battle.getHero().getMag();
        int expDex = 2;
        int reDex = battle.getHero().getDex();
        assertEquals("Testing role", "Mage", reRole);
        assertEquals("Testing turn count", 0, reTurn);
        assertEquals("Testing turn ratio", 1.0, reTurnRatio, 0.0);
        assertEquals("Testing Mag", expMag, reMag);
        assertEquals("Testing Dex", expDex, reDex);
    }

    /**
     * Test of startNewRound method, of class Battle.
     */
    @Test
    public void testStartNewRound() {
        
        battle.startNewRound();
        int expRound = 1;
        int result = battle.getRound();
        this.testIsPlayerFirst();
        this.testNextOpp();
        assertEquals("Testing if round has been incremented", expRound, result);
    }

    /**
     * Test of endBattle method, of class Battle.
     */
    @Test
    public void testEndBattle() {
        
      battle.getHero().setCurHp(-5);
      battle.endBattle();
      int result = Arena.CUR_PLAYER.getCurHp();
      assertEquals("Tests if global player hp is set to 1 when the player has "
              + "less than 0", 1, result);
    }
    
    /**
     * Test of setTurnRatio method, of class Battle.
     */
    @Test
    public void testTurnRatio() {
        
      battle.getHero().setDex(1);
      battle.getOpp().setDex(4);
      battle.setTurnRatio();
      double result = battle.getTurnRatio();
      assertEquals("Tests the turn ratio", 0.25 , result, 0.0);
    }
    
}
