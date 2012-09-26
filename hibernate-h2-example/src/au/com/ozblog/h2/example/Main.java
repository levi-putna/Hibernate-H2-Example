package au.com.ozblog.h2.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] a) throws Exception {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:database/test", "sa",
				"");

		Statement st = conn.createStatement();
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select name from user");
		while (rset.next()) {
			String name = rset.getString(1);
			System.out.println(name);
		}

		conn.close();
	}
}
