import java.util.HashMap;

public class Item {
    private HashMap<String, String> attributes;
    
    
    
    /**** Constructors *****/

    public Item(){
        this.attributes = new HashMap<String, String>();
    }

    public Item(HashMap<String, String> attributes){
        if (attributes != null){
            this.attributes = new HashMap<String, String>(attributes);
        }
    }
    public Item(String[] attributes, String[] values){
        if (attributes != null && values != null){
            this.attributes = new HashMap<String, String>();
            for (int i=0; i<attributes.length && i<values.length; i++){
            		this.attributes.put(attributes[i], values[i]);
            }
        }
    }
    public Item (String attribute, String value) {
    		if (attribute != null && value != null){
    			this.attributes = new HashMap<String, String>();
    			this.attributes.put(attribute, value);
    		}
    }
    
    
    /**** Setters *****/
    public void setAttribute(String attribute, String newValue) {
    		attributes.put(attribute, newValue);
    }
    
    
    /**** Getters *****/
    public String getValueForKey(String attribute) {
    		return attributes.get(attribute);
    }
    
    /**** Other *****/
    @Override
    public String toString() {
    		return attributes.toString();
    }
    public boolean containsKey(String attribute) {
    		return attributes.containsKey(attribute);
    }
    public boolean containsValue(String value) {
    		return attributes.containsValue(value);
    }
    
    
    
    
}