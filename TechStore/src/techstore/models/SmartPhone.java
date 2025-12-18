package techstore.models;

import techstore.components.NfcModule;
import techstore.interfaces.Warranty;
import techstore.interfaces.CampaignApplicable;

public class SmartPhone extends ElectronicDevice implements Warranty, CampaignApplicable {

    private boolean is5G;
    protected NfcModule nfcModule;

    public SmartPhone() {
    }

    public SmartPhone(String brand, String model, String serialNum, double price, boolean is5G) {
        super(brand, model, serialNum, price);
        this.is5G = is5G;
        this.nfcModule = new NfcModule();
    }

    @Override
    public boolean applyDisCount(String brand) {
        return switch (brand) {
            case "Samsung", "Huawei" ->
                true;
            default ->
                false;
        };
    }

    @Override
    public double calculatePrice() {
        switch (this.brand) {
            case "Apple" ->
                this.price = 90199;
            case "Samsung" ->
                this.price = 53999;
            case "Huawei" ->
                this.price = 59999;
            case "Honor" ->
                this.price = 36999;

        }
        if (applyDisCount(brand)) {
            this.price = this.price * 0.85;

        }
        return price;

    }

    @Override
    public int warrantyPeriod() {
        int period = SmartPhone.STANDART_PERIOD3 + (int) (this.price / 15000);
        return period;
    }

    @Override
    public String toString() {
        boolean hasNfc = nfcModule.hasNfcModule(brand);
        String nfcState = hasNfc ? "Yes" : "No";

        boolean has5G = this.is5G;
        String has5GState = has5G ? "Yes" : "No";
        return "\nSMARTPHONE"
                + super.toString()
                + "\nIs the smartphone's 5G ? : " + has5GState
                + "\nIs the smartphone's nfc module ? : " + nfcState
                + "\nSmartphone's Warranty Period : "+ warrantyPeriod()+" months"
                + "\nThe Price of Smartphone is " + calculatePrice() + " TL";

    }

}
