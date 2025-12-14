/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public ElectronicDevice(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
    public abstract double calculatePrice();
    @Override
    public String toString(){
       return "\nElectronic Device:"+
              "\nBrand: "+this.brand+
              "\nModel: "+this.model ;
    }
}
