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

	public void Outlist() {
		int menu = 0;

		while (true) {
			System.out.println("============출고화면==============");
			System.out.println("상품 출고메뉴에서 관리할 메뉴를 선택하세요  1.입력  2.수정  3.삭제  4.조회  5.종료");

			menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) { // 입력
				bean = new OutlistBean();
				System.out.println("판매할 상품코드를 입력하세요.");
				bean.setSub_group(sc.nextLine());
				System.out.println("판매할 상품명를 입력하세요.");
				bean.setI_name(sc.nextLine());
				System.out.println("판매할 상품수량를 입력하세요.");
				bean.setI_count(sc.nextInt());
				sc.nextLine();
				System.out.println("판매할 상품단가를 입력하세요.");
				bean.setPrice(sc.nextInt());
				sc.nextLine();
				System.out.println("판매할 상품금액를 입력하세요.");
				bean.setMoney(sc.nextInt());
				sc.nextLine();
				System.out.println("판매할 업체를 입력하세요.");
				bean.setBusin_code(sc.nextLine());
				System.out.println("판매할 상품창고를 입력하세요.");
				bean.setStore_code(sc.nextLine());

				dao.InsertOutlist(bean);

			} else if (menu == 2) { // 수정

			} else if (menu == 3) { // 삭제
				dao.deleteOutlist();
				System.out.println("삭제할 출고내역을 입력하세요");

				dao.deleteOutlist();
				System.out.println("삭제할 상품 출고 날자를 입력하세요 ");
				sc.close();

			} else if (menu == 4) { // 판매정보
				rs = dao.getOutlist();
				System.out.println("=========판매 정보======");
				System.out.println("판매번호 \t 라인번호 \t 상품코드 \t 상품명 \t 수량 \t 단가 \t 금액 \t 출고일자 \t 업체코드 \t 입고창고");

				try {
					if (rs.next()) { 
						do {
							bean.setSell_num(rs.getString("sell_num"));
							bean.setSub_infor(rs.getInt("sub_infor"));
							bean.setSub_group(rs.getString("sub_group"));
							bean.setI_name(rs.getString("i_name"));
							bean.setI_count(rs.getInt("i_count"));
							bean.setPrice(rs.getInt("price"));
							bean.setMoney(rs.getInt("money"));
							bean.setOut_date(rs.getString("out_date"));
							bean.setBusin_code(rs.getString("busin_code"));
							bean.setStore_code(rs.getString("store_code"));
							System.out.println(bean);
						} while (rs.next()); //값이 있을때 까지 
						
					} else
						System.out.println("선택한 정보가 없습니다.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (menu == 5) {
				
				System.out.println("다시 빽!");
				break;
			}
//			continue;

		}
	}

}
