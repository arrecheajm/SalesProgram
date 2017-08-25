import java.sql.Date;
import java.util.HashMap;

// How do I track the number of items sold for each item in items? make it a hashMap with the number sold as the value and the item name as the key?

public class Sale {
	public static final String QUANTITY_SOLD = "Quantity Sold";
	
	//should be able to purchase multiple items
	private HashMap<Item, Integer> items;
	private Date saleDate;
	private Payment payment;
	private HashMap<String, String> saleDetails;
	
	/***** Constructors *****/
	
	public Sale() {
		saleDetails = new HashMap<String, String>();
	}
	
	public Sale (HashMap<Item, Integer> items, Date saleDate, Payment payment) {
		this();
		if (items != null) {
			this.items = items;
		}
		if (saleDate != null) {
			this.saleDate = saleDate;
		}
		if (payment != null) {
			this.payment = payment;
		}
	}
	public Sale(Item item, Date saleDate, Payment payment, int numberSold ) {
		this();
		if (item != null) {
			this.items = new HashMap<Item, Integer>();
			items.put(item, numberSold);
		}
		if (saleDate != null) {
			this.saleDate = saleDate;
		}
		if (payment != null) {
			this.payment = payment;
		}
	}
	
	/***** Setters *****/
	public void setSaleDate(Date saleDate) {
		if(saleDate != null) {
			this.saleDate = saleDate;
		}
	}
	public void setPayment(Payment payment) {
		if (payment != null) {
			this.payment = payment;
		}
	}
	public void setItemsSold(HashMap<Item, Integer> items) {
		if(items != null) {
			this.items = items;
		}
	}
	public void setDetail(String attribute, String value) {
		if (attribute != null) {
			saleDetails.put(attribute, value);
		}
	}
	public void setNumberSold(Item item, int numberSold) {
		items.put(item, numberSold);
	}
	
	/***** Getters *****/
	public Date getSaleDate() {
		return this.saleDate;
	}
	public HashMap<Item, Integer> getItemsSold() {
		return this.items;
	}
	public Payment getPaymentMethod() {
		return this.payment;
	}
	
	public String getValueForKey(String attribute) {
		return saleDetails.get(attribute);
	}
	
	/***** Other *****/
	@Override
	public String toString() {
		return saleDetails.toString();
	}
	public boolean containsKey(String attribute) {
		return saleDetails.containsKey(attribute);
	}
	public boolean containsValue(String value) {
		return saleDetails.containsValue(value);
	}
	
	/***** Private *****/

}
