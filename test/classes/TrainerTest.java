/*
 * Test class for Trainer Class
 */
package classes;

import abilities.*;
import arena3.Arena;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Shawn Ferdig
 */
public class TrainerTest {
    
    Trainer trainer;
    
    public TrainerTest() {
    }
    
    @Before
    public void init(){
        
      Arena.CUR_PLAYER.getAbilites().clear();
      Arena.CUR_PLAYER.setXpCredits(35);
      Arena.CUR_PLAYER.setBaseStr(3);
      Arena.CUR_PLAYER.setBaseMag(3);
      Arena.CUR_PLAYER.setBaseDex(3);
      Arena.CUR_PLAYER.setStr(3);
      Arena.CUR_PLAYER.setMag(3);
      Arena.CUR_PLAYER.setDex(3);
      Arena.CUR_PLAYER.setMaxHp(80);
      Arena.CUR_PLAYER.setCurHp(80);
      Arena.CUR_PLAYER.setSpeed(30);
      Arena.CUR_PLAYER.setMaxMp(30);
      Arena.CUR_PLAYER.setCurMp(30);  
      trainer = new Trainer();
    }
   
    /**
     * Test of setWarAbilityList method, of class Trainer.
     */
    @Test
    public void testSetWarAbilityList() {
        
        Arena.CUR_PLAYER.getAbilites().put("Balanced Str Shift", 
                new BalancedPhysicalShift());
        Arena.CUR_PLAYER.getAbilites().put("Critical Attack", 
                new CriticalAttack());
        trainer.setWarAbilityList(Arena.CUR_PLAYER.getAbilites());
        String expResult = "Rugged Shift";
        String result = trainer.getWarAbilitiesList().get(0).getName();
        assertEquals("Testing war trainer ability list population", 
                expResult, result);
    }

    /**
     * Test of setMagAbilityList method, of class Trainer.
     */
    @Test
    public void testSetMagAbilityList() {

        Arena.CUR_PLAYER.getAbilites().put("Balanced Mag Shift", 
                new BalancedMagicalShift());
        Arena.CUR_PLAYER.getAbilites().put("Magic Missile", 
                new MagicMissile());
        Arena.CUR_PLAYER.getAbilites().put("Void Shift", 
                new MagicalShift());
        trainer.setMagAbilityList(Arena.CUR_PLAYER.getAbilites());
        String expResult = "Cure";
        String result = trainer.getMagAbilitiesList().get(0).getName();
        assertEquals("Testing mag trainer ability list population",
                expResult, result);
    }

    /**
     * Test of setRngAbilityList method, of class Trainer.
     */
    @Test
    public void testSetRngAbilityList() {
        
        Arena.CUR_PLAYER.getAbilites().put("Balanced Rng Shift", 
                new BalancedRangedShift());
        Arena.CUR_PLAYER.getAbilites().put("Double Attack", 
                new DoubleAttack());
        trainer.setRngAbilityList(Arena.CUR_PLAYER.getAbilites());
        String expResult = "Swift Shift";
        String result = trainer.getRngAbilitiesList().get(0).getName();
        assertEquals("Testing Rng trainer ability list population", 
                expResult, result);
    }


    /**
     * Test of buyWarAbility method, of class Trainer.
     */
    @Test
    public void testBuyWarAbility() {

        trainer.setWarAbilityList(Arena.CUR_PLAYER.getAbilites());
        trainer.buyWarAbility(0);
        boolean playerAbility = Arena.CUR_PLAYER.getAbilites()
                .containsKey("Rugged Shift");
        boolean trainerAbility = trainer.getWarAbilitiesList()
                .contains(Arena.CUR_PLAYER.getAbilites().get("Rugged Shift"));
        int creditResult = Arena.CUR_PLAYER.getXpCredits(); 
        assertTrue("Testing if abilily was added to player's abilities", 
                playerAbility);
        assertFalse("Testing if the ability was removed from the trianer's"
                + "abilities", trainerAbility);
        assertEquals("Testing cost deduction from player xpCredit", 35, 
                creditResult);   
    }

    /**
     * Test of buyMagAbility method, of class Trainer.
     */
    @Test
    public void testBuyMagAbility() {
        
        trainer.setMagAbilityList(Arena.CUR_PLAYER.getAbilites());
        trainer.buyMagAbility(0);
        boolean playerAbility = Arena.CUR_PLAYER.getAbilites()
                .containsKey("Void Shift");
        boolean trainerAbility = trainer.getMagAbilitiesList()
                .contains(Arena.CUR_PLAYER.getAbilites().get("Void Shift"));
        int creditResult = Arena.CUR_PLAYER.getXpCredits();
        assertTrue("Testing if abilily was added to player's abilities", 
                playerAbility);
        assertFalse("Testing if the ability was removed from the trianer's"
                + "abilities", trainerAbility);
        assertEquals("Testing cost deduction from player xpCredit", 35, 
                creditResult); 
    }

