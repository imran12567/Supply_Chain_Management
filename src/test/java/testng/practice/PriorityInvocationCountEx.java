package testng.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityInvocationCountEx {
		
	@Test ( invocationCount=2)
	public void createCustomer() {
		Reporter.log("createCustomer",true);
	}

	@Test (priority=0, invocationCount=2)
	public void editCustomer() {
		Reporter.log("editCustomer",true);
	}
	
	@Test ( invocationCount=1)
	public void deleteCustomer() {
		Reporter.log("deleteCustomer", true);
	}
	
//	@Test (priority=2, invocationCount=1, dependsOnMethods = "", groups = {a, b}, enabled = true, dataProvider = "")
//	public void deleteCustomer2() {
//		Reporter.log("deleteCustomer2",true);
//		Assert.fail();
//	}
}