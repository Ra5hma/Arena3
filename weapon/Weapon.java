/*
 * Interface that defines a weapon
 */
package weapon;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 * 
 */
public interface Weapon {

    public String getName();

    public String getDescription();

    public String getType();

    public String getPrefix(); 

    public int getStr();

    public int getMag();

    public int getDex();
    
    public int getCost();
    
    public int getValue();
}
