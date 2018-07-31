import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response)
	throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		out.println(Username);
		out.println(password);
		
	}
}