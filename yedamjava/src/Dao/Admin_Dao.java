package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_Dao {
	
	static Connection conn = null;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	public Admin_Dao() {

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
	
	public ResultSet in_busin_show() {		// 구매업체
		
		String sql = "select * from in_busin";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet out_busin_show() {		//판매업체
		
		String sql = "select * from out_busin";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet store_list_show() {		//창고정보
		
		String sql = "select * from store_list";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return rs;
	}
	
	public ResultSet item_list_show() {		//품목정보
		
		String sql = "select * from item_list";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return rs;
	}
	
	public ResultSet inout_list_show() {	//입출고내역
		
		String sql = "select sub_group, i_name, nvl(in_count,0), nvl(out_count,0), date_list, store_code, bigo " + 
				" from inout_list";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return rs;
	}
	
	public ResultSet good_list_show() {		//재고정보 
		
		String sql = "select * from good_list";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return rs;
	}
}
