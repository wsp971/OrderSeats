package xuanzuo.dbc;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseConnection {

	private static final String DSNAME="java:comp/env/jdbc/xuanzuo";
	private Connection conn=null;
	public DatabaseConnection() throws Exception {
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup(DSNAME);
			this.conn=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close() throws Exception{
		if(this.conn!=null){
			try {
				this.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
