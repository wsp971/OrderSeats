package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.println("<html>");
			out.println("<head><title>test</title></head>");
			out.println("<body>");
			out.println("<h1>hello world</h1");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
}
