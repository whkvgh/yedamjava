package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class inBusinDao {
	
	static Connection conn = null;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	public inBusinDao() {
		try {
			
			String user ="item";
			String pw = "item";
			String url = "jdbc:oracle:thin:@192.168.0.56:1521:xe";

		    Class.forName("oracle.jdbc.driver.OracleDriver");        
		    conn = DriverManager.getConnection(url, user, pw);
		         
		    System.out.println("Database에 연결되었습니다.\n");
		}catch (Exception e) {
	         e.printStackTrace();
	    }
	}
	
	public ResultSet busin_name() {
		
		String sql = "select * from in_busin";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/*public void insert_in() {
		
		try {
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/
	
	
}
