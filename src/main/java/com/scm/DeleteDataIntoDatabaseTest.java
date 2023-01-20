package com.scm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DeleteDataIntoDatabaseTest {
	public static void main(String[] args) throws SQLException {

		Connection con= null;
		Driver driver= new Driver();
		boolean result = false;
		try {
			// step 1: Register the database using registerDriver() method
			DriverManager.registerDriver(driver);
			// step 2: get connection for the database using getConnection() method
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root" , "root");
			// step 3: Issue createStatement()
			java.sql.Statement state = con.createStatement();
			String query = "delete from si where sid=4";
			// step 4: update the query using executeUpdate()
			result = state.execute(query);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// step 5 close the database using close() method
		finally {
			con.close();
			System.out.println("Database closed successfully");
		}
		System.out.println(result);

	}
}
