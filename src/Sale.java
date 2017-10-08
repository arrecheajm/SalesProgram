import java.sql.Date;
import java.util.HashMap;
import java.util.Set;

// How do I track the number of items sold for each item in items? make it a hashMap with the number sold as the value and the item name as the key?
// Look for a better way to store the items sold and their quantity so they can be easily retrieved by the Register to adjust inventory
public class Sale {
	public static final String QUANTITY_SOLD = "Quantity Sold";
	public static final String PAYMENT_TYPE = "Payment Type";
	public static final String MULTIPLE_PAYMENT_TYPES = "Multiple Payment Types";
	public static final String PAYMENT_VERIFIED = "Payment Valid";
	public static final String TOTAL_PRICE = "Total Price";
	public static final String TOTAL_PAID = "Total Paid";
	public static final String CHANGE_AMOUNT = "Change Amount";
	
	
	//should be able to purchase multiple items
	private HashMap<Item, Integer> items;
	private Date saleDate;
	private Payment payment;
	private HashMap<String, String> saleDetails;
	private boolean paidInFull;
	
	/***** Constructors *****/
	
	/**
	 * 
	 */
	public Sale() {
		saleDetails = new HashMap<String, String>();
		items = new HashMap<Item, Integer>();
	}
	
	/**
	 * @param items
	 * @param saleDate
	 * @param payment
	 */
	public Sale (HashMap<Item, Integer> items, Date saleDate, Payment payment, String paymentType) {
		this();
		if (items != null) {
			this.items = items;
		}
		if (saleDate != null) {
			this.saleDate = saleDate;
		}
		if (payment != null && paymentType != null) {
			saleDetails.put(PAYMENT_TYPE, paymentType);
			this.payment = payment;
		}
	}
	/**
	 * @param item
	 * @param saleDate
	 * @param payment
	 * @param numberSold
	 */
	public Sale(Item item, Date saleDate, Payment payment, int numberSold, String paymentType ) {
		this();
		if (item != null) {			
			items.put(item, numberSold);
		}
		if (saleDate != null) {
			this.saleDate = saleDate;
		}
		if (payment != null && paymentType != null) {
			saleDetails.put(PAYMENT_TYPE, paymentType);
			this.payment = payment;
		}
	}
	
	/***** Setters *****/
	/**
	 * @param saleDate
	 */
	public void setSaleDate(Date saleDate) {
		if(saleDate != null) {
			this.saleDate = saleDate;
		}
	}
	/**
	 * @param payment
	 */
	public void setPayment(Payment payment) {
		if (payment != null) {
			this.payment = payment;
		}
	}
	/**
	 * @param items
	 */
	public void setItemsSold(HashMap<Item, Integer> items) {
		if(items != null) {
			this.items = items;
		}
	}
	/**
	 * @param attribute
	 * @param value
	 */
	public void setDetail(String attribute, String value) {
		if (attribute != null) {
			saleDetails.put(attribute, value);
		}
	}
	/**
	 * @param item
	 * @param numberSold
	 */
	public void setNumberSold(Item item, int numberSold) {
		items.put(item, numberSold);
	}
	
	/***** Getters *****/
	/**
	 * @return
	 */
	public Date getSaleDate() {
		return this.saleDate;
	}
	/**
	 * @return
	 */
	public HashMap<Item, Integer> getItemsSold() {
		return this.items;
	}
	/**
	 * @return
	 */
	public Payment getPaymentMethod() {
		return this.payment;
	}
	
	/**
	 * @param attribute
	 * @return
	 */
	public String getValueForKey(String attribute) {
		return saleDetails.get(attribute);
	}
	
	/***** Other *****/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return saleDetails.toString();
	}
	/**
	 * @param attribute
	 * @return
	 */
	public boolean containsKey(String attribute) {
		return saleDetails.containsKey(attribute);
	}
	/**
	 * @param value
	 * @return
	 */
	public boolean containsValue(String value) {
		return saleDetails.containsValue(value);
	}
	/**
	 * @return
	 */
	public boolean validatePayment(){
		double totalPrice = calculateTotalPrice();
		double totalPaid = calculateTotalPaid();
		
		if (totalPaid < 0){
			System.err.println("***** Payment Verification Failed *****\n\t\t totalPaid = "+totalPaid);			
		} else {
			if (totalPrice == totalPaid){
				saleDetails.put(CHANGE_AMOUNT, "0.0");
				saleDetails.put(PAYMENT_VERIFIED, ""+true);
				paidInFull = true;
				return true;
			} else if (totalPrice < totalPaid){
				saleDetails.put(CHANGE_AMOUNT, ""+(totalPaid - totalPrice));
				paidInFull = true;
				saleDetails.put(PAYMENT_VERIFIED, ""+true);
				return true;
			} else {
				paidInFull =false;
				if ()
			}
			
		}		
	}
	
	/***** Private *****/
	/**
	 * @return
	 */
	private double calculateTotalPrice(){
		Set<Item> itemSet = items.keySet();
		double totalCost = 0;
		
		for (Item items : itemSet){
			totalCost += (double)Double.parseDouble(items.getValueForKey(Item.PRICE));
		}
		saleDetails.put(TOTAL_PRICE, ""+totalCost);
		return totalCost;
	}
	/**
	 * @return
	 */
	private double calculateTotalPaid(){
		double totalPaid = -1;		
		String paymentType = saleDetails.get(PAYMENT_TYPE);
		
		if (paymentType.equals(MULTIPLE_PAYMENT_TYPES)){
			totalPaid += payment.getValueForKey(Payment.CARD_PAYMENT);
			totalPaid += payment.getValueForKey(Payment.CASH_PAYMENT);
			totalPaid += payment.getValueForKey(Payment.CHECK_PAYMENT);
		} else {
			totalPaid += payment.getValueForKey(paymentType);
		}
		saleDetails.put(TOTAL_PAID,""+totalPaid);
		return totalPaid;
	}

}
