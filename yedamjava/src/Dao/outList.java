package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Bean.ItemListBean;

public class outList {
	static Connection conn = null;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	public void db_con() {
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

	public void ItemOut() {
		Scanner sc  = new Scanner(System.in);
		ItemListBean item = new ItemListBean();
		
		item.
		System.out.println("=================");
		System.out.println("출고할 품목을 선택하세요");
		String n = sc.nextLine();
		sc.close();
		
	}
}
