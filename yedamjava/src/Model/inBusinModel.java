package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Bean.InListBean;
import Bean.OutbusinBean;
import Dao.inBusinDao;
import View.Item_View;

public class inBusinModel {
	
	Item_View view;
	inBusinDao dao;
	
	public void in_list() {
		dao = new inBusinDao();
		ResultSet rs = dao.in_list_show();
		InListBean bean;
		
		System.out.println("구매번호" + "\t " + "라인번호" + "\t " + "상품코드" + "\t " + "상품명" + "\t " + "수량" + "\t "
							+ "단가" + "\t " + "금액" + "\t\t\t" + "입고일자" + "\t\t\t" + "업체코드" + "\t " + "입고창고");
		
		try {
			while(rs.next()) {
				bean = new InListBean();
				bean.setBuy_num(rs.getString(1));
				bean.setSub_info(rs.getInt(2));
				bean.setSub_group(rs.getString(3));
				bean.setI_name(rs.getString(4));
				bean.setI_count(rs.getInt(5));
				bean.setPrice(rs.getInt(6));
				bean.setMoney(rs.getInt(7));
				bean.setIn_date(rs.getString(8));
				bean.setBusin_code(rs.getString(9));
				bean.setStore_code(rs.getString(10));
				
				System.out.println(bean.getBuy_num() + " \t " + bean.getSub_info() + " \t " + bean.getSub_group()
									+ "\t " + bean.getI_name() + " \t" + bean.getI_count() + "\t " + bean.getPrice()
									+ "\t " + bean.getMoney() + " \t\t " + bean.getIn_date() + "\t " + bean.getBusin_code()
									+ "\t " + bean.getStore_code());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert_busin() {
		
		view = new Item_View();
		view.in_busin();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("구입할 업체를 입력하세요.");
		System.out.print("업체명 : ");
		String name = scan.nextLine();

		InlistModel model = new InlistModel();
		model.input_list(name);
		
		scan.close();
	}
	
	public void update_busin() {
		
		dao = new inBusinDao();
		InListBean bean;
		
		in_list();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("찾을 날짜를 입력하세요: ");
		String date = scan.nextLine();
		
		System.out.print("수정할 구매번호 :");
		String buy_num = scan.nextLine();
				
		ResultSet rs = dao.inList_getNum(date ,buy_num);
		
		try {
			while(rs.next()) {
				bean = new InListBean();
				bean.setBuy_num(rs.getString(1));
				bean.setSub_info(rs.getInt(2));
				bean.setSub_group(rs.getString(3));
				bean.setI_name(rs.getString(4));
				bean.setI_count(rs.getInt(5));
				bean.setPrice(rs.getInt(6));
				bean.setMoney(rs.getInt(7));
				bean.setIn_date(rs.getString(8));
				bean.setBusin_code(rs.getString(9));
				bean.setStore_code(rs.getString(10));
				
				System.out.println(bean.getBuy_num() + " \t " + bean.getSub_info() + " \t " + bean.getSub_group()
									+ "\t " + bean.getI_name() + " \t" + bean.getI_count() + "\t " + bean.getPrice()
									+ "\t " + bean.getMoney() + " \t\t " + bean.getIn_date() + "\t " + bean.getBusin_code()
									+ "\t " + bean.getStore_code());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.print("라인번호 입력 : ");
		int line = scan.nextInt();
		scan.nextLine();
		
		System.out.print("수랑 :");
		int cnt = scan.nextInt();
		scan.nextLine();
		
		dao.update_inList(date, buy_num, line, cnt);
		
		scan.close();
		
	}
	
	
	
}
