package View;

import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.InBusinBean;
import Dao.Admin_Dao;

public class Item_View {
	

	public void in_busin() {		//in_busin 출력화면 
		Admin_Dao dao = new Admin_Dao();
		InBusinBean bean = new InBusinBean();
		ResultSet rs = dao.in_busin_show();

		System.out.println("====================구입할 업체====================");
		System.out.println("업체코드 \t\t 업체명\t 주소\t\t\t 연락처\t\t 대표자명");
		
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("================================================");
	}
	
	public void out_list() {
		
	}
	
}
