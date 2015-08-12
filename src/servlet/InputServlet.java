package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class InputServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		String info=req.getParameter("info");
		PrintWriter out;
		
		try {
			JSONObject json = new JSONObject();
			json.put("username", info);
			json.put("age", 190);
			out = resp.getWriter();
			out.println(json);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		this.doGet(req, resp);
	}
	
	
	
	
}
