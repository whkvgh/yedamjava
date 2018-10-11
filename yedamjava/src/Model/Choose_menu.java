package Model;

import java.util.Scanner;

public class Choose_menu {
	
	public void menu_choose() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("관리할 화면을 선택하세요.");
		System.out.println("1. 조회  2. 입고  3. 출고");
		
		System.out.printf("입력 : ");
		int ck = scan.nextInt();
		scan.nextLine();

		switch (ck) {
		case 1:
			Choose_View view = new Choose_View();
			view.show();
			break;
		case 2:
			inBusinModel in = new inBusinModel();
			in.insert_busin();
			break;
		case 3:
			TEST test = new TEST();
			test.Sest();
			break;
		default:
			break;
		}
		scan.close();
	}
}
