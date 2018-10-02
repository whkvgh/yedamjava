package Model;

import java.sql.SQLException;

import Dao.inBusinDao;

public class Start {
	public static void main(String[] args) throws SQLException {
		inBusinModel model = new inBusinModel();
		model.inBusin_list();
		
	}
}
