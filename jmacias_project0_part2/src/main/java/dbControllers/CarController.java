package dbControllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import beans.Car;
import dataAccessObjects.CarDAO;
import service.ConnectionFactory;

public class CarController implements CarDAO {

	@Override
	public void addCar(Car car) {
		// 1. connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// 2. create the statment
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
			
			// create car 
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with creating monster in db.");
			
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}

	}

	@Override
	public Car getCar(Car newCar) {
		// TODO Auto-generated method stub
		return null;
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
