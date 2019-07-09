package dataAccessObjects;

import beans.Payment;

public interface PaymentDAO {
	public Payment getPayment(int userId);
	 
	public void addPayment(Payment newPayment);
}
