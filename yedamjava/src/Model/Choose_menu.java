package Model;

import java.util.Scanner;

public class Choose_menu {
	
	public void menu_choose() {
		Scanner scan = new Scanner(System.in);
		System.out.println("관리할 화면을 선택하세요.");
		System.out.println("1. 조회 2.입고 3.출고");
		System.out.print("입력 : ");
		int ck = scan.nextInt();
		scan.nextLine();
		
		switch (ck) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			TEST test = new TEST();
			test.Sest();
			break;
		default:
			break;
		}
		
	}
}
