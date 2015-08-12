package xuanzuo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xuanzuo.dao.ISeatDAO;
import xuanzuo.vo.Seat;

public class SeatDAOImpl implements ISeatDAO{

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public SeatDAOImpl(Connection conn){
		this.conn=conn;
	}
	
	@Override
	public void getSeatState(Seat seat) throws Exception {
		// TODO Auto-generated method stub
		String sql="select seatstate,name,department from seat where seatrow=? and seatcolumn=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seat.getSeatRow());
		this.pstmt.setInt(2, seat.getSeatColumn());
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			seat.setSeatState(rs.getInt(1));
			seat.setName(rs.getString(2));
//			System.out.println(rs.getString(2));
			seat.setDepartment(rs.getString(3));
		}
	}

	@Override
	public int orderSeat(Seat seat) throws Exception {
		// TODO Auto-generated method stub
		int result=0;
		if(seat.getSeatState()!=0){
			return result;
		}
		String sql="update seat set seatstate=1 ,name=?,department=?where seatrow=? and seatcolumn=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, seat.getName());
		this.pstmt.setString(2,seat.getDepartment());
		this.pstmt.setInt(3, seat.getSeatRow());
		this.pstmt.setInt(4, seat.getSeatColumn());
		result= this.pstmt.executeUpdate();
		return result;
	}
	

}
