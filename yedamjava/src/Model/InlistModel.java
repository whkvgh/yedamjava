package Model;

import java.util.Scanner;

import Dao.inBusinDao;

public class InlistModel {
	
	public void input_list(String busin_name) {
		inBusinDao dao = new inBusinDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("구입 할 상품명을 입력해주세요.");
		int cnt  = 0;
		String sign = "s";
		
		while(true) {
			cnt++;
			
			System.out.print("상품명 : ");
			String name = scan.nextLine();
			
			System.out.print("수량 : ");
			int count = scan.nextInt();
			scan.nextLine();
			
			//System.out.println(count);
			
			System.out.print("더 구입하실껀가요? (Y/N) : ");
			String ck = scan.nextLine();
			
			dao.in_list(name, count, busin_name, cnt, sign);
			
			if(!ck.equalsIgnoreCase("Y") ) {
				//scan.close();	
				System.out.println(ck);
				break;
			}else {
				sign = "M";
			}
					
		}

	}
}
