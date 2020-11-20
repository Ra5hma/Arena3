/*
 * This class represents all items.
 */
package collections;

/**
 * @author Shawn Ferdig
 */
public enum Items {
    
    HEALTH("Potion", 0.5, 0.0, 5),
    ABILITY("Blessed Water", 0.0, 0.5, 5),
    COMBO("Miricle Tincture", 0.25, 0.25, 10);
    
    private final String name;
    private final double hp;
    private final double mp;
    private final int value;
    
    private Items(String name, double hp, double mp, int value){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.value = value;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the hp
     */
    public double getHp() {
        return hp;
    }

    /**
     * @return the mp
     */
    public double getMp() {
        return mp;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
    
      
}
