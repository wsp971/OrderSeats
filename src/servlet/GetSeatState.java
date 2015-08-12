package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import xuanzuo.factory.DAOFactory;
import xuanzuo.vo.Seat;

public class GetSeatState extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
//		List<Seat> seats=new List()<Seat>;
		JSONObject jsonObj=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		PrintWriter out;
		resp.setContentType("text/text;charset=GBK");
		
		for(int i=1;i<=16;i++){
			for(int j=1;j<=18;j++){
				Seat seat=new Seat();
				seat.setSeatRow(i);
				seat.setSeatColumn(j);
				try {
					DAOFactory.getSeatDAOInstance().getSeatState(seat);
//					seat.setSeatState(seatState);
					jsonArray.add(seat);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		jsonObj.element("seatState", jsonArray);
		try {
			
			out = resp.getWriter();
			out.println(jsonArray);
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		this.doGet(req, resp);
	}

}
