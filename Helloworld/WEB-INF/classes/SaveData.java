import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SaveData{
	public void sData(String firstname, String lastname, String email, String password){
		String ufirstname = firstname;
		String ulastname = lastname;
		String uemail = email;
		String upass = password;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			Statement stmt = cn.createStatement();

			try{
				String dbase = "CREATE DATABASE surya";
				stmt.executeUpdate(dbase);
				throw new Exception();
			}catch(Exception e){
				System.out.println("Checking Database...");
			}
			String udbase = "USE surya";
			stmt.executeUpdate(udbase);

			try{
				String table = "CREATE TABLE userdata (firstname varchar(40), lastname varchar(40), email varchar(40) NOT NULL PRIMARY KEY, password varchar(40))";
				stmt.executeUpdate(table);
				throw new Exception();
			}catch(Exception e){
				System.out.println("Checking table...");
			}


			String sql = "INSERT INTO userdata VALUES ('"+ufirstname+"','"+ulastname+"','"+uemail+"','"+upass+"')";
			stmt.executeUpdate(sql);

		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}