package Model;

import java.util.Scanner;

import View.Item_View;

public class Choose_View {
	
	public void show() {
		Item_View view = new Item_View();
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 구매업체  2. 구매업체  3. 창고정보  4. 품목정보  5. 입출고  6. 재고관리");
		
		int ck = scan.nextInt();
		scan.nextLine();
		
		switch (ck) {
		case 1:
			view.in_busin();
			break;
		case 2:
			view.out_list();
			break;
		case 3:
			view.store_list();
			break;
		case 4:
			view.item_list();
			break;
		case 5:
			view.inout_list();
			break;	
		case 6:
			view.good_list();
			break;
		default:
			break;
		}
		scan.close();
	}
	
	
}
