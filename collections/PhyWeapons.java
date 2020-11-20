/*
 * This class represents all phyisical weapons
 */
package collections;

/** 
 * @author Shawn Ferdig
 */
public enum PhyWeapons {
    
    LONG_SWORD("Long Sword", "PHYSICAL", 0.5, 0.0 , 0.5),
    SHORT_SWORD("Short Sword", "PHYSICAL", 0.5, 0.25, 0.25),
    BASTARD_SWORD("Bastard Sword", "PHYSICAL", 1.0, 0.0, 0.0),
    DAGGER("Dagger", "PHYSICAL", 0.5, 0.5, 0.0);
    
    private final String description;
    private final String type;
    private final double strPercent;
    private final double magPercent;
    private final double dexPercent;

    private PhyWeapons(String description, String type, double strPercent,
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
