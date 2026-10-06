package jdbbc4;
import java.sql.Connection;
import java.sql.DriverManager;



public class lncgr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Load the MySQL JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println(con);

	}
		catch (Exception e) {
			e.printStackTrace();
		}

}
}
