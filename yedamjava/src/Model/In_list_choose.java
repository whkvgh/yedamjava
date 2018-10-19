package Model;

import java.util.Scanner;

public class In_list_choose {
	
	public void in_choose() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수행 할 메뉴를 입력하세요.");
		System.out.println("1. 입력  2. 수정  3. 삭제  4. 조회");
		inBusinModel in;
		int ck = scan.nextInt();
		scan.nextLine();
		
		switch (ck) {
		case 1:
			in = new inBusinModel();
			in.insert_busin();
			break;
		case 2 :
			in = new inBusinModel();
			in.update_busin();
			break;
		case 3 :
			in = new inBusinModel();
			in.delete_inList();
			break;
		case 4:
			in = new inBusinModel();
			in.inlist_show();
			break;
		default:
			break;
		}
	}
}
