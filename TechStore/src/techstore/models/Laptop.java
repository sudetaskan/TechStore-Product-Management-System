package techstore.models;

import techstore.components.FanCount;
import techstore.interfaces.Warranty;
import techstore.interfaces.CampaignApplicable;

public class Laptop extends ElectronicDevice implements Warranty, CampaignApplicable {

    private int ramSize,ssd;
    private String cpu;
    protected FanCount fanCount;

    public Laptop() {
    }

    public Laptop(String brand, String model, String serialNum, double price, int ramSize, String cpu,int ssd) {
        super(brand, model, serialNum, price);
        this.ramSize = ramSize;
        this.cpu = cpu;
        this.ssd=ssd;
        this.fanCount=new FanCount();
    }

    
    @Override
    public boolean applyDisCount(String brand) {
        return switch (brand) {
            case "Apple", "Dell" ->
                true;
            default ->
                false;
        };
    }

    @Override
    public double calculatePrice() {
        switch (this.brand) {
            case "Apple" ->
                this.price = 94999;
            case "Dell" ->
                this.price = 57999;
            case "Lenovo" ->
                this.price = 37999;
            case "Asus" ->
                this.price = 70999;
        }
       if(applyDisCount(brand)){
           this.price=this.price*0.9;
       }
       
        return this.price;
    }

    public int getRamSize() {
        return ramSize;
    }

    public String getCpu() {
        return cpu;
    }

    public int getSsd() {
        return ssd;
    }

    public FanCount getFanCount() {
        return fanCount;
    }

    @Override
    public String toString() {
        return "\nLAPTOP"
                + super.toString()
                + "\nRam Size : " + this.ramSize + " GB"
                + "\nSSD : " + this.ssd + " GB"
                + "\nCPU : " + this.cpu
                + "\nLaptop's Fan Count : " + fanCount.numberFanCount(brand)
                + "\nLaptop's Warranty Period : "+ warrantyPeriod()+" months"
                + "\nThe Price of Laptop is " + calculatePrice() + " TL";

    }

    @Override
    public int warrantyPeriod() {
        int period = Laptop.STANDART_PERIOD2 + (int) (this.price / 15000);
        return period;
    }

}

