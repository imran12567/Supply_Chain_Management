package com.scm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Tyss_ReadDataFromDatabaseTest2 {
	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("select * from si;");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" ");
		}
		con.close();
	}
}
