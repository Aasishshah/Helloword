import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.sql.*;
public class Signup extends HttpServlet{
	

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		response.setContentType("text/html");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String birthdate=request.getParameter("birthdate");
		String gender=request.getParameter("gender");
		PrintWriter out=response.getWriter();
		//out.println("Firstname is:"+firstname);
		//out.println("Lastname is:"+lastname);
		//out.println("Mobile is:"+mobile);
		//out.println("Email is:"+email);
		//out.println("Birth Date is:"+birthdate);
		//out.println("Gender is: " +gender);

		DatabaseConnection cn=DatabaseConnection.getConnection();
		try{
			
			Statement stat=cn.createStatement();
			String sqlQuery="select *from user_detail";
			ResultSet rs=stat.executeQuery(sqlQuery);
			while(rs.next()){
				String email1=rs.getString("Email");
				if(email.equals(email1)){
				out.println("Email is already use.Try another email");
			}else{
				String sql="INSERT INTO user_detail(First_Name,Last_Name,Mobile,Email,Birth_Date,Password,Gender)VALUES('"+firstname+"','"+lastname+"','"+mobile+"','"+email+"','"+birthdate+"','"+password+"','"+gender+"')";

				stat.executeUpdate(sql);
			//cn.commit();
			//String msg="Record has been inserted";
            //out.println("<font size='6' color=blue>" + msg + "</font>"); 
            	out.println("You are sucessfully Signup!");
        	}
			}
			
		}catch(Exception e){
			e.printStackTrace();

		}

		
	
	}
}
	