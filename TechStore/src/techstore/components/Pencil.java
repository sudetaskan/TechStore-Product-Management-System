
package techstore.components;

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
                this.pencilType="Apple Pencil (USB-C)";
                isChange=true;
            }
            case "Samsung" -> {
                this.pencilType="S Pen (Standard Soft Tip)";
                isChange=true;
            }
            case "Lenovo" -> { 
                this.pencilType="Lenovo Precision Pen 2 (Active Stylus)";
                isChange=true;
            }    
               
        }
        return isChange;
    }
    
    public String getPencilType(){
        return pencilType;
    }
}
