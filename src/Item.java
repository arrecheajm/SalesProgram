import java.util.HashMap;

/**
 * Add a variable to this class that controls hows the comparable methods compares two objects ? maybe
 * add equals method for searching
 * @author juan
 *
 */
public class Item {
	public static final String ITEM_ID = "ID";
	public static final String ITEM_NAME = "Item Name";
	public static final String QUANTINTY = "Quantinty";
	public static final String NUMBER_SOLD = "Number Sold";
	public static final String PRICE = "Price";
	public static final String COST = "Cost";
	
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
    /**
     * @param other
     */
    public Item (Item other){
    	if (other != null && other instanceof Item){
        	this.attributes = other.getAttributes();    		
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
    public HashMap<String, String> getAttributes(){
    	return attributes;
    }
    
    /**** Other *****/
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    		return attributes.toString();
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other){
    	if (other == null){
    		return false;
    	}
    	if (other instanceof Item){
    		Item otherItem = (Item)other;
    		return this.attributes.equals(otherItem.getAttributes());
    	}
		return false;
    }
    /**
     * @param other
     * @return
     */
    public int compareByID(Item other){
    	if (other != null){
    		return Integer.parseInt(attributes.get(ITEM_ID)) - Integer.parseInt(other.getValueForKey(ITEM_ID));
    	}
    	return -1;
    }
    /**
     * @param other
     * @return
     */
    public int compareByQuantinty(Item other){
    	if (other != null){
    		return Integer.parseInt(attributes.get(QUANTINTY)) - Integer.parseInt(other.getValueForKey(QUANTINTY));
    	}
    	return -1;
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
    /**
     * @param attribute
     * @param increment
     */
    public void incrementIntegerValue(String attribute, int increment){
    	int temp = 0;
    	if (attribute != null && attributes.containsValue(attribute)){
    		{
    			temp = Integer.parseInt(attributes.get(attribute)) + (increment);
    			attributes.put(attribute, temp+"");
    		}
    	}
    }
    
    /***** Private *****/
    
    
    
}