package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OutlistDao {
	static Connection conn = null;
	static PreparedStatement pstmt;
	static ResultSet rs;
	static CallableStatement pst;

	public OutlistDao() {
		try {

			String user = "item";
			String pw = "item";
			String url = "jdbc:oracle:thin:@192.168.0.56:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet out_bname() {
		String sql = "select * from out_busin";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void outlist() {
		String sql = "insert into out_list value(?,?,?)";
	}

	public void outgoods(String sub_group, String i_name, int i_count, String store_code) {
		try {
			pst = conn.prepareCall("{call out_pro (?,?,?,?)}");
			pst.setString(1, sub_group);
			pst.setString(2, i_name);
			pst.setInt(3, i_count);
			pst.setString(4, store_code);
			
			pst.execute();
	} catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
	
}