    /**
     * Test of buyDexAbility method, of class Trainer.
     */
    @Test
    public void testBuyDexAbility() {
        
        trainer.setRngAbilityList(Arena.CUR_PLAYER.getAbilites());
        trainer.buyDexAbility(0);
        boolean playerAbility = Arena.CUR_PLAYER.getAbilites()
                .containsKey("Swift Shift");
        boolean trainerAbility = trainer.getRngAbilitiesList()
                .contains(Arena.CUR_PLAYER.getAbilites().get("Swift Shift"));
        int creditResult = Arena.CUR_PLAYER.getXpCredits();
        assertTrue("Testing if abilily was added to player's abilities", 
                playerAbility);
        assertFalse("Testing if the ability was removed from the trianer's"
                + "abilities", trainerAbility);
        assertEquals("Testing cost deduction from player xpCredit", 35, 
                creditResult); 
    }

    /**
     * Test of canAfford method, of class Trainer.
     */
    @Test
    public void testCanAfford() {
        boolean afford = trainer.canAfford();
        assertTrue("Testing player's xpCredits is less than cost", afford);    
    }

    /**
     * Test of trainStr method, of class Trainer.
     */
    @Test
    public void testTrainStr() {
        
        int expBaseStr = 4;
        int expStr = 4;
        int expMxHp = 90;
        int expCurHp = 90;
        int expXpCredits = 35;
        trainer.trainStr();
        int reBaseStr = Arena.CUR_PLAYER.getBaseStr();
        int reStr = Arena.CUR_PLAYER.getStr();
        int reMxHp = Arena.CUR_PLAYER.getMaxHp();
        int reCurHp = Arena.CUR_PLAYER.getCurHp();
        int reXpCredits = Arena.CUR_PLAYER.getXpCredits();
        assertEquals("Testing baseStr", expBaseStr, reBaseStr);
        assertEquals("Testing Str", expStr, reStr);
        assertEquals("Testing max hp", expMxHp, reMxHp);
        assertEquals("Testing cur hp", expCurHp, reCurHp);
        assertEquals("Testing xp credits", expXpCredits, reXpCredits);  
    }

    /**
     * Test of trainMag method, of class Trainer.
     */
    @Test
    public void testTrainMag() {
        
        int expBaseMag = 4;
        int expMag = 4;
        int expMxMp = 40;
        int expCurMp = 40;
        int expXpCredits = 35;
        trainer.trainMag();
        int reBaseMag = Arena.CUR_PLAYER.getBaseMag();
        int reMag = Arena.CUR_PLAYER.getMag();
        int reMxMp = Arena.CUR_PLAYER.getMaxMp();
        int reCurMp = Arena.CUR_PLAYER.getCurMp();
        int reXpCredits = Arena.CUR_PLAYER.getXpCredits();
        assertEquals("Testing baseMag", expBaseMag, reBaseMag);
        assertEquals("Testing Mag", expMag, reMag);
        assertEquals("Testing max mp", expMxMp, reMxMp);
        assertEquals("Testing cur mp", expCurMp, reCurMp);
        assertEquals("Testing xp credits", expXpCredits, reXpCredits);
    }

    /**
     * Test of trainDex method, of class Trainer.
     */
    @Test
    public void testTrainDex() {
        
        int expBaseDex = 4;
        int expDex = 4;
        int expSpeed = 40;
        int expXpCredits = 35;
        trainer.trainDex();
        int reBaseDex = Arena.CUR_PLAYER.getBaseDex();
        int reDex = Arena.CUR_PLAYER.getDex();
        int reSpeed = Arena.CUR_PLAYER.getSpeed();
        int reXpCredits = Arena.CUR_PLAYER.getXpCredits();
        assertEquals("Testing baseDex", expBaseDex, reBaseDex);
        assertEquals("Testing Dex", expDex, reDex);
        assertEquals("Testing Speed", expSpeed, reSpeed);
        assertEquals("Testing xp credits", expXpCredits, reXpCredits);
    }
    
    /**
     * Test of setCost method, of class Trainer.
     */
    @Test
    public void testSetCost() {
        Arena.CUR_PLAYER.setBaseStr(5);
        int expResult = 40;
        trainer.setCost();
        int result = trainer.getCost();
        assertEquals("Testing cost", expResult, result);
    }
}
