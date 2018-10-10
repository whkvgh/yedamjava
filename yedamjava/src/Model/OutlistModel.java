package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Bean.ItemListBean;
import Bean.OutbusinBean;
import Dao.OutlistDao;

public class OutlistModel {
	OutbusinBean bean = new OutbusinBean();
	Scanner sc = new Scanner(System.in);
	
	
	public void OutItem() {
		System.out.println("====================");
		System.out.println("판매할 업체명을 입력하세요");
		bean.setBusin_name(sc.next());
		System.out.println("판매할 제품을 입력하세요");
		System.out.println("판매할 수량을 입력하세요");
	}
	
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

