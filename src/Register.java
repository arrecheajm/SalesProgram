import java.util.ArrayList;


// this class should automatically handle sales: Incrementing numberSold, decrementing inventory available
public class Register {
	
	
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
		if (sale != null) {
			
		}
	}
	
	/***** Private *****/
	
	
}
