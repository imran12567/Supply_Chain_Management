package com.scm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Tyss_ReadDataFromDatabaseTest {
	public static void main(String[] args) throws SQLException {

		Connection con= null;
		Driver driver= new Driver();
		try {
			// step 1: Register the database using registerDriver() method
			DriverManager.registerDriver(driver);
			// step 2: get connection for the database using getConnection() method
con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%" , "root");
			// step 3: Issue createStatement()
			Statement state = con.createStatement();
			String query = "select * from projects;";
			// step 4: executeQuery()
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// step 5 close the database using close() method
		finally {
			con.close();
			System.out.println("Database closed successfully");
		}

	}
}
