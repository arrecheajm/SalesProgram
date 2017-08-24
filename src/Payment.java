import java.util.HashMap;

public class Payment {
	private HashMap<String, Double>details;
	
	
	/***** Constructors *****/
	
	public Payment() {
		details = new HashMap<String, Double>();
	}
	
	public Payment(HashMap<String, Double> details) {
		if (details != null) {
			this.details = details;
		}
	}
	
	public Payment(String type, Double value) {
		this();
		details.put(type, value);
	}
	
	/***** Setters *****/
	public void setAttribute(String attribute, Double value) {
		details.put(attribute, value);
	}
	
	/***** Getters *****/
	public Double getValueForKey(String attribute) {
		return details.get(attribute);
	}
	
	/***** Other *****/
	@Override
	public String toString() {
		return details.toString();
	}
	public boolean containsKey(String attribute) {
		return details.containsKey(attribute);
	}
	public boolean containsValue(Double value) {
		return details.containsValue(value);
	}
	
	/***** Private *****/
	
}
