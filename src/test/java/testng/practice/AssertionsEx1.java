package testng.practice;


import static org.testng.Assert.*;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsEx1 {
		
	SoftAssert a = new SoftAssert();

	@Test
	public void testScript1() {
		Reporter.log("test1", true);
		Reporter.log("test2", true);
		Reporter.log("test3", true);
		a.assertEquals("a", "b");
		Reporter.log("test4", true);
		Reporter.log("test5", true);
		a.fail("failed because");

		a.assertAll();

	}
	
	@Test
	public void testScript2() {
		System.out.println("");
		Reporter.log("test6", true);
		Reporter.log("test7", true);
		Reporter.log("test8", true);
		assertNotEquals("a", "b");
		a.fail("failed because");


		Reporter.log("test9", true);
		Reporter.log("test10", true);
		a.assertAll();
	}
}
