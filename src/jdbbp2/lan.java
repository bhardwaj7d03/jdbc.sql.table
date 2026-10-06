package jdbbp2;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class lan {

	public static void main(String[] args) {
		// Database connection parameters
		String url = "jdbc:mysql://localhost:3306/maybatch";
		String username = "root";
		String password = ""; // Empty password - change if needed
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			// Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL Driver loaded successfully!");
			
			// Establish connection
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to database successfully!");
			
			statement = connection.createStatement();
			
			// Drop table if exists (for re-running the program)
			String dropQuery = "DROP TABLE IF EXISTS newemp";
			statement.executeUpdate(dropQuery);
			System.out.println("Old table dropped (if existed)");
			
			// Create table with proper MySQL syntax
			String query = "CREATE TABLE newemp(" +
					"eid INT(4), " +
					"ename VARCHAR(20), " +
					"sal INT(7))";
			statement.executeUpdate(query);
			System.out.println("Table 'newemp' created successfully!");
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("ERROR: MySQL Driver not found!");
			System.out.println("Solution: Add mysql-connector-java to your project classpath");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("ERROR: Database Connection Failed!");
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("SQL State: " + e.getSQLState());
			System.out.println("Message: " + e.getMessage());
			
			// Common connection issues
			if(e.getMessage().contains("Unknown database")) {
				System.out.println("Solution: Database 'maybatch' does not exist. Create it first.");
			}
			else if(e.getMessage().contains("Access denied")) {
				System.out.println("Solution: Check username and password. Current: username='root', password=''");
			}
			else if(e.getMessage().contains("connection refused")) {
				System.out.println("Solution: MySQL server is not running. Start MySQL service.");
			}
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("ERROR: Unexpected error occurred!");
			e.printStackTrace();
		}
		finally {
			// Close resources in reverse order
			try {
				if(statement != null) {
					statement.close();
					System.out.println("Statement closed");
				}
				if(connection != null) {
					connection.close();
					System.out.println("Connection closed");
				}
			}
			catch (SQLException e) {
				System.out.println("ERROR: Failed to close resources");
				e.printStackTrace();
			}
		}
	}
}
