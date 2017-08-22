import java.util.HashMap;

/**
 * @author juan
 *
 */
public class Item {
    private HashMap<String, String> attributes;
    
    
    
    /**** Constructors *****/

    /**
     * 
     */
    public Item(){
        this.attributes = new HashMap<String, String>();
    }

    /**
     * @param attributes
     */
    public Item(HashMap<String, String> attributes){
        if (attributes != null){
            this.attributes = new HashMap<String, String>(attributes);
        }
    }
    /**
     * @param attributes
     * @param values
     */
    public Item(String[] attributes, String[] values){
        if (attributes != null && values != null){
            this.attributes = new HashMap<String, String>();
            for (int i=0; i<attributes.length && i<values.length; i++){
            		this.attributes.put(attributes[i], values[i]);
            }
        }
    }
    /**
     * @param attribute
     * @param value
     */
    public Item (String attribute, String value) {
		if (attribute != null && value != null){
			this.attributes = new HashMap<String, String>();
			this.attributes.put(attribute, value);
		}
    }
    
    
    /**** Setters *****/
    /**
     * @param attribute
     * @param newValue
     */
    public void setAttribute(String attribute, String newValue) {
    		attributes.put(attribute, newValue);
    }
    
    
    /**** Getters *****/
    /**
     * @param attribute
     * @return
     */
    public String getValueForKey(String attribute) {
    		return attributes.get(attribute);
    }
    
    /**** Other *****/
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    		return attributes.toString();
    }
    /**
     * @param attribute
     * @return
     */
    public boolean containsKey(String attribute) {
    		return attributes.containsKey(attribute);
    }
    /**
     * @param value
     * @return
     */
    public boolean containsValue(String value) {
    		return attributes.containsValue(value);
    }
    
    
    
    
}