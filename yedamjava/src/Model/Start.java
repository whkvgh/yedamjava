package Model;

import java.sql.SQLException;

import Dao.OutlistDao;
import Dao.inBusinDao;

public class Start {
	public static void main(String[] args) throws SQLException {
		OutlistDao dao = new OutlistDao();
		dao.outgoods("노트", "줄노트", 50, "pen");
	}
	
}
