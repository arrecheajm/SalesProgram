import java.util.HashMap;

/**
 * Add a variable to this class that controls hows the comparable methods compares two objects ? maybe
 * add equals method for searching
 * @author Juan Arrechea
 * @version 1.0
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
     * Creates a default item with an empty attribute listl
     */
    public Item(){
        this.attributes = new HashMap<String, String>();
    }

    /**
     * Creates an item with a gieven set of attributes
     * @param attributes Valid HashMap <String, String>
     */
    public Item(HashMap<String, String> attributes){
        if (attributes != null){
            this.attributes = new HashMap<String, String>(attributes);
        }
    }
    /**
     * Creates an item mapping attributes to values from each array in order
     * @param attributes array of attributes to be used as keys
     * @param values array of attribute values as strings
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
     * Creates an item with a a single attribute and value
     * @param attribute to be used as key
     * @param value attribute value as a string
     */
    public Item (String attribute, String value) {
		if (attribute != null && value != null){
			this.attributes = new HashMap<String, String>();
			this.attributes.put(attribute, value);
		}
    }
    /**
     * Creates an item from another item
     * @param other must be an instance of Item Class
     */
    public Item (Item other){
    	if (other != null && other instanceof Item){
        	this.attributes = other.getAttributes();    		
    	}
    }
    
    
    /**** Setters *****/
    
    /**
     * Given an attribute and its value, this method adds it to the attribute map.
     * If the attribute already exists, the value will be replaced
     * @param attribute attribute to be added or changed
     * @param newValue attribute's value as a string
     */
    public void setAttribute(String attribute, String newValue) {
    		attributes.put(attribute, newValue);
    }
    
    
    /**** Getters *****/
    
    /**
     * Returns the value mapped to a given key, null if the key is not mapped
     * @param attribute key to retrieve from attribute map
     * @return value mapped to given key or null if no mapping found
     */
    public String getValueForKey(String attribute) {
    		return attributes.get(attribute);
    }
    /**
     * Returns the attributes map from this item
     * @return itme's attribute map
     */
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
     * Returns the difference in "ITEM_ID" values between two items.
     * Returns -1 plus a console message will be passed if one or more items
     * lack mapping for ITEM_ID
     * @param other item to compare, must have a value mapped for ITEM_ID
     * @return the difference between two items' ITEM_ID value
     */
    //TODO check that each item has ITEM_ID value before comparing
    //TODO add exception class for Invalid comparison
    public int compareByID(Item other){
    	if (other != null){
    		return Integer.parseInt(attributes.get(ITEM_ID)) - Integer.parseInt(other.getValueForKey(ITEM_ID));
    	}
    	return -1;
    }
    /**
     * Returns the difference in "QUANTINTY" values between items.
     * Returns -1 plus a console message will be passed if one or more items
     * lack mapping for QUANTITY
     * @param other item to compare, must have a value mapped for QUANTINTY
     * @return the difference between this and other item
     */
    //TODO check that each item has QUANTINTY value before comparing
    //TODO add exception class for Invalid comparison
    public int compareByQuantinty(Item other){
    	if (other != null){
    		return Integer.parseInt(attributes.get(QUANTINTY)) - Integer.parseInt(other.getValueForKey(QUANTINTY));
    	}
    	return -1;
    }
    
    /**
     * Returns the value mapped for a given attribute
     * @param attribute to be used a key
     * @return value mapped to given attribute
     */
    public boolean containsKey(String attribute) {
    		return attributes.containsKey(attribute);
    }
    /**
     * Returns true if attributes map contains given value
     * @param value to be used as key
     * @return value mapped for given value, null if not mapping was found
     */
    public boolean containsValue(String value) {
    		return attributes.containsValue(value);
    }
    /**
     * Increments the value of an attribute that can be parsed as an integer
     * @param attribute must have a value mapped to it that can be parsed into
     * an integer 
     * @param increment value to increment attribute by
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