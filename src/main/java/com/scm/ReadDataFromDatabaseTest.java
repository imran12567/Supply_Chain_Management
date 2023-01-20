package com.scm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {
	
	public static void main(String[] args) throws SQLException {

		Connection con= null;
		Driver driver= new Driver();
		try {
			// step 1: Register the database using registerDriver() method
			DriverManager.registerDriver(driver);
			// step 2: get connection for the database using getConnection() method
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root" , "root");//rmgtestingserver:3333/projects" root@%" root"
			// step 3: Issue createStatement()
			java.sql.Statement state = con.createStatement();
			String query = "select * from si;";
			// step 4: executeQuery()
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// step 5 close the database using close() method
		finally {
			con.close();
			System.out.println("Database closed successfully");
		}

	}
}
