
package techstore.interfaces;

public interface Warranty {
    public static final int STANDART_PERIOD1=12;  // the value for tablet
    public static final int STANDART_PERIOD2=36;  // the value for laptop
    public static final int STANDART_PERIOD3=24;  // the value for smartphone
    
    public abstract int warrantyPeriod();
}
