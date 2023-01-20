package com.scm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Tyss_UpdateDataIntoDatabaseTest {
	public static void main(String[] args) throws SQLException {

		Connection con= null;
		Driver driver= new Driver();
		int result = 0;
		try {
			// step 1: Register the database using registerDriver() method
			DriverManager.registerDriver(driver);
			// step 2: get connection for the database using getConnection() method
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%" , "root");
			// step 3: Issue createStatement()
			java.sql.Statement state = con.createStatement();
			//ProjectId	ProjectName	No Of Emp	Project Manager	Status	Created On	Actions
			String query = "insert into project values('Abc', 'SCM', '16/12/2022', 'sdet45', 'created', 2);";
			// step 4: update the query using executeUpdate()
			result = state.executeUpdate(query);
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
