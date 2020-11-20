/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weapon;

import classes.Battle;
import classes.Mob;
import classes.Player;
import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import weapon.Weapon;
/**
 *
 * @author Scott Underwood
 */
public class WeaponImpTest {
        
    private Battle battle;
    private Player player;
    private Mob mob;
    private final int str = 19;
    private final int mag = 5;
    private final int dex = 5;
    private final int xpVal = 1;
    private final int goldVal = 1;
    private final int expectedHigh = 12;
    private final int expectedLow = 10;
    private final int mobStr = 1; 
    private final int level = 1;
    
    public WeaponImpTest() {
    }
    @Before
    public void init(){
        mob = new Mob("Test", "Any", level, str, mobStr, dex , xpVal, goldVal);
        player = new Player("Test", "Any", level, str, mag, dex);
        battle = new Battle(player, mob);

    }
   
    
    
    /**
     * Test of getStr method, of class WeaponImp.
     */
    @Test
    public void testGetStr() {
        System.out.println("Str = "+battle.getHero().getBaseStr() );
        System.out.println("Int = "+battle.getHero().getBaseMag() );
        System.out.println("Dex = "+battle.getHero().getBaseDex() );
        int base = battle.getHero().getBaseStr();
        System.out.println("The Str of the player is = " + base);
        player.getBaseStr();
        Map<String, Integer> expResult = new HashMap<>(); 
        expResult.put("Str",base);
        String expString = (String)expResult.keySet().toArray()[0];
        int expInt = base;
        System.out.println(expInt);
        System.out.println(expString);
    }

    /**
     * Test of getMag method, of class WeaponImp.
     */
    @Test
    public void testGetMag() {
        System.out.println("Str = "+battle.getHero().getBaseStr() );
        System.out.println("Int = "+battle.getHero().getBaseMag() );
        System.out.println("Dex = "+battle.getHero().getBaseDex() );
        int base = battle.getHero().getBaseStr();
        System.out.println("The Int of the player is = " + base);
        player.getBaseMag();
        Map<String, Integer> expResult = new HashMap<>(); 
        expResult.put("Mag",base);
        String expString = (String)expResult.keySet().toArray()[0];
        int expInt = base;
        System.out.println(expInt);
        System.out.println(expString);
    }

    /**
     * Test of getDex method, of class WeaponImp.
     */
    @Test
    public void testGetDex() {
        System.out.println("Str = "+battle.getHero().getBaseStr() );
        System.out.println("Int = "+battle.getHero().getBaseMag() );
        System.out.println("Dex = "+battle.getHero().getBaseDex() );
        int base = battle.getHero().getBaseStr();
        System.out.println("The Dex of the player is = " + base);
        player.getBaseMag();
        Map<String, Integer> expResult = new HashMap<>(); 
        expResult.put("Dex",base);
        String expString = (String)expResult.keySet().toArray()[0];
        int expInt = base;
        System.out.println(expInt);
        System.out.println(expString);
    }
    
}
