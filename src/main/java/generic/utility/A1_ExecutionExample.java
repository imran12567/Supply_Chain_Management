package generic.utility;

import java.sql.ResultSet;

public class A1_ExecutionExample {
	public static void main(String[] args) throws Throwable {
		DatabaseUtility d = new DatabaseUtility();
//		ResultSet result = d.getDataFromDB("select sname from si");
		ResultSet result = d.getDataFromDB("select * from si");
		while (result.next()) {
			System.out.println(result.getString(1));
			
		}
	}
}
