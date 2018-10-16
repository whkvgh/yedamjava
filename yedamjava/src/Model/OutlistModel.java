package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Bean.OutlistBean;
import Dao.OutlistDao;

public class OutlistModel {
	private ResultSet rs;	
	Scanner sc = new Scanner(System.in);
	OutlistDao dao = new OutlistDao();
	OutlistBean bean = new OutlistBean();
	
	public void insertOutlist () {
		int menu = 0;

		while (true) {
			System.out.println("메뉴를 선택하세요  1.입력  2.수정  3.삭제  4.조회  5.종료");
		
		menu = sc.nextInt();
		sc.nextInt();
		
		if(menu == 1) { //입력
			System.out.println("판매할 상품코드를 입력하세요.");
			bean.setSub_group(sc.nextLine());
			System.out.println("판매할 상품명를 입력하세요.");
			bean.setI_name(sc.nextLine());
			System.out.println("판매할 상품수량를 입력하세요.");
			bean.setI_count(sc.nextInt());
			System.out.println("판매할 상품단가를 입력하세요.");
			bean.setPrice(sc.nextInt());
			System.out.println("판매할 상품금액를 입력하세요.");
			bean.setMoney(sc.nextInt());
			System.out.println("판매할 업체를 입력하세요.");
			bean.setBusin_code(sc.nextLine());
			System.out.println("판매할 상품창고를 입력하세요.");
			bean.setStore_code(sc.nextLine());
			
			dao.InsertOutlist(bean);
		} else if (menu == 2) {	//수정
		 
			
		} else if (menu == 3) {	//삭제
			Scanner sc = new Scanner(System.in);
			OutlistDao dao = new OutlistDao();
			
			dao.deleteOutlist();
			System.out.println("삭제할 상품 출고 날자를 입력하세요 ");
			sc.close();
			
		} else if (menu == 4) {	//판매정보
			System.out.println("=========판매 정보======");
			System.out.println("판매번호\t라인번호\\t상품코드\\t상품명\\t수량\\t단가\\t금액\\t출고일자\\t업체코드\t입고창고");
			
			try {
				while (rs.next()) {
				bean.setBusin_code(rs.getString("busin_code"));	
				bean.setSub_infor(rs.getInt("sub_infor"));
				bean.setSub_group(rs.getString("sub_group"));
				bean.setI_name(rs.getString("i_name"));
				bean.setI_count(rs.getInt("i_count"));
				bean.setPrice(rs.getInt("price"));
				bean.setMoney(rs.getInt("money"));
				bean.setOut_date(rs.getString("out_date"));
				bean.setBusin_code(rs.getString("busin_code"));
				bean.setStore_code(rs.getString("store_code"));
				
				}
			}catch (SQLException e) {
		         e.printStackTrace();
				}
				} 
			else  {
		System.out.println("다시 빽!");
		}
		continue;
		
		

		}
	}
	
	public void updateOutlist() {
		
	}
	
	public void deleteOulist() {
		
		
	}

	public ResultSet getOutlist() {
		// TODO Auto-generated method stub
		return null;
	}
}

