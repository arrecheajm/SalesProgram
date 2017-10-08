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
	
	/**
	 * @param sale
	 */
	public void addNewSale(Sale sale) {
		int paymentReturnCode;
		boolean canMakeSale = preSaleInventoryCheck(sale);
		if (canMakeSale){
			paymentReturnCode = sale.validatePayment();
			if (paymentReturnCode == Sale.PAYMENT_FAILED) {
				System.err.println("Sale Failed / Payment Failed: "+sale.getValueForKey(Sale.PAYMENT_VERIFIED));
			} else if (paymentReturnCode == Sale.PAYMENT_UNDERPAID){
				if (allowNegativeSales){
					//TODO Continue processing sale where multiple payments are allwed and tracked
				} else {
					System.err.println("Sale Failed: "+Sale.PAYMENT_VERIFIED_UNDERPAID);
				}
			} else if (paymentReturnCode == Sale.PAYMENT_OVERPAID) {
				// Check if payment type is cash, if not fail the sale for over charging, if cash, add method stub to check for change in cashBox
				// After change, continue to process sale
			}
		}		
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
	/**
	 * This method will make inventory adjustments after to account for a sale:
	 * 	Increment number sold
	 * 	Decrement number available
	 *	Date stamp on sale
	 * @param sale
	 */
	//TODO use the increment integer value method from item to help processing
	public void processSale(Sale sale){
		
	}
	
	
	/***** Private *****/
	
	
}
