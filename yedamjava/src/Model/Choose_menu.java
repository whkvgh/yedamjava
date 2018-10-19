package Model;

import java.util.Scanner;

public class Choose_menu {
	
	public void menu_choose() {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("관리할 화면을 선택하세요.");
			System.out.println("1. 조회  2. 입고  3. 출고  4. 종료");
			
			System.out.printf("입력 : ");
			int ck = scan.nextInt();
			scan.nextLine();
	
			switch (ck) {
			case 1:
				Choose_View view = new Choose_View();
				view.show();
				break;
			case 2:
				In_list_choose list_chooice = new In_list_choose();
				list_chooice.in_choose();
				break;
			case 3:
				TEST test = new TEST();
				test.Jtest();
				break;
			default:
				break;
			}
			if(ck == 4)
				break;
			
		}
		
	}
}
