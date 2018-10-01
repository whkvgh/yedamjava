package Model;

import java.util.Scanner;

public class InlistModel {
	
	public void input_list(String busin_name) {
		Scanner scan = new Scanner(System.in);
		System.out.println("구입 할 상품명을 입력해주세요.");
		
		while(true) {
		
			System.out.print("상품명 : ");
			String name = scan.nextLine();
			
			System.out.print("수량 : ");
			int count = scan.nextInt();
			scan.nextLine();
			
			System.out.print("더 구입하실껀가요? (Y/N)");
			String ck = scan.nextLine();
			
			if(!ck.equals("Y"))
					break;
		}
		scan.close();

	}
}
