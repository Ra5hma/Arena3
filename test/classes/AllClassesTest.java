/*
 * Test Classes in the classes package
 */
package classes;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    BattleTest.class,
    BetTest.class,
    InnTest.class,
    ItemTest.class,
    MobTest.class, 
    PlayerTest.class,
    SmithTest.class,
    TrainerTest.class
})

/**
 * @author Shawn Ferdig
 */
public class AllClassesTest {
    
}
