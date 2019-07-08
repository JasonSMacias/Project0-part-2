package dbControllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Car;
import dataAccessObjects.CarDAO;
import service.ConnectionFactory;

public class CarController implements CarDAO {

	@Override
	public void addCar(Car car) {
		// 1. connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// 2. create the statement
			String sql = "INSERT INTO Car(car_id, make_and_model, price)"
					+ "VALUES (?, ?, ?)";
			// TODO also need to add table offers with fk to hold values in car object arrLst
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, car.getNumber());
			stmt.setString(2, car.getMakeAndModel());
			stmt.setInt(3, car.getPrice());
			
			// 3. Execute
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Rows insterted: " + rowsAffected);
			
			// Maybe this should return the car object?
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with creating car in db.");
			
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
		}

	}

	@Override
	public Car getCar(int carId) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT car_id, make_and_model, price"
					+ " FROM Car"
					+ " Where car_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, carId);
			
			// execute query
			ResultSet results = stmt.executeQuery();
			System.out.println(results);
			
			// iterate through results and return 
			Car car = null;
			while (results.next()) {
				int carId2 = results.getInt("car_id");
				String makeAndModel = results.getString(2);
				int price = results.getInt("price");
				car = new Car(makeAndModel, price, carId2);
			}
			return car;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the car from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

	@Override
	public Car overwriteCar(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCar(Car car) {
		// TODO Auto-generated method stub
		
	}

}
