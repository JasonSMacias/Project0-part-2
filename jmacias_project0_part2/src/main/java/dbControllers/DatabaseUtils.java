package dbControllers;

import java.io.IOException;
import java.sql.*;

import beans.Car;
import service.ConnectionFactory;

public class DatabaseUtils {
	// TODO place here miscellaneous methods to interact with the db
	// specifically:
	
	// 1. method to get highest id for cars object to allow persistent incrementing in
	//	  Car constructor
	public static int getMaxCarId() throws IOException {
	try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
		// statement
		String sql = "SELECT MAX(car_id)"
				+ " FROM Car";
		Statement stmt = conn.createStatement();
		
		// execute query
		ResultSet results = stmt.executeQuery(sql);
		System.out.println(results);
		
		// iterate through results and return 
		int carId = 0;
		while (results.next()) {
			carId = results.getInt(1);
		}
		return carId;
	}
	catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Something went wrong with retrieving the id from the db.");
		return 0;
	}
}
	
	// 2. method to do join and return offers associated with given car, to be put in
	//    arraylist within car object.
}
