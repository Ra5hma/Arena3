/*
 * This class represnet all roles availible
 */
package collections;

/**
 * @author Shawn Ferdig
 */
public enum Roles {
    PHYSICAL("Knight"),
    MAGICAL("Mage"),
    RANGED("Ranger"),
    BALANCED("Hunter");        

    private final String role;

    private Roles(String role){
        this.role = role;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return this.role;
    }
}