package testng.practice;


import org.testng.Reporter;
import org.testng.annotations.Test;


public class ListenerExecution2 {
	@Test
	public void a() throws Throwable {


		Reporter.log("a", true);
	}

	@Test 
	public void b() {
		Reporter.log("b", true);
	}

	@Test
	public void c() {
		Reporter.log("c", true);
	}


}
