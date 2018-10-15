package Model;

import java.util.Scanner;
import Bean.OutlistBean;
import Dao.OutlistDao;

public class OutlistModel {
	Scanner sc = new Scanner(System.in);
	OutlistBean bean = new OutlistBean();

				
	public void insertOutlist () {
		try{ 
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
			sc.close();
			
			return;
			
		} finally {
			sc.close();
		}
	}
	
	public void updateOutlist() {
		
	}
	
	public void deleteOulist() {
		Scanner sc = new Scanner(System.in);
		OutlistDao dao = new OutlistDao();
		
		dao.deleteOutlist();
		System.out.println("삭제할 상품 출고 날자를 입력하세요 ");
		sc.close();
		
	}
}

