package testng.practice;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeClassExample {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("beforeGroup");
	}
	@Test (groups = {"Create"})
	public void test() {
		System.out.println("test");
	}
	@Test 
	public void test2() {
		System.out.println("test2");
	}
	
}
