/*
 * Test class for Mob Class
 */
package classes;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Shawn Ferdig
 */
public class MobTest {
    Mob mob;
    
    public MobTest() {
    }
    
    @Before
    public void init(){
    //this constructor calls all the set methods
    mob = new Mob(2); 

    }
    
    /**
     * Test of setName method, of class Mob.
     */
    @Test
    public void testNameImage() {
        String name = mob.getName();
        boolean result;
        switch(name){
            case("Skeleton"):
                result = true;
                break;
            case("Bat"):
                result = true;
                break;
            case("Gladiator"):
                result = true;
                break;
            case("Slime"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob getName()", result);
    }
    
    /**
     * Test of setStaticImage method, of class Mob.
     */
    @Test
    public void testSetStaticImage() {
        String file = mob.getStaticImage();
        boolean result;
        switch(file){
            case("/images/Skeleton.png"):
                result = true;
                break;
            case("/images/Bat.png"):
                result = true;
                break;
            case("/images/Gladiator.png"):
                result = true;
                break;
            case("/images/Slime.png"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob getStaticImage()", result);
    }

    /**
     * Test of setPhysicalImage method, of class Mob.
     */
    @Test
    public void testSetPhysicalImage() {
        String file = mob.getPhysicalImage();
        boolean result;
        switch(file){
            case("/images/SkeletonAttack.png"):
                result = true;
                break;
            case("/images/BatAttack.png"):
                result = true;
                break;
            case("/images/GladiatorAttack.png"):
                result = true;
                break;
            case("/images/SlimeAttack.png"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob getPhysicalImage()", result);
    }
    
    /**
     * Test of setMagicalImage method, of class Mob.
     */
    @Test
    public void testSetMagicalImage() {
        String file = mob.getMagicalImage();
        boolean result;
        switch(file){
            case("/images/SkeletonMagic.png"):
                result = true;
                break;
            case("/images/BatMagical.png"):
                result = true;
                break;
            case("/images/GladiatorMagicAttack.png"):
                result = true;
                break;
            case("/images/SlimeMagic.png"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob getMagicalImage()", result);
    }

    /**
     * Test of setRangedImage method, of class Mob.
     */
    @Test
    public void testSetRangedImage() {
        String file = mob.getRangedImage();
        boolean result;
        switch(file){
            case("/images/skeletonRanged.png"):
                result = true;
                break;
            case("/images/BatRanged.png"):
                result = true;
                break;
            case("/images/GladiatorRangedAttack.png"):
                result = true;
                break;
            case("/images/SlimeRange.png"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob getRangedImage()", result);
    }
    
    /**
     * Test of setMagicalProjectileImage method, of class Mob.
     */
    @Test
    public void testSetMagicalProjectileImage() {
        String file = mob.getMagicalProjectileImage();
        boolean result;
        switch(file){
            case("/images/SkeletonMagicProjectile.png"):
                result = true;
                break;
            case("/images/BatMagicProjectile.png"):
                result = true;
                break;
            case("/images/GladiatorMagicalProjectile.png"):
                result = true;
                break;
            case("/images/snowFlake.png"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob getMagicalProjectileImage()", result);
    }
    
    /**
     * Test of setRangedProjectileImage method, of class Mob.
     */
    @Test
    public void testSetRangedProjectileImage() {
        String file = mob.getRangedProjectileImage();
        boolean result;
        switch(file){
            case("/images/bone.png"):
                result = true;
                break;
            case("/images/BatRangedProjectile.png"):
                result = true;
                break;
            case("/images/GladiatorRangedProjectile.png"):
                result = true;
                break;
            case("/images/phlegm.png"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob getRangedProjectileImage()", result);
    }
    
    /**
     * Test of setPhysicalSound method, of class Mob.
     */
    @Test
    public void testSetPhysicalSound() {
        String file = mob.getPhysicalSound();
        boolean result;
        switch(file){
            case("/soundEffects/skeletonPhysical.wav"):
                result = true;
                break;
            case("/soundEffects/batPhysical.wav"):
                result = true;
                break;
            case("/soundEffects/gladiatorPhysical.wav"):
                result = true;
                break;
            case("/soundEffects/slimePhysical.wav"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob setPhysicalSound()", result);
    }
    
    /**
     * Test of setMagicalSound method, of class Mob.
     */
    @Test
    public void testSetMagicalSound() {
        String file = mob.getMagicalSound();
        boolean result;
        switch(file){
            case("/soundEffects/skeletonMagical.wav"):
                result = true;
                break;
            case("/soundEffects/batMagic.wav"):
                result = true;
                break;
            case("/soundEffects/gladiatorMagical.wav"):
                result = true;
                break;
            case("/soundEffects/slimeMagical.wav"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob setMagicalSound()", result);
    }
    
    /**
     * Test of setRangedSound method, of class Mob.
     */
    @Test
    public void testSetRangedSound() {
        String file = mob.getRangedSound();
        boolean result;
        switch(file){
            case("/soundEffects/skeletonRanged.wav"):
                result = true;
                break;
            case("/soundEffects/batRanged.wav"):
                result = true;
                break;
            case("/soundEffects/gladiatorRanged.wav"):
                result = true;
                break;
            case("/soundEffects/slimeSpit.wav"):
                result = true;
                break;
            default:
                result = false;
                break;
        }
        assertTrue("Testing mob setRangedSound()", result);
    }
    
    /**
     * Test of setRole method, of class Mob.
     */
    public void testSetRole(){
        
        mob.setStr(10);
        mob.setMag(5);
        mob.setDex(3);
        mob.setRole();
        String expResult = "Knight";
        String result = mob.getRole();
        assertEquals("Teseting setRole", expResult, result);
    }
    
    /**
     *  Test of setLevel method, of class Mob.
     */
    public void testSetLevel(){
        
        int level = mob.getLevel();
        boolean cLevel = level > 0 && level < 3;
        assertTrue("Testing setLevel()", cLevel);
    }
    
    /**
     *  Test of setXpValue method, of class Mob.
     */
    public void testSetXpValue(){
        
        int xpValue = mob.getXpValue();
        boolean xpLevel = xpValue > 12 && xpValue < 15;
        assertTrue("Testing setXpLevel()", xpLevel);
    }
    
    /**
     *  Test of setGoldValue method, of class Mob.
     */
    public void testSetGoldValue(){
        
        int goldValue = mob.getGoldValue();
        boolean result = goldValue > 14 && goldValue < 46;
        assertTrue("Testing setGoldLevel()", result);
    }
    
     /**
     *  Test of setStats method, of class Mob.
     */
    public void testSetStats(){
    
        int totalTest = mob.getStr()+ mob.getMag() + mob.getDex();
        boolean maxHp = mob.getMaxHp() >= 60 && mob.getMaxHp() <= 120; 
        boolean maxMp = mob.getMaxMp() >= 10 && mob.getMaxMp() <= 70;
        boolean speed = mob.getSpeed() >= 10 && mob.getSpeed() <= 70;
        assertTrue("Testing maxHp", maxHp);
        assertEquals("Testing stat total", 12, totalTest);
        assertTrue("Testing maxMP", maxMp);
        assertTrue("Testing speed", speed);
    }
    
    /**
     * Test of yaDead method, of class Mob.
     */
    @Test
    public void testYaDead() {
        
        mob.setCurHp(1);
        boolean result = mob.yaDead();
        assertFalse("Test if the mob's curHp is below 1", result);
    }
    
}
