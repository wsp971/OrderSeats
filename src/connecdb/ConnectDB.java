package connecdb;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConnectDB {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/seat";
	public static final String DBUSER="root";
	public static final String DBPASS="wangshi";
	public static void main(String args[]){
		Connection conn=null;
		java.sql.PreparedStatement pstmt=null;
		
		String sql="insert into seat(seatrow,seatcolumn,seatstate)"
				+"values(?,?,?)";
//		String sql="insert into test(name) values('王世平')";
		
		
		
		
		
		try {
			Class.forName(DBDRIVER);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 conn= (Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=1;i<=16;i++){
				for(int j=1;j<=18;j++){
					pstmt.setInt(1, i);
					pstmt.setInt(2, j);
					pstmt.setInt(3, 0);
					pstmt.execute();
				}
			}
//			pstmt.execute();
			pstmt.close();
			conn.close();
			System.out.println("插入数据成功");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
