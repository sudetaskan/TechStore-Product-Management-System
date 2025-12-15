
package techstore;

/**
 *
 * @author Beyza
 */
public class Tablet extends ElectronicDevice implements Warranty, CampaignApplicable{
    private double screenSize;
    protected Pencil pencil;

    public Tablet() {
        
    }

    public Tablet(double screenSize, String brand, String model, String serialNum, double price) {
        super(brand, model, serialNum, price);
        this.screenSize = screenSize;
        this.pencil= new Pencil();
    }
    
    @Override
    public boolean applyDisCount(String brand) {
       return switch(brand){
           case "Apple","Microsoft" -> true;
           default -> false;
       };
    }
    @Override
    public double calculatePrice() {
        switch(this.brand){
            case "Apple" -> this.price=68000;
            case "Samsung" -> this.price=43000;
            case "Huawei" -> this.price=32000;
            case "Microsoft" -> this.price=60000;
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
                "\nScreen Size : "+this.screenSize+
                "\nTablet's Pencil Type : "+pencil.getPencilType()+
                "\nIs the tablet's nib changeable ? : " + changeablePencilNib+
                "\nThe Price of Tablet is "+calculatePrice()+" TL";
        
    }

    @Override
    public void warrantityPeriod(int period) {
        period=Tablet.STANDART_PERIOD1 + (int)(this.price/10000);
        System.out.printf("The warranty period for %s branded tablet models is %d months.",this.brand,period);
    }

    
    
}
