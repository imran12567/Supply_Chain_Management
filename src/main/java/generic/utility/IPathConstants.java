package generic.utility;

import org.openqa.selenium.WebDriver;

public interface IPathConstants {
	 String mySQLDatabase = "jdbc:mysql://localhost:3306/sdet45";
	 String mySQLUsername = "root";
	 String mySQLPassword = "root";
	 String dbUrl = "http://localhost:8888/";
	 String dbUsername = "root";
	 String dbPwd = "root";
	 String excelSheetPath = "./src/main/resources/InputData.xlsx";
	 String propertyFilePath = "./src/main/resources/commondata.property";
	 String url = "http://rmgtestingserver/domain/Supply_Chain_Management/index.php";
	 public WebDriver driver = null;
}
