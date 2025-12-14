/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techstore;

/**
 *
 * @author Beyza
 */
public class Tablet extends ElectronicDevice implements Warrantity{
    private double screenSize;
    protected Pencil pencil;

    public Tablet() {
        
    }

    public Tablet(double screenSize, String brand, String model, String serialNum, double price) {
        super(brand, model, serialNum, price);
        this.screenSize = screenSize;
    }
    
    
    @Override
    public double calculatePrice() {
        switch(this.brand){
            case "Apple" -> this.price=68000;
            case "Samsung" -> this.price=43000;
            case "Huawei" -> this.price=32000;
            case "Microsoft" -> this.price=60000;
        }
        return this.price;//indirim ile ilgili kısım eklenecek
    }
    @Override
    public String toString(){
        return   super.toString()+
                "\nElectronic Device : Tablet"+
                "\nScreen Size : "+this.screenSize+
                "\nTablet's Pencil Type : "+pencil.getPencilType()+
                "\nIs the tablet's nib changeable ? : "+pencil.isChangeablePencilNib(brand);
        
    }

    @Override
    public void warrantityPeriod(int period) {
        period=Tablet.STANDART_PERİOD1 + (int)(this.price/10000);
        System.out.printf("The warranty period for %s branded tablet models is %d months.",this.brand,period);
    }
    
}
