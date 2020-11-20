/*
 * Stores all ablility name, type, description and cost
 */
package collections;

/**
 * @author Shawn Ferdig
 */
public enum Abilities {
    
    BALANCED_PHYSICAL_SHIFT("Balanced Str Shift", "Physical", 
            "Balances Attributes",  0.05, 0.0),
    CRITICAL_ATTACK("Critical Attack", "Physical", 
            "Attack ignoring opponent's STR", 0.1, 10.0),
    CURE("Cure", "Magical", "Restore HP.", 0.3, 0.5),
    DOUBLE_ATTACK("Double Attack", "Ranged","Take back to back turns",  0.5, 
            0.0),
    MAGIC_MISSILE("Magic Missile", "Magical", "Targets lowest attribute",0.1, 
            0.0),
    PHYSICAL_SHIFT("Rugged Shift", "Balanced", "Aligns attributes to STR", 0.05,
            0.0),
    RANGED_SHIFT("Swift Shift", "Balanced", "Aligns attributes to DEX", 0.05,
            0.0), 
    MAGICAL_SHIFT("Void Shift", "Balanced", "Aligns attributes to MAG", 0.05,
            0.0),
    BALANCED_MAGICAL_SHIFT("Balanced Mag Shift", "Magical",
            "Balances Attributes", 0.05, 0.0),
    BALANCED_RANGED_SHIFT("Balanced Dex Shift", "Ranged", "Balances Attributes",
            0.05, 0.0);
    
    private final String name;
    private final String type;
    private final String description;
    private final double cost;
    private final double potency;

    private Abilities(String name, String type, String description, double cost,
            double potency){
        this.name = name;
        this.type = type;
        this.description = description;
        this.cost = cost;
        this.potency = potency;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }
    
    public double getPotency(){
        return potency;
    }
}
