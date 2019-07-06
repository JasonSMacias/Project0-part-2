package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {
	/**
	 * Generated serialverionuid
	 */
	private static final long serialVersionUID = 3987990158017823409L;
	
	public static int count = 0; // use method in dbutils to start this at highest current count, so that numbering will be continuous within sessions
	public int number;
	public String makeAndModel;
	public int price;
	public List<String> offers;
	public Car(String makeAndModel, int price) {
		super();
		count++;
		this.number = count;
		this.makeAndModel = makeAndModel;
		this.price = price;
		this.offers = new ArrayList<String>();
	}
	

}
