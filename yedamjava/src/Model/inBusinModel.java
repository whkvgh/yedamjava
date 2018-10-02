package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Bean.InBusinBean;
import Dao.inBusinDao;

public class inBusinModel {
	
	public void inBusin_list() {
		inBusinDao dao = new inBusinDao();
		InBusinBean bean = new InBusinBean();
		System.out.println("====================구입할 업체====================");
		
		System.out.println("업체코드 \t\t 업체명\t 주소\t\t\t 연락처\t\t 대표자명");
		ResultSet rs = dao.busin_name();
		
		try {
			while(rs.next()) {
				bean.setBusin_code(rs.getString(1));
				bean.setBusin_name(rs.getString(2));
				bean.setBusin_addr(rs.getString(3));
				bean.setBusin_num(rs.getString(4));
				bean.setCeo(rs.getString(5));
				
				System.out.println(bean.getBusin_code() + " \t" + bean.getBusin_name() + " \t" + bean.getBusin_addr()
									+ " \t" + bean.getBusin_num() + " \t" + bean.getCeo());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("===============================================");
		insert_busin();
		
	}
	
	public void insert_busin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("구입할 업체를 입력하세요.");
		System.out.print("업체명 : ");
		String name = scan.nextLine();
		
		InlistModel model = new InlistModel();
		model.input_list(name);
		
	}
}
