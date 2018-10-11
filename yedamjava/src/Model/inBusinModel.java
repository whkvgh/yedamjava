package Model;


import java.util.Scanner;

import View.Item_View;

public class inBusinModel {
	
	Item_View view;
	
	public void insert_busin() {
		
		view = new Item_View();
		view.in_busin();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("구입할 업체를 입력하세요.");
		System.out.print("업체명 : ");
		String name = scan.nextLine();

		InlistModel model = new InlistModel();
		model.input_list(name);
		
		scan.close();
	}
}
