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
	
	public Register(Inventory inventory, ArrayList<Sale> ledger) {
		if (inventory != null) {
			this.inventory = inventory;
		}
		if (ledger != null) {
			this.ledger = ledger;
		}
	}
	public Register( Inventory inventory, Sale sale) {
		this();
		if (inventory != null) {
			this.inventory = inventory;
		}
		ledger.add(sale);
	}
	
	/***** Setters *****/
	
	/***** Getters *****/
	
	/***** Other *****/
	public void addNewSale(Sale sale) {
		Item[] itemsSold;
		if (sale != null) {
			itemsSold = sale.getItemsSold();
			for (int i=0; i<itemsSold.length; i++) {
				
			}
		}
	}
	
	/***** Private *****/
	
	
}
