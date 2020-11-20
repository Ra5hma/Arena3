/*
 * This class represents all dex weapons
 */
package collections;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public enum DexWeapons{
    LONG_BOW("Long Bow", "RANGED", 0.0, 0.0 , 1.0 ),
    SHORT_BOW("Short Bow", "RANGED", 0.25, 0.25, 0.5),
    HEAVY_CROSSBOW("Heavy Crossbow", "RANGED", 0.5, 0.0, 0.5),
    LIGHT_CROSSBOW("Light Crossbow", "RANGED", 0.0, 0.5, 0.5);
    
    private final String description;
    private final String type;
    private final double strPercent;
    private final double magPercent;
    private final double dexPercent;

    
    private DexWeapons(String description, String type, double strPercent, 
            double magPercent, double dexPercent){
        this.description = description;
        this.type = type;        
        this.strPercent = strPercent;
        this.magPercent = magPercent;
        this.dexPercent = dexPercent;
    }
  
    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @return the strPercent
     */
    public double getStrPercent() {
        return this.strPercent;
    }

    /**
     * @return the magPercent
     */
    public double getMagPercent() {
        return this.magPercent;
    }

    /**
     * @return the dexPercent
     */
    public double getDexPercent() {
        return this.dexPercent;
    }
}

