package generic.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility  {
	Connection con = null;
	public  void connectToDB(String URL) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(URL);
	}
	public  void closingTheDB() throws SQLException {
		con.close();
	}
	public  ResultSet getDataFromDB(String query) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.mySQLDatabase, IPathConstants.mySQLUsername, IPathConstants.mySQLPassword);
		ResultSet result = con.createStatement().executeQuery(query);
		return result;
	}
	public  void passDataIntoDB(String query) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbUrl);
		int result = con.createStatement().executeUpdate(query);
		System.out.println("return of the query from DB is: "+result);
	}
	public  boolean deleteDataFromDB(String query) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbUrl);
		boolean result = con.createStatement().execute(query);
		return result;
	}
	
}
