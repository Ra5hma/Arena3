/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abilities;

import classes.Battle;
import classes.Mob;
import classes.Player;
import collections.Abilities;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author su104
 */
public class MagicMissileTest {
        private Battle battle;
        private Player player;
        private Mob mob;
        private final int str = 6;
        private final int mag = 9;
        private final int dex = 5;
        private final int xpVal = 1;
        private final int goldVal = 1;
        private final int level = 1;
        private final int mobMag = 1;
        
    public MagicMissileTest() {
        
    }
    @Before
    public void init(){
        mob = new Mob("Test", "Any", level, str, mobMag, dex , xpVal, goldVal);
        player = new Player("Test", "Any", level, str, mag, dex);
        battle = new Battle(player, mob);
        
    }


    /**
     * Test of use method, of class MagicMissile.
     */
    @Test
    public void testUse_Battle() {
        System.out.println("use");
        System.out.println("Str = "+battle.getHero().getBaseStr() );
        System.out.println("Int = "+battle.getHero().getBaseMag() );
        System.out.println("Dex = "+battle.getHero().getBaseDex() );
        int damage = battle.attack(mag, mobMag, level);
        System.out.println("The Damage is = " + damage);
        battle.displayDamage(mob, damage);
        Map<String, Integer> expResult = new HashMap<>(); 
        expResult.put("Magic Missile",damage);
        String expString = (String)expResult.keySet().toArray()[0];
        int expInt = expResult.get("Magic Missile");
        System.out.println(expInt);
        System.out.println(expString);
        MagicMissile instance = new MagicMissile();
        Map<String, Integer> result = instance.use(battle);
        String resultString = (String) result.keySet().toArray()[0];
        assertEquals(expString, resultString);    
     
    }
}
