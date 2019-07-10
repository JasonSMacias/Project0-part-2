package dbControllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Payment;
import dataAccessObjects.PaymentDAO;
import service.ConnectionFactory;

public class PaymentController implements PaymentDAO {

	@Override
	public Payment getPayment(int userId) {
		// TODO Auto-generated method stub
		System.out.println("Getting payment");
		return null;
	}

	@Override
	public void addPayment(Payment newPayment) {
		// TODO Auto-generated method stub
		System.out.println("Adding payment");
	}

	@Override
	public List<Payment> getPayments() {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT payments_left, no_paid, car_number, buyer_name"
					+ " FROM CarPayment";
			Statement stmt = conn.createStatement();
			
			// execute query
			ResultSet results = stmt.executeQuery(sql);
			System.out.println(results);
			
			// iterate through results and return 
			List<Payment> payments = new ArrayList<>();
			while (results.next()) {
				int paymentsLeft = results.getInt("payments_left");
				int amountPaid = results.getInt("no_paid");
				int carNumber = results.getInt("car_number");
				String buyerName = results.getString("buyer_name");
				Payment payment = new Payment(carNumber, buyerName);
				payments.add(payment);
			}
			
			return payments;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the payments from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

}
