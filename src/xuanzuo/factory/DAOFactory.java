package xuanzuo.factory;

import xuanzuo.dao.ISeatDAO;
import xuanzuo.dao.proxy.SeatDAOProxy;

public class DAOFactory {
	public static ISeatDAO getSeatDAOInstance(){
		return new SeatDAOProxy();
	}
}
