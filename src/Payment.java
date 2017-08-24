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
	
	/***** Getters *****/
	
	/***** Other *****/
	
	/***** Private *****/
	
}
