import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


// this class should automatically handle sales: Incrementing numberSold, decrementing inventory available
// Number of items sold should be checked against available inventory before a sale takes place
public class Register {
	public static boolean allowNegativeSales = false;
	
	private ArrayList<Sale> ledger;
	private Inventory inventory;
	
	
	/***** Constructors *****/
	public Register() {
		ledger = new ArrayList<Sale>();
		inventory = new Inventory();
	}
	
	public Register(Inventory inventory) {
		ledger = new ArrayList<Sale>();
		if (inventory != null) {
			this.inventory = inventory;
		}
	}
	
	/***** Setters *****/
	
	/***** Getters *****/
	
	/***** Other *****/
	
	public void addNewSale(Sale sale) {
		boolean canMakeSale = preSaleInventoryCheck(sale);
		
	}
	
	
	/***** INVENTORY CHECK *****/
	/**
	 * @param sale
	 * @return
	 */
	public boolean preSaleInventoryCheck(Sale sale){
		boolean pass = false;
		
		if (sale != null && sale instanceof Sale) {			
			HashMap<Item,Integer> itemMap = sale.getItemsSold();
			Set<Item> itemSet= sale.getItemsSold().keySet();
			
			for (Item item : itemSet){
				pass = checkInventory(item, itemMap.get(item));
				if (!pass){
					return pass;
				}
			}
		}
		return pass;
	}
	/**
	 * @param item
	 * @return
	 */
	public int checkInventory(Item item){
		int quantity = Integer.parseInt(inventory.getAttribute(item, Item.QUANTINTY));
		return quantity;
	}
	/**
	 * @param item
	 * @param quantToSell
	 * @return
	 */
	public boolean checkInventory(Item item, int quantToSell){
		if (item != null) {
			int availableQuant = Integer.parseInt(item.getValueForKey(Item.QUANTINTY));
			if (availableQuant >= quantToSell){
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	/**
	 * @param item
	 * @return
	 */
	public boolean isAvailable(Item item){
		if (item == null){
			return false;
		}
		if (checkInventory(item) < 1){
			return true;
		} else {
			return false;
		}
	}
	
	
	/***** Private *****/
	
	/**
	 * @param numberNeeded
	 * @param item
	 * @return
	 */
	private boolean checkInventory(int numberNeeded, Item item){
		return numberNeeded >= checkInventory(item);
	}
	
	
}
