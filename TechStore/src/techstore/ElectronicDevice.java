
package techstore;

/**
 *
 * @author Beyza
 */
public abstract class ElectronicDevice {
    protected String brand,model,serialNum;
    protected double price;

    public ElectronicDevice() {
    }

    public ElectronicDevice(String brand, String model, String serialNum, double price) {
        this.brand = brand;
        this.model = model;
        this.serialNum=serialNum;
        this.price = price;
    }
    
    public abstract double calculatePrice();
    @Override
    public String toString(){
       return "\nElectronic Device Information"+
              "\nBrand : "+this.brand+
              "\nModel : "+this.model+
              "\nSerial Num : "+this.serialNum;
    }
}
