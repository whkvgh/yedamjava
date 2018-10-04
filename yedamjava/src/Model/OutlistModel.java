package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Bean.ItemListBean;
import Dao.OutlistDao;

public class OutlistModel {
	private OutlistDao dao;
	private ItemListBean bean;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	public void OutItem() {
		dao = new OutlistDao();
		rs = dao.OutItem();
		if(rs.next()){
			do {
				ItemListBean bean = new ItemListBean();
				System.out.println("판매할 상품명을 입력하세요");
				bean.setSub_group(rs.getString("sub_group"));
				System.out.println("판매할 상품수량을 입력하세요");
				System.out.println("판매할 업체명을 입력하세요");
				bean.setStore_code(rs.getString("busin_code"));
			}while (rs.next());
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
