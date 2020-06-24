package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseDemo {

	// Connection Object
	static Connection con = null;

	// Statement Object
	static Statement stat = null;

	// Result Set
	static ResultSet results = null;

	// DataBase url
	static String sDBUrl = "jdbc:mysql://localhost:3306/world"; // ORACLE: "jdbc:oracle:thin:@localhost:1521:xe"

	// DB user name
	static String sUser = "root";

	// DB user name
	static String sPWD = "Apple@123";

	static String sDriver = "com.mysql.cj.jdbc.Driver"; 
	// OLD MySQL: "com.mysql.jdbc.Driver";
	// ORACLE: oracle.jdbc.driver.OracleDriver

	public static void connectDB() {

		try {
			// Step1: Register JDBC driver
			Class.forName(sDriver).newInstance();

			// Step 2: Connect to DB using Connection Object
			con = DriverManager.getConnection(sDBUrl, sUser, sPWD);

			// Step 3: Create statement
			stat = con.createStatement();

			//String sQuery = "SELECT * FROM world.city where Population < 100000";
			String sQuery = "SELECT * FROM world.city where ID = 3193";

			results = stat.executeQuery(sQuery);

			while (results.next()) {
				int id = results.getInt("ID");
				//int id =  (Integer) results.getObject("ID");
				
				String sCityName = results.getString("Name");
				
				System.out.println("City ID: " + id);
				System.out.println("City Name: " + sCityName);
			}
			
			results.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				
				if (con != null) {
					con.close();
				}
				
				if (stat != null) {
					stat.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		connectDB();

	}

}
