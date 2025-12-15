
package techstore.components;


public class NfcModule {
   
    
    public boolean  hasNfcModule(String brand){
        return switch(brand){
            case "Apple","Samsung","Honor"-> true;
                default->false;
        };
        
        
    }
    
}
