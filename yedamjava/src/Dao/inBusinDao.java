package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class inBusinDao {
	
	static Connection conn = null;
	static PreparedStatement pstmt;
	static ResultSet rs;
	static CallableStatement pst;
	
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
	
	public void in_list(String name, int count, String busin_name, int cnt, String sign) {
		
		try {
			
			pst = conn.prepareCall("{call in_proc(?,?,?,?,?,?)}");
			pst.setInt(1, cnt);
			pst.setString(2, name);
			pst.setInt(3, count);
			pst.setString(4, busin_name);
			pst.setString(5, sign);
			pst.registerOutParameter(6, java.sql.Types.INTEGER);
			
			pst.execute();
			
			int result = pst.getInt(6);
			
			if(result > 0) {
				System.out.println("성공");
				good_list(name, count, busin_name);
			}else
				System.out.println("입력 실패 ");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void good_list(String name, int count, String busin_name) {
		
		System.out.println(count);
		
		try {
			pst = conn.prepareCall("{call in_goodlist_proc(?, ?, ?, ?)}");
			pst.setString(1, name);
			pst.setInt(2, count);
			pst.setString(3, busin_name);
			pst.registerOutParameter(4, java.sql.Types.INTEGER);
			
			pst.execute();
			
			int result = pst.getInt(4);
			System.out.println("count : " + result);
			if(result > 0) {
				System.out.println("성공");
				in_inout_list(name, count);
			}else
				System.out.println("입력 실패 ");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void in_inout_list(String name, int count) {
		
		try {
			pst = conn.prepareCall("{call in_inoutlist_proc(?, ?, ?)}");
			pst.setString(1, name);
			pst.setInt(2, count);
			pst.registerOutParameter(3, java.sql.Types.INTEGER);
			
			pst.execute();
			

			int result = pst.getInt(3);

			if(result > 0)
				System.out.println("성공");
			else
				System.out.println("입력 실패 ");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	
}
