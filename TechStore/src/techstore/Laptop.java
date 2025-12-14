package techstore;

/**
 *
 * @author Beyza
 */
public class Laptop extends ElectronicDevice implements Warranty, CampaignApplicable {

    private int ramSize, cpu;
    protected FanCount fanCount;

    public Laptop() {
    }

    public Laptop(String brand, String model, String serialNum, double price, int ramSize, int cpu) {
        super(brand, model, serialNum, price);
        this.ramSize = ramSize;
        this.cpu = cpu;
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
                this.price = 95000;
            case "Dell" ->
                this.price = 88000;
            case "Lenovo" ->
                this.price = 65000;
            case "Asus" ->
                this.price = 38000;
        }
       if(applyDisCount(brand)){
           this.price=this.price*0.9;
       }
       
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nElectronic Device : Laptop"
                + "\nRam Size : " + this.ramSize
                + "\nCPU : " + this.cpu
                + "\nLaptop's Fan Count : " + fanCount.numberFanCount(brand);

    }

    @Override
    public void warrantityPeriod(int period) {
        period = Laptop.STANDART_PERIOD2 + (int) (this.price / 15000);
        System.out.printf("The warranty period for %s branded laptop models is %d months.", this.brand, period);
    }

}
