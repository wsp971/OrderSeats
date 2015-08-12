package connecdb;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.*;
import java.sql.*;

import sun.jdbc.odbc.ee.DataSource;

public class JNDIConnectDB {
	public static void main(String args[]){
		
		String DSNAME="java:comp/env/jdbc/xuanzuo";
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds=(DataSource) ctx.lookup(DSNAME);
			try {
				Connection conn=ds.getConnection();
				System.out.print(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
