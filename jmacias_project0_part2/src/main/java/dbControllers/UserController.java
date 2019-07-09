package dbControllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.User;
import dataAccessObjects.UserDAO;
import service.ConnectionFactory;

public class UserController implements UserDAO {

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User newUser) {
		// 1. connection
				try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
					// 2. create the statement
					String sql = "INSERT INTO AppUser(u_name, u_password, u_role)"
							+ "VALUES (?, ?, ?)";
					// TODO also need to add table offers with fk to hold values in car object arrLst
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, newUser.getName());
					stmt.setString(2, newUser.getPassword());
					stmt.setString(3, newUser.getRole());
					
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

}
