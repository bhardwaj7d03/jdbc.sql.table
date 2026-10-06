package jdbbp2;
import java.util.Scanner;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class jdbcapp4w {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/maybatch";
		String username = "root";
		String password = "";
		
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			Scanner sc = new Scanner(System.in);
			
			while (true) {
				System.out.print("Enter employee ID: ");
				int eid = sc.nextInt();
				sc.nextLine(); // Consume newline left-over
				System.out.print("Enter employee name: ");
				String ename = sc.nextLine();
				System.out.print("Enter employee salary: ");
				int sal = sc.nextInt();
				sc.nextLine(); // Consume newline left-over
				
				String query = "INSERT INTO newemp (eid, ename, sal) VALUES (" + eid + ", '" + ename + "', " + sal + ")";
				int i = statement.executeUpdate(query);
				System.out.println("Record inserted successfully, rows affected: " + i);
				System.out.print("Do you want to insert another record? (yes/no): ");
				String choice = sc.nextLine();
				if (!choice.equalsIgnoreCase("yes")) {
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}