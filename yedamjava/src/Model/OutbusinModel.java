package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.OutbusinBean;
import Dao.OutlistDao;

public class OutbusinModel {
	private OutbusinBean bean;
	private OutlistDao dao;
	private ResultSet rs;
	
	public void outbusinList() {
		dao = new OutlistDao();
		bean = new OutbusinBean();
		rs = dao.out_bname();
		
		System.out.println("판매할 업체 정보");
		System.out.println("업체코드\t업체명\t주소\t연락처\t대표자명");
		
		try {
			if(rs.next()) {
				bean.setBusin_code(rs.getString(1));
				bean.setBusin_name(rs.getString(2));
				bean.setBusin_addr(rs.getString(3));
				bean.setBusin_num(rs.getString(4));
				bean.setCeo(rs.getString(5));
				System.out.println(busin_code + "\t" + busin_name + "\t" + busin_addr +"\t" + busin_num + "\t" + ceo );
			
			} else System.out.println("선택한 업체가 없습니다.");
		} catch (SQLException e) {
	         e.printStackTrace();
	      }
	}
}
	