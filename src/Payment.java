import java.util.HashMap;

public class Payment {
	public static final String CASH_PAYMENT = "Cash Payment";
	public static final String CARD_PAYMENT = "Card Payment";
	public static final String CHECK_PAYMENT = "Check Payment";
	
	private HashMap<String, Double>details;	
	
	
	/***** Constructors *****/
	
	/**
	 * 
	 */
	public Payment() {
		details = new HashMap<String, Double>();
	}
	
	/**
	 * @param details
	 */
	public Payment(HashMap<String, Double> details) {
		if (details != null) {
			this.details = details;
		}
	}
	public Payment(String paymentType){
		this();
		if (paymentType != null){
			details.put(Sale.PAYMENT_TYPE, paymentType);
		}
	}
	
	/**
	 * @param type
	 * @param value
	 */
	public Payment(String type, Double value) {
		this();
		details.put(type, value);
	}
	
	/***** Setters *****/
	
	/**
	 * @param attribute
	 * @param value
	 */
	public void setAttribute(String attribute, Double value) {
		details.put(attribute, value);
	}
	
	/***** Getters *****/
	
	/**
	 * @param attribute
	 * @return
	 */
	public Double getValueForKey(String attribute) {
		return details.get(attribute);
	}
	public 
	
	/***** Other *****/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return details.toString();
	}
	/**
	 * @param attribute
	 * @return
	 */
	public boolean containsKey(String attribute) {
		return details.containsKey(attribute);
	}
	/**
	 * @param value
	 * @return
	 */
	public boolean containsValue(Double value) {
		return details.containsValue(value);
	}
	
	/***** Private *****/
	
}
