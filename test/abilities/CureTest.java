/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abilities;

import classes.Battle;
import classes.Mob;
import classes.Player;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Scott Underwood
 */
public class CureTest {
    private Battle battle;
    private Player player;
    private final int str = 6;
    private final int mag = 9;
    private final int dex = 5;
    private final int xpVal = 1;
    private final int goldVal = 1;
    private final int level = 1;
    private final int potency = 1;
       
    public CureTest() {
    }
    
    @Before
    public void init(){
        player = new Player("Test", "Any", level, str, mag, dex);
        battle = new Battle(player);
        
        
    }
    /**
     * Test of use method, of class Cure.
     */
    @Test
    public void testUse_Battle() {
        System.out.println("use while(combat)=true:");
        System.out.println("Str = "+battle.getHero().getBaseStr() );
        System.out.println("Int = "+battle.getHero().getBaseMag() );
        System.out.println("Dex = "+battle.getHero().getBaseDex() );
        int cure = battle.getHero().getCurMp();
        System.out.println("The AP is = " + cure);
        // battle.displayDamage();
        Map<String, Integer> expResult = new HashMap<>(); 
        expResult.put("Cure" ,cure);
        String expString = (String)expResult.keySet().toArray()[0];
        int expInt = expResult.get("Cure");
        System.out.println(expInt);
        System.out.println(expString);
        Cure instance = new Cure();
        Map<String, Integer> result = instance.use(battle);
        String resultString = (String) result.keySet().toArray()[0];
        assertEquals(expString, resultString);
        
    }

    /**
     * Test of use method, of class Cure.
     */
    @Test
    public void testUse_Player() {
        System.out.println("use while(combat)=false:");
        //System.out.println("Str = "+.getHero().getBaseStr() );
        //System.out.println("Int = "+battle.getHero().getBaseMag() );
        //System.out.println("Dex = "+battle.getHero().getBaseDex() );
        int heal = player.getMaxMp();
        System.out.println("The current AP = " + heal);
        //battle.displayDamage( damage);
        Map<String, Integer> expResult = new HashMap<>(); 
        expResult.put("Cure",heal);
        String expString = (String)expResult.keySet().toArray()[0];
        int expInt = expResult.get("Cure");
        System.out.println(expInt);
        System.out.println(expString);
        Cure instance = new Cure();
        Map<String, Integer> result = instance.use(battle);
        String resultString = (String) result.keySet().toArray()[0];
        assertEquals(expString, resultString);
    }
   
}
