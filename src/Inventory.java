import java.util.HashMap;

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
		}
		if (item !=null) {
			item.setAttribute(attribute, value);
		}
	}
	
	
	/***** Getters *****/
	
	
	/***** Other *****/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return inventory.toString();		
	}
	
	/***** Helpers *****/
	
	
    
}