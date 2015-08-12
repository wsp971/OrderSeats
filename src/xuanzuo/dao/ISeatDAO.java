package xuanzuo.dao;
import xuanzuo.vo.Seat;
public interface ISeatDAO {
	public void getSeatState(Seat seat) throws Exception;
	public int orderSeat(Seat seat) throws Exception;
	
	
}
