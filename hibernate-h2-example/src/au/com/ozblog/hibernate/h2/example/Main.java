package au.com.ozblog.hibernate.h2.example;


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
		st.execute("drop table customer");
		st.execute("create table customer(id integer, name varchar(10))");
		st.execute("insert into customer values (1, 'Thomas')");
		st.execute("insert into customer values (2, 'Levi')");
		st.execute("insert into customer values (3, 'Jo Blog')");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select name from customer");
		while (rset.next()) {
			String name = rset.getString(1);
			System.out.println(name);
		}

		conn.close();
	}
}
