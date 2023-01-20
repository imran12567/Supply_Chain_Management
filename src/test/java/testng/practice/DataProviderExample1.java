package testng.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderExample1 {
	
	@DataProvider
	public Object[] data2() {
		Object[] objArr = new Object[1];
		objArr[0] = "bengaluru";
		return objArr;
	}
	
	@DataProvider
	public Object[][] data4() {
		Object[][] objArr = new Object[2][2];
		objArr[0][0] = "bengaluru";
		objArr[0][1] = "Mysore";
		
		objArr[1][0] = "Mysore";
		objArr[1][1] = "bengaluru";
		return objArr;
	}
	
	@DataProvider
	public Object[][] data9() {
		Object[][] objArr = new Object[3][3];
		objArr[0][0] = "bengaluru";
		objArr[0][1] = "Mysore";
		objArr[0][2] = 3000;
		
		objArr[1][0] = "Mysore";
		objArr[1][1] = "Goa";
		objArr[1][2] = 4500;
		
		objArr[2][0] = "Goa";
		objArr[2][1] = "bengaluru";
		objArr[2][2] = 6500;

		return objArr;
	}

	@Parameters ({"a","b"})
	public void add(int c, int d) {
		int sum = c+d;
		System.out.println(sum);
	}
	
	@Test (dataProvider = "data2")
	public void travel(String src) {
		System.out.println("from "+ src );
	}

	@Test (dataProvider = "data4")
	public void travel(String src, String dest) {
		System.out.println("from "+ src + " to "+ dest);
	}
	
	@Test (dataProvider = "data9")
	public void travel2(String src, String dest, int price) {
		System.out.println("from "+ src + " to "+ dest+ " price "+price);
	}
}