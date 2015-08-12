package xuanzuo.dao.proxy;

import xuanzuo.dao.ISeatDAO;
import xuanzuo.dao.impl.SeatDAOImpl;
import xuanzuo.dbc.DatabaseConnection;
import xuanzuo.vo.Seat;

public class SeatDAOProxy implements ISeatDAO {

	private DatabaseConnection dbc=null;
	private ISeatDAO dao=null;
	public SeatDAOProxy (){
		try {
			this.dbc=new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao=new SeatDAOImpl(this.dbc.getConnection());
	}
	
	@Override
	public void getSeatState(Seat seat) throws Exception {
		// TODO Auto-generated method stub
//		int flag=0;
		
		try {
			this.dao.getSeatState(seat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally{
			this.dbc.close();
		}
//		return flag;
		
	}

	@Override
	public int orderSeat(Seat seat) throws Exception {
		// TODO Auto-generated method stub
		int result=0;
		try {
			result=this.dao.orderSeat(seat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return result;
	}
	
	
}
