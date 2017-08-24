import java.util.HashMap;

/**
 * This class needs to have as default a number of attributes that it can sort by and have the appropireate sorting methods
 * @author juan
 *
 */
public class Inventory {
	public static final String ITEM_ID = "ID";
	public static final String ITEM_NAME = "Item Name";
	
	private HashMap<String, Item> inventory;
	private Item[] sortedInventory;   //Its sorted only when called so items are sorted as they get added/Get added
	
	
	/***** Constructors *****/
	
	/**
	 * 
	 */
	public Inventory() {
		inventory = new HashMap<String, Item>();
	}
	
	/**
	 * @param inventory
	 */
	public Inventory(HashMap<String, Item> inventory) {
		this.inventory = inventory;
	}
	/**
	 * @param name
	 * @param item
	 */
	public Inventory(String name, Item item) {
		inventory = new HashMap<String, Item>();
		item.setAttribute(ITEM_NAME, name);
		inventory.put(name, item);
	}
	/**
	 * @param item
	 */
	public Inventory(Item item) {
		inventory = new HashMap<String, Item>();
		inventory.put(item.getValueForKey(ITEM_NAME), item);
	}
	
	/***** Setters *****/
	
	/**
	 * @param itemName
	 * @param attribute
	 * @param value
	 */
	public void setAttribute(String itemName, String attribute, String value) {
		Item item = null;
		
		if (itemName != null) {
			item = inventory.get(itemName);
			
			if (item !=null) {
				item.setAttribute(attribute, value);
			}
		}
	}
	/**
	 * @param item
	 * @param newName
	 */
	public void setName(String itemName, String newName) {
		Item item = null;
		
		if (itemName != null) {
			item = inventory.get(itemName);			
			if (item !=null) {
				item.setAttribute(ITEM_NAME, newName);
			}
		}
	}
	
	
	/***** Getters *****/
	
	/**
	 * @param itemName
	 * @param attribute
	 * @return
	 */
	public String getAttribute(String itemName, String attribute) {
		Item item = null;
		
		if (itemName != null) {
			item = inventory.get(itemName);
			if (item  != null) {
				return item.getValueForKey(attribute);
			}
		}
		return null;
	}
	
	
	/***** Other *****/
	
	/**
	 * @param item
	 */
	public void addIventoryItem(Item item) {
		if (item != null) {
			inventory.put(item.getValueForKey(ITEM_NAME), item);
		}
	}
	/**
	 * @param itemName
	 * @param item
	 */
	public void addIventoryItem(String itemName, Item item) {
		item.setAttribute(ITEM_NAME, itemName);
		if (itemName != null && item != null) {
			inventory.put(itemName, item);
		}
	}
	
	/**
	 * @param filter
	 * @return
	 */
	public Item[] getSortedInventory(String filter){
		return null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return inventory.toString();		
	}
	
	/***** Private *****/
	
	
    
}