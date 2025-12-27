package techstore;

import java.util.ArrayList;
import techstore.models.ElectronicDevice;
import techstore.models.Laptop;
import techstore.models.SmartPhone;
import techstore.models.Tablet;

public class SystemClass {

    private static int stockAmount_L = 0;
    private static int stockAmount_T = 0;
    private static int stockAmount_S = 0;

    public static int getStockAmount_L() {
        return stockAmount_L;
    }

    public static int getStockAmount_T() {
        return stockAmount_T;
    }

    public static int getStockAmount_S() {
        return stockAmount_S;
    }

    public static void updateStock(ElectronicDevice device, int amount) {

        if (device instanceof Laptop) {

            if (amount < 0 && stockAmount_L <= 0) {
                System.out.println("WARNING!: Laptop stock is already at 0! It cannot drop any further.");
                return;
            }
            stockAmount_L += amount;

        } else if (device instanceof Tablet) {
            if (amount < 0 && stockAmount_T <= 0) {
                System.out.println("WARNING!: Tablet stock is already at 0! It cannot drop any further.");
                return;
            }
            stockAmount_T += amount;

        } else if (device instanceof SmartPhone) {
            if (amount < 0 && stockAmount_S <= 0) {
                System.out.println("WARNING!: Phone stock is already at 0! It cannot drop any further.");
                return;
            }
            stockAmount_S += amount;
        }
    }

    public static void addDevice(ArrayList<ElectronicDevice> list) {
        //Device:Laptops
        addToSystem(list, new Laptop("Apple", "MacBook Pro 14.2\\Space Black", "MDE04TU/A", 94999, 16, "Apple M5 (10 Core CPU/GPU)", 512));
        addToSystem(list, new Laptop("Dell", "Inspiron 3530 FHD 15.6\\Black", "I3530122024U12", 57999, 64, "Intel Core i5-1334U", 1024));
        addToSystem(list, new Laptop("Lenovo", "ThinkPad E16 (16\\WUXGA)", "21JT0017TX", 37999, 16, "AMD Ryzen 7 7730U", 512));
        addToSystem(list, new Laptop("Asus", "Zenbook 14", "UX3405CA-PP485W", 70999, 32, "Intel Core Ultra 9-285H", 1024));

        //Device:Tablets
        addToSystem(list, new Tablet("Apple", "iPad 11th Gen", "MD3Y4TU/A", 18499, 11));
        addToSystem(list, new Tablet("Samsung", "Galaxy Tab S10FE 8/128GB", "SM-X520NLBRTUR", 16899, 10.9));
        addToSystem(list, new Tablet("Lenovo", "Idea Tab 8/128GB", "ZAFM0109TR", 13999, 11));
        addToSystem(list, new Tablet("Samsung", "Galaxy Tab S10 Lite 8/256GB", "SM-X400NZSPTUR", 15799, 10.9));

        //Device:Smartphonnes
        addToSystem(list, new SmartPhone("Apple", "iPhone 15 Pro", "MTUW3TU/A", 90199, true));
        addToSystem(list, new SmartPhone("Samsung", "Galaxy S24 Ultra", "SM-S928BZTCTUR", 53999, true));
        addToSystem(list, new SmartPhone("Huawei", "Pura 80 Pro", "51098KFN", 59999, false));
        addToSystem(list, new SmartPhone("Honor", "400 Pro", "5109BUTL", 36999, true));

    }

    public static void addToSystem(ArrayList<ElectronicDevice> list, ElectronicDevice device) {
        list.add(device);
        updateStock(device, 1);
    }

    public static void addDeviceForManager(ArrayList<ElectronicDevice> deviceList, ElectronicDevice newDevice) {

        int insertIndex = 0;
        if (newDevice instanceof Laptop) {
            insertIndex = stockAmount_L;

        } else if (newDevice instanceof Tablet) {
            insertIndex = stockAmount_L + stockAmount_T;

        } else {
            insertIndex = deviceList.size();
        }
        if (insertIndex > deviceList.size()) {
            insertIndex = deviceList.size();
        }

        deviceList.add(insertIndex, newDevice);

        updateStock(newDevice, 1);

    }

    public static boolean deleteDevice(ArrayList<ElectronicDevice> deviceList, String serialNum) {
        return deleteRecursive(deviceList, serialNum, 0);
    }

    public static boolean deleteRecursive(ArrayList<ElectronicDevice> deviceList, String serialNum, int index) {

        if (index >= deviceList.size()) {
            return false;
        }
        ElectronicDevice currentDevice = deviceList.get(index);

        if (currentDevice.getSerialNum().equalsIgnoreCase(serialNum)) {

            deviceList.remove(index);
            updateStock(currentDevice, -1);

            return true;
        }
        return deleteRecursive(deviceList, serialNum, index + 1);
    }

    public static String displayDevices(ArrayList<ElectronicDevice> deviceList) {
        return displayRecursive(deviceList, 0);
    }

    public static String displayRecursive(ArrayList<ElectronicDevice> deviceList, int index) {
        if (index >= deviceList.size()) {
            return "";
        }

        String currentInfo = deviceList.get(index).toString();

        String restOfList = displayRecursive(deviceList, index + 1);

        return currentInfo + "\n----------------------------------------------------\n" + restOfList;
    }

    public static ElectronicDevice searchDevice(ArrayList<ElectronicDevice> deviceList, String serialNum) {
        return searchRecursive(deviceList, serialNum, 0);
    }

    public static ElectronicDevice searchRecursive(ArrayList<ElectronicDevice> deviceList, String serialNum, int index) {

        if (index >= deviceList.size()) {
            return null;
        }

        ElectronicDevice currentDevice = deviceList.get(index);

        if (currentDevice.getSerialNum().equalsIgnoreCase(serialNum)) {
            return currentDevice;
        }

        return searchRecursive(deviceList, serialNum, index + 1);
    }

    public static String searchDisplay(ElectronicDevice ex) {
        if (ex instanceof Laptop) {
            return ex.toString();

        } else if (ex instanceof Tablet) {
           return ex.toString();

        } else {
            return ex.toString();
        }

    }

    public static void main(String[] args) {
        

    }

}
