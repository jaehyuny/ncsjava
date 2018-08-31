package jdbc;

import java.sql.Connection;

public class DBCon {
	static Connection con;
	private DBCon() {}
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
