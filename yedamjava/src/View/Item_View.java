package View;

import java.sql.ResultSet;
import java.sql.SQLException;


import Bean.InBusinBean;
import Bean.ItemListBean;
import Bean.OutbusinBean;
import Bean.StoreListBean;
import Dao.Admin_Dao;

public class Item_View {
	ResultSet rs;
	Admin_Dao dao = new Admin_Dao();
	
	public void in_busin() {		//in_busin 출력화면 

		InBusinBean bean;
		rs = dao.in_busin_show();

		System.out.println("===================================구입할 업체=========================================");
		System.out.println("업체코드 \t\t 업체명\t 주소\t\t\t 연락처\t\t 대표자명");
		System.out.println("===================================================================================");
		
		try {
			while(rs.next()) {
				bean = new InBusinBean();
				bean.setBusin_code(rs.getString(1));
				bean.setBusin_name(rs.getString(2));
				bean.setBusin_addr(rs.getString(3));
				bean.setBusin_num(rs.getString(4));
				bean.setCeo(rs.getString(5));	
				System.out.println(bean.getBusin_code() + " \t" + bean.getBusin_name() + " \t" + bean.getBusin_addr()
									+ " \t" + bean.getBusin_num() + " \t" + bean.getCeo());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("===================================================================================");
		
	}
	
	public void out_list() {
		OutbusinBean bean;
		rs = dao.out_busin_show();
		System.out.println("===================================구입할 업체=======================================");
		System.out.println("업체코드 \t\t 업체명\t 주소\t\t\t 연락처\t\t 대표자명");
		System.out.println("===================================================================================");
		try {
			while(rs.next()) {
				bean = new OutbusinBean();
				bean.setBusin_code(rs.getString(1));
				bean.setBusin_name(rs.getString(2));
				bean.setBusin_addr(rs.getString(3));
				bean.setBusin_num(rs.getString(4));
				bean.setCeo(rs.getString(5));
				System.out.println(bean.getBusin_code() + " \t" + bean.getBusin_name() + " \t" + bean.getBusin_addr()
									+ " \t" + bean.getBusin_num() + " \t" + bean.getCeo());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("===================================================================================");
		
	}
	
	public void store_list() {
		StoreListBean bean;
		rs = dao.store_list_show();
		
		System.out.println("창고코드 \t 창고명\t 설명");
		
		try {
			while(rs.next()) {
				bean = new StoreListBean();
				bean.setStore_code(rs.getString(1));
				bean.setStore_name(rs.getString(2));
				bean.setExpla(rs.getString(3));
				
				System.out.println(bean.getStore_code() + "\t " + bean.getStore_name() + "\t " + bean.getExpla());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void item_list() {
		ItemListBean bean;
		rs = dao.item_list_show();
		
		System.out.println("분류코드 \t 상품코드\t 상품명 \t 규격 \t 단위\t 창코코드\t 단가");
		
		try {
			while(rs.next()) {
				bean = new ItemListBean();
				bean.setI_group(rs.getString(1));
				bean.setSub_group(rs.getString(2));
				bean.setI_name(rs.getString(3));
				bean.setI_size(rs.getString(4));
				bean.setUnit(rs.getInt(5));
				bean.setStore_code(rs.getString(6));
				bean.setPrice(rs.getInt(7));
				
				System.out.println(bean.getI_group() +"\t " + bean.getSub_group() +"\t " + bean.getI_name() +"\t " + bean.getI_size()
									+ "\t " + bean.getUnit() + "\t " + bean.getStore_code() +"\t " + bean.getPrice());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inout_list() {
		
	}
	
}
