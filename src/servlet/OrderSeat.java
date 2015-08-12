package servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import xuanzuo.factory.DAOFactory;
import xuanzuo.vo.Seat;

public class OrderSeat extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		JSONObject jsonObj=new JSONObject();
		PrintWriter out;
		int seatRow=Integer.parseInt(req.getParameter("seatRow"));
		int seatColumn=Integer.parseInt(req.getParameter("seatColumn"));
		String name=req.getParameter("name");
		String department=req.getParameter("department");
		Seat seat=new Seat();
		seat.setSeatRow(seatRow);
		seat.setSeatColumn(seatColumn);
		seat.setName(name);
		seat.setDepartment(department);
		try {
			out = resp.getWriter();
			int result=DAOFactory.getSeatDAOInstance().orderSeat(seat);
			if(result>0){
				jsonObj.put("errCode", "000");
				jsonObj.put("errMsg", result);
			}else{
				jsonObj.put("errCode", "001");
				jsonObj.put("errMsg","error");
			}
			out.println(jsonObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		this.doGet(req, resp);
	}

}
