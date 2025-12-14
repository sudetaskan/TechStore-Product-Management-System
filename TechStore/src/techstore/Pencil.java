/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techstore;

/**
 *
 * @author Beyza
 */
public class Pencil {
    private String pencilType;
    public boolean isChangeablePencilNib(String brand){
        boolean isChange=false;
        switch(brand){
            case "Apple" -> {
                this.pencilType="Apple Pencil (2nd Generation)";
                isChange=true;
            }
            case "Samsung" -> {
                this.pencilType="S Pen Creator Edition";
                isChange=true;
            }
            case "Huawei" -> { 
                this.pencilType="HUAWEI M-Pencil (3rd Generation)";
                isChange=false;
            }    
            case "Microsoft" -> {
                this.pencilType="Surface Slim Pen 2";
                isChange=true;
            }    
        }
        return isChange;
    }
    
    public String getPencilType(){
        return pencilType;
    }
}
