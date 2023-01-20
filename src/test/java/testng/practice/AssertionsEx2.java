package testng.practice;


import static org.testng.Assert.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertionsEx2 {
		

	@Test
	public void testScript1() {
		Reporter.log("test1", true);
		Reporter.log("test2", true);
		Reporter.log("test3", true);
		int a = 20;
		int b = a;
		 b = 30;
		assertSame(a, b);
		Reporter.log("test4", true);
		Reporter.log("test5", true);

	}
	
	@Test
	public void testScript2() {
		System.out.println("");
		Reporter.log("test6", true);
		Reporter.log("test7", true);
		Reporter.log("test8", true);
		Reporter.log("test9", true);
		Reporter.log("test10", true);
	}
}
