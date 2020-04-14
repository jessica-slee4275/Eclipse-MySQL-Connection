import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJDBC {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		testConnect();
		
		testDatabase();
	}
	
	public static void testConnect() {
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pw = "root";
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drive Search Success");
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("Connection Success" + conn);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Drive Search Fail");
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pw = "root";
		Connection conn = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,pw);
		System.out.println("Connected");
		return conn;
	}
	public static void testDatabase() throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		String sql = "SELECT * FROM Persons";
		ResultSet rs = null;
		Statement stmt = null;
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String id = rs.getString(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String address = rs.getString(4);
			String city = rs.getString(5);
			
			System.out.println("[" + id + "] " + firstName + " " + lastName + " - " + address + ", " + city);
		}
		if(rs != null)rs.close();
		if(stmt != null)stmt.close();
		if(conn != null)conn.close();
	}
}
