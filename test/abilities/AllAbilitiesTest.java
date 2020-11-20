/*
 * A class to test all abilities classes
 */
package abilities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    BalancedPhysicalShiftTest.class,
    BalancedMagicalShiftTest.class,
    BalancedRangedShiftTest.class
})
/**
 * @author Shawn Ferdig
 */
public class AllAbilitiesTest {}
