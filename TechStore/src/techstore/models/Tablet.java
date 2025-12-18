
package techstore.models;

import techstore.components.Pencil;
import techstore.interfaces.Warranty;
import techstore.interfaces.CampaignApplicable;

public class Tablet extends ElectronicDevice implements Warranty, CampaignApplicable{
    private double screenSize;
    protected Pencil pencil;

    public Tablet() {
        
    }

    public Tablet(String brand, String model, String serialNum, double price,double screenSize) {
        super(brand, model, serialNum, price);
        this.screenSize = screenSize;
        this.pencil=new Pencil();
    }
    
    @Override
    public boolean applyDisCount(String brand) {
       return switch(brand){
           case "Apple","Lenovo" -> true;
           default -> false;
       };
    }
    @Override
    public double calculatePrice() {
        switch(this.brand){
            case "Apple" -> this.price=18499;
            case "Samsung" ->{
                switch(this.model){
                    case "Galaxy Tab S10FE 8/128GB" -> this.price=16899;
                    case "Galaxy Tab S10 Lite 8/256GB" -> this.price=15799;
                }
            }
            case "Lenovo" -> this.price=13999;
        }
        if(applyDisCount(brand)){
            this.price=this.price*0.95;
        }
        
        return this.price;
    }
    @Override
    public String toString(){
        boolean ischangeablePencilNib=pencil.isChangeablePencilNib(brand);
        String changeablePencilNib= ischangeablePencilNib ? "Yes" : "No";
        return  "\nTABLET"+
                 super.toString()+
                "\nScreen Size : "+this.screenSize+" inch"+
                "\nTablet's Pencil Type : "+pencil.getPencilType()+
                "\nIs the tablet's nib changeable ? : " + changeablePencilNib+
                "\nTablet's Warranty Period : "+ warrantyPeriod()+" months"+
                "\nThe Price of Tablet is "+calculatePrice()+" TL";
        
    }

    @Override
    public int warrantyPeriod() {
        int period = Tablet.STANDART_PERIOD1 + (int) (this.price / 15000);
        return period;
    }

    
    
}
