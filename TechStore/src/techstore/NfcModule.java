
package techstore;


public class NfcModule {
   
    
    public boolean  hasNfcModule(String brand){
        return switch(brand){
            case "Apple","Samsung"-> true;
                default->false;
        };
        
        
    }
    
}
