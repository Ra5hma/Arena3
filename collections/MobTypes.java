/*
 * A class that defines each type of mob and contains mob attributes
 */
package collections;

/**
 * @author Shawn Ferdig
 */
public enum MobTypes {
    
    SKELETON(1, "Skeleton","/images/Skeleton.png","/images/SkeletonAttack.png",
           "/images/SkeletonMagic.png", "/images/skeletonRanged.png", 
           "/images/SkeletonMagicProjectile.png", "/images/bone.png", 
            "/soundEffects/skeletonPhysical.wav",
            "/soundEffects/skeletonMagical.wav",
            "/soundEffects/skeletonRanged.wav"),
    BAT(2, "Bat","/images/Bat.png","/images/BatAttack.png", 
           "/images/BatMagical.png", "/images/BatRanged.png", 
           "/images/BatMagicProjectile.png", "/images/BatRangedProjectile.png", 
            "/soundEffects/batPhysical.wav", "/soundEffects/batMagic.wav", 
            "/soundEffects/batRanged.wav"),
    GLADIATOR(3, "Gladiator","/images/Gladiator.png",
           "/images/GladiatorAttack.png", "/images/GladiatorMagicAttack.png", 
           "/images/GladiatorRangedAttack.png", 
           "/images/GladiatorMagicalProjectile.png", 
           "/images/GladiatorRangedProjectile.png", 
            "/soundEffects/gladiatorPhysical.wav",
            "/soundEffects/gladiatorMagical.wav", 
            "/soundEffects/gladiatorRanged.wav"),
    SLIME(4, "Slime", "/images/Slime.png","/images/SlimeAttack.png", 
           "/images/SlimeMagic.png", "/images/SlimeRange.png", 
           "/images/snowFlake.png", "/images/phlegm.png", 
            "/soundEffects/slimePhysical.wav", "/soundEffects/slimeMagical.wav", 
            "/soundEffects/slimeSpit.wav");
   
    private final int number;
    private final String name;
    private final String staticImage;
    private final String physicalImage;
    private final String magicalImage;
    private final String rangedImage;
    private final String magicalProjectileImage;
    private final String rangedProjectileImage;
    private final String physicalSound;
    private final String magicalSound;
    private final String rangedSound;
   
    private MobTypes(int number, String name, String staticImage, 
            String physicalImage, String magicalImage, String rangedImage, 
            String magicalProjectileImage, String rangedProjectileImage,
            String physicalSound, String magicalSound, String rangedSound){

        this.number = number;
        this.name = name;
        this.staticImage = staticImage;
        this.physicalImage = physicalImage;
        this.magicalImage = magicalImage;
        this.rangedImage = rangedImage;
        this.magicalProjectileImage = magicalProjectileImage;
        this.rangedProjectileImage = rangedProjectileImage;
        this.physicalSound = physicalSound;
        this.magicalSound = magicalSound;
        this.rangedSound = rangedSound;
    }

    public int getNumber(){
        return this.number;
    }
    public String getName() {
        return this.name;
    }

    public String getStaticImage() {
        return this.staticImage;
    }

    public String getPhysicalImage(){
        return this.physicalImage;
    }

    public String getMagicalImage(){
        return this.magicalImage;
    }

    public String getRangedImage(){
        return this.rangedImage;
    }

    public String getMagicalProjectileImage(){
        return this.magicalProjectileImage;
    }

    public String getRangedProjectileImage(){
        return this.rangedProjectileImage;
    }

    public String getPhysicalSound(){
        return this.physicalSound;
    }

    public String getMagicalSound(){
        return this.magicalSound;
    }

    public String getRangedSound(){
        return this.rangedSound;
    }
}
