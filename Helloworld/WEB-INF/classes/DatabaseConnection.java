import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection{
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/csit_fourth","kesharpaudel","keshar2908");
			System.out.println("Connected!");
			return cn;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args){
		getConnection();
	}
}