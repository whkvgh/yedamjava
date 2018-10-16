package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.OutlistBean;

public class OutlistDao {
	private Connection conn = null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private CallableStatement pst;
	private OutlistBean bean;
	private int in;
	
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
	public void InsertOutlist(OutlistBean bean) {	//입력
	 String sql = "insert into out_list(sub_group, i_name, i_count, price, money, out_date, busin_code, store_code) " + 
			"  values(?, ?, ?, ?, ?, sysdate, ?, ?)";
	 
	 try {
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, bean.getSub_group());
		 pstmt.setString(2, bean.getI_name());
		 pstmt.setInt(3, bean.getI_count());
		 pstmt.setInt(4, bean.getPrice());
		 pstmt.setInt(5, bean.getMoney());
		 pstmt.setString(6, bean.getBusin_code());
		 pstmt.setString(7, bean.getStore_code());
		 
		 pstmt.executeUpdate();
			
	 } catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void editOutlist() {	//수정
		//String sql = "update out_list set sub_group =?, i_name = ?, i_count = ?, pricdr = ?, money=?, out_date =?, busin_code=?, store_code=?"
		
	}
	
	public void  deleteOutlist() { //삭제
		String sql = " delete from out_list where trunc(out_date) = to_date('?', 'yy/mm/dd') and sell_num= ? and  sub_infor=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getOut_date());
			pstmt.setString(2, bean.getSell_num());
			pstmt.setInt(3, bean.getSub_infor());
			int n = pstmt.executeUpdate();
			
			if (n == 0) System.out.println("삭제를 실패하였습니다");
			else System.out.println("삭제 완료하였습니다.");
			
			}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getOutlist() {	//조회
		String sql = "select * from out_list";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	
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
