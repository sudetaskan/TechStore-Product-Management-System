
package techstore;

import java.util.ArrayList;
import techstore.models.ElectronicDevice;
import techstore.models.Laptop;
import techstore.models.SmartPhone;
import techstore.models.Tablet;

/**
 *
 * @author SUDE TAŞKAN
 */
public class SystemClass {

    /**
     * @param args the command line arguments
     */
    private static int stockAmount_L = 4, stockAmount_T = 4, stockAmount_S = 4;

    public static int getStockAmount_L() {
        return stockAmount_L;
    }

    public static int getStockAmount_T() {
        return stockAmount_T;
    }

    public static int getStockAmount_S() {
        return stockAmount_S;
    }

    

    public static void addDevice(ArrayList<ElectronicDevice> deviceList) {

        //Device:Laptops
        deviceList.add(new Laptop("Apple", "MacBook Pro 14.2\\Space Black", "MDE04TU/A", 94999, 16, "Apple M5 (10 Core CPU/GPU)", 512));
        deviceList.add(new Laptop("Dell", "Inspiron 3530 FHD 15.6\\Black", "I3530122024U12", 57999, 64, "Intel Core i5-1334U", 1024));
        deviceList.add(new Laptop("Lenovo", "ThinkPad E16 (16\\WUXGA)", "21JT0017TX", 37999, 16, "AMD Ryzen 7 7730U", 512));
        deviceList.add(new Laptop("Asus", "Zenbook 14", "UX3405CA-PP485W", 70999, 32, "Intel Core Ultra 9-285H", 1024));

        //Device:Tablets
        deviceList.add(new Tablet("Apple", "iPad 11th Gen", "MD3Y4TU/A", 18499, 11));
        deviceList.add(new Tablet("Samsung", "Galaxy Tab S10FE 8/128GB", "SM-X520NLBRTUR", 16899, 10.9));
        deviceList.add(new Tablet("Lenovo", "Idea Tab 8/128GB", "ZAFM0109TR", 13999, 11));
        deviceList.add(new Tablet("Samsung", "Galaxy Tab S10 Lite 8/256GB", "SM-X400NZSPTUR ", 15799, 10.9));

        //Device:Smartphonnes
        deviceList.add(new SmartPhone("Apple", "iPhone 15 Pro", "MTUW3TU/A", 90199, true));
        deviceList.add(new SmartPhone("Samsung", "Galaxy S24 Ultra", "SM-S928BZTCTUR", 53999, true));
        deviceList.add(new SmartPhone("Huawei", "Pura 80 Pro", "51098KFN", 59999, false));
        deviceList.add(new SmartPhone("Honor", "400 Pro", "5109BUTL", 36999, true));

    }

    public static void deleteManual(ArrayList<ElectronicDevice> deviceList, int index) {

        if (index < 0 || index >= deviceList.size()) {
            return;
        }

        ArrayList<ElectronicDevice> newList = new ArrayList<>();

        for (int i = 0; i < deviceList.size(); i++) {
            if (i != index) {
                newList.add(deviceList.get(i));
            }
        }
        deviceList = newList;
    }

    public static ElectronicDevice searchRecursive(ArrayList<ElectronicDevice> deviceList,
            String serialNum, int index) {
        if (index >= deviceList.size()) {
            return null;
        }

        if (deviceList.get(index).getSerialNum().equals(serialNum)) {
            return deviceList.get(index);
        }

        return searchRecursive(deviceList, serialNum, index + 1);
    }

    public static ElectronicDevice searchRecursiveHelper(ArrayList<ElectronicDevice> deviceList,
            String serialNum) {
        return searchRecursive(deviceList, serialNum, 0);
    }

    public static void displayRecursiveHelper(ArrayList<ElectronicDevice> deviceList) {
        displayRecursive(deviceList, 0);
    }

    public static void displayRecursive(ArrayList<ElectronicDevice> deviceList, int index) {

        
        if (index >= deviceList.size()) {
            return;
        }

      
        System.out.println(deviceList.get(index).toString());
        System.out.println();

        
        displayRecursive(deviceList, index + 1);
    }

    public static void addDeviceForManager(String serialNum) {

    }

    public static void main(String[] args) {
        ArrayList<ElectronicDevice> deviceList = new ArrayList<>();

        SystemClass.addDevice(deviceList);

    }

}
