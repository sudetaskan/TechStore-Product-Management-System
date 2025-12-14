/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techstore;

/**
 *
 * @author Beyza
 */
public class FanCount {
    public int numberFanCount(String brand){
        int numberOfFan=0; 
        switch(brand){
            case "Apple" ->  numberOfFan=2;
            case "Dell" ->  numberOfFan=2;
            case "Lenovo" ->  numberOfFan=1;
            case "Asus" ->  numberOfFan=1; 
        }
        return numberOfFan;
    }
}
