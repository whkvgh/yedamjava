package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Bean.ItemListBean;
import Bean.OutbusinBean;
import Dao.OutlistDao;

public class OutlistModel {
	OutlistDao dao =new OutlistDao();
	Scanner sc = new Scanner(System.in);
	ItemListBean bean = new ItemListBean();
	
	public ItemListBean getOutItem() {
		try{ 
			System.out.println("====================");
			System.out.println("판매할 업체명을 입력하세요");
			
		}
		
		
	}
	
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

