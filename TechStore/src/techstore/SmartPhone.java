package techstore;

public class SmartPhone extends ElectronicDevice implements Warranty, CampaignApplicable{

    private boolean is5G;
    protected NfcModule nfcModule;

    

    public SmartPhone(boolean is5G, NfcModule nfcModule, String brand, String model, String serialNum, double price) {
        super(brand, model, serialNum, price);
        this.is5G = is5G;
        this.nfcModule =new NfcModule();
    }


        @Override
    public boolean applyDisCount(String brand) {
        return switch(brand){
            case "Samsung","Huawei","Nokia" ->true;
                default-> false;
        };
    }

    @Override
    public double calculatePrice() {
        switch(this.brand){
            case "Apple" -> this.price=100000;
            case "Samsung"-> this.price=80000;
            case "Huawei" -> this.price=60000;
            case "Nokia"->this.price=40000;
            
        }
        if(applyDisCount(brand)){
            this.price=this.price*0.85;
        
        }
        return price;

    }

    @Override
    public String toString() {
        boolean hasNfc = nfcModule.hasNfcModule(brand);
        String nfcState = hasNfc ? "Yes": "No";
        
        return "\nSmartPhone"
                + super.toString()
                + "\nIs 5G= " + is5G
                + "\nNfcModule= " +  nfcState;

    }

    @Override
    public void warrantityPeriod(int period) {
         period = Laptop.STANDART_PERIOD3 + (int) (this.price / 10000);
        System.out.printf("The warranty period for %s branded smartphone models is %d months.", this.brand, period);
        
    }



}
