package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	private Connection conn;

	public Connection getConn() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			if(conn==null){
				conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.106:1523:TEST","apps","apps");
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void closeConn() throws SQLException{
		if(conn!=null){
			conn.close();
			conn = null;
		}
	}
	
	

}
