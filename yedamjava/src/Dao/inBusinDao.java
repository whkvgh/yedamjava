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
		         
		}catch (Exception e) {
	         e.printStackTrace();
	    }
	
	}
	
	public ResultSet in_list_show() {
		
		String sql = "select * from in_list";
		
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
				good_list(name, count);
			}else
				System.out.println("입력 실패 ");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void good_list(String name, int count) {
		
		try {
			pst = conn.prepareCall("{call in_goodlist_proc(?, ?, ?)}");
			pst.setString(1, name);
			pst.setInt(2, count);
			pst.registerOutParameter(3, java.sql.Types.INTEGER);
			
			pst.execute();
			
			int result = pst.getInt(3);
			System.out.println(result);
			
			if(result > 0) {
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

			System.out.println(result);
			
			if(result > 0)
				System.out.println("성공");
			else
				System.out.println("입력 실패 ");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet inList_getNum(String date, String buy_num) {
		
		String sql = "select * from in_list where buy_num = ? and to_char(in_date, 'yyyymmdd') = to_date(?, 'yyyymmdd')";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, buy_num);
			pstmt.setString(2, date);
			
			rs = pstmt.executeQuery();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public void update_inList(String date, String buy_num, int line, int cnt) {
		
		
		try {
			pst = conn.prepareCall("{call in_list_update(?,?,?,?)}");
			
			pst.setString(1, buy_num);
			pst.setInt(2, line);
			pst.setInt(3, cnt);
			pst.setString(4, date);
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delete_inList(String date, String buy_num, int line) {
		
		
		try {
			pst = conn.prepareCall("{call in_list_delete(?,?,?)}");
			
			pst.setString(1, buy_num);
			pst.setInt(2, line);
			pst.setString(3, date);
			
			pst.execute();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
