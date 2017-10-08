import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class needs to have as default a number of attributes that it can sort by and have the appropireate sorting methods ? Maybe
 * Change inventory to arraylist?
 * Add boolean returns to all getters on this class?
 * @author juan
 *
 */
public class Inventory {
	
	
	//private HashMap<String, Item> inventory; // This should be changed to an arrayList or something similar that can be iterated
	private ArrayList<Item> inventory;
	private Item[] sortedInventory;   //Its sorted only when called so items are sorted as they get added/Get added
	
	/***** Constructors *****/
	
	/**
	 * 
	 */
	public Inventory() {
		inventory = new ArrayList<Item>();
	}
	
	/**
	 * @param inventory
	 */
	public Inventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	/**
	 * @param name
	 * @param item
	 */
	public Inventory(String name, Item item) {
		inventory = new ArrayList<Item>();
		item.setAttribute(Item.ITEM_NAME, name);
		inventory.add(item);
	}
	/**
	 * @param item
	 */
	public Inventory(Item item) {
		inventory = new ArrayList<Item>();
		inventory.add(item);
	}
	
	/***** Setters *****/
	
	/**
	 * @param itemName
	 * @param attribute
	 * @param value
	 */
	public void setAttribute(String itemName, String attribute, String value) {
		Item temp = null;
		if (itemName != null) {
			temp = findItem(itemName);			
			if (temp !=null) {
				temp.setAttribute(attribute, value);
			}
		}
	}
	/**
	 * @param item
	 * @param newName
	 */
	public void setName(String itemName, String newName) {
		setAttribute(itemName, Item.ITEM_NAME, newName);
	}
	
	
	/***** Getters *****/
	
	/**
	 * @param itemName
	 * @param attribute
	 * @return
	 */
	public String getAttribute(String itemName, String attribute) {
		Item temp = null;
		if (itemName != null) {
			temp = findItem(itemName);			
			if (temp !=null) {
				temp.getValueForKey(attribute);
			}
		}
		return null;
	}
	/**
	 * @param item
	 * @param attribute
	 * @return
	 */
	public String getAttribute(Item item, String attribute){
		String value = null;
		int itemIndex = -1;
		
		if (item != null){
			itemIndex = getItemIndex(item);
			if (itemIndex >= 0){
				value = inventory.get(itemIndex).getValueForKey(attribute);
			}
		}
		return value;
	}
	
	
	/***** Other *****/
	
	/**
	 * @param item
	 */
	public void addIventoryItem(Item item) {
		if (item != null) {
			Item temp = findItem(item.getValueForKey(Item.ITEM_NAME));
			if (temp == null){
				inventory.add(item);
			} else {
				temp.incrementIntegerValue(Item.QUANTINTY, 1);
			}
		}
	}
	/**
	 * @param itemName
	 * @param item
	 */
	public void addIventoryItem(String itemName, Item item) {
		if (itemName != null && item != null) {
			item.setAttribute(Item.ITEM_NAME, itemName);
			if (!inventory.contains(item)) {
				inventory.add(item);
			}
		}
	}
	
	/**
	 * @param filter
	 * @return
	 */
	public Item[] getSortedInventory(String filter){
		return sortedInventory;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return inventory.toString();		
	}
	/**
	 * @param item
	 * @return
	 */
	public boolean contains(Item item){
		if (findItem(item) != null){
			return true;
		}
		return false;
	}
	/**
	 * @param itemName
	 * @return
	 */
	public boolean contains(String itemName){
		if (findItem(itemName) != null){
			return true;
		}
		return false;
	}
	/**
	 * @param item
	 * @return
	 */
	public Item find(Item item){
		return findItem(item);
	}
	/**
	 * @param itemName
	 * @return
	 */
	public Item find(String itemName){
		return findItem(itemName);
	}
	
	/***** Private *****/
	/**
	 * @param item
	 * @return
	 */
	private Item findItem(Item item){
		Item temp = null;
		if (item != null){
			for (Item current : inventory){
				if (current.equals(item)){
					temp = current;
				}
			}
		}
		return temp;
	}
	/**
	 * @param itemName
	 * @return
	 */
	private Item findItem(String itemName){
		Item temp = null;
		if (itemName != null){
			for (Item item : inventory){
				if (item.getValueForKey(Item.ITEM_NAME).equals(itemName)){
					temp = new Item(item);
				}
			}
		}
		return temp;
	}
	/**
	 * @param item
	 * @return
	 */
	private int getItemIndex(Item item){
		int index = -1;
		if (item != null){
			for ( int i = 0; i < inventory.size(); i++){
				if (inventory.get(i).equals(item)){
					index = i;
				}
			}
		}
		return index;
	}
	
    
}