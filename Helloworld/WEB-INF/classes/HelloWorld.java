import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet{
	public void doGet(HttpServletRequest request,
		HttpServletResponse response)
	throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>?????</title>");
		out.println("</head");
		out.println("<body>");
		out.println("my first servlet");
		out.println("</body");
		out.println("</html");
		RequestDispatcher rd=request.getRequestDispatcher("/namaste1");  
		rd.include(request, response);

	}
}
