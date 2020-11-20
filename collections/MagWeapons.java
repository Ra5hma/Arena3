/*
 * This class represents all magical weapons
 */
package collections;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public enum MagWeapons {
    
    BO_STAFF("Bo Staff", "MAGICAL", 0.25, 0.5 , 0.25),
    WIZARDS_STAFF("Wizard Staff", "MAGICAL", 0.0, 1.0, 0.0),
    CLUB("Club Staff", "MAGICAL", 0.5, 0.5, 0.0),
    WAND("Wand Staff", "MAGICAL", 0.0, 0.5, 0.5);
    
    private final String description;
    private final String type;
    private final double strPercent;
    private final double magPercent;
    private final double dexPercent;

    
    private MagWeapons(String description, String type, double strPercent, 
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
