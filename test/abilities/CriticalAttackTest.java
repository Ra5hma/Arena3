/*
 * Class to test the CriticalAttack class
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
 * @author Scott Underwood
 */
public class CriticalAttackTest {
    
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
    
    public CriticalAttackTest() {
    }

    @Before
    public void init(){
        mob = new Mob("Test", "Any", level, str, mobStr, dex , xpVal, goldVal);
        player = new Player("Test", "Any", level, str, mag, dex);
        battle = new Battle(player, mob);
    }
    
    @Test
    public void testUseBattleStr() {

        System.out.println("use");
        System.out.println("Str = "+battle.getHero().getBaseStr() );
        System.out.println("Int = "+battle.getHero().getBaseMag() );
        System.out.println("Dex = "+battle.getHero().getBaseDex() );
        int cost = battle.getHero().getCurMp();
        System.out.println("The base is = " + cost);
        player.getCurMp();
        Map<String, Integer> expResult = new HashMap<>(); 
        expResult.put("Critical Attack",cost);
        String expString = (String)expResult.keySet().toArray()[0];
        int expInt = expResult.get("Critical Attack");
        System.out.println("broken yet?");
        System.out.println(expInt);
        System.out.println(expString);
        CriticalAttack instance = new CriticalAttack();
        Map<String, Integer> result = instance.use(battle);
        String resultString = (String) result.keySet().toArray()[0];
        assertEquals(expString, resultString);
    }
}