package Model;

import java.sql.ResultSet;

import Bean.OutbusinBean;
import Dao.OutlistDao;

public class OutbusinModel {
	private OutlistDao dao;
	private OutbusinBean bean;
	private ResultSet rs;
	
	public void outbusin() {
		dao = new OutlistDao();
		bean = new OutbusinBean();
		rs = dao.
		System.out.println("판매할 업체 정보");
		System.out.println("업체코드\t업체명\\t주소\\t연락처\\t대표자명");
	
	}
}
	