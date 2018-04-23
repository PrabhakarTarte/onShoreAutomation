package tarte.tests;

import static com.tarte.config.Config.getChromeDriver;
//import static com.tarte.config.Config.getDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;


import Base.Xls_Reader;



public class TestATU {

	Xls_Reader reader;
	
	@Test(priority=1)
	public void tet12() {
		reader= new Xls_Reader("C:\\Users\\psharma\\Desktop\\QA\\TestData.xlsx");
		String username = reader.getCellData("TC1", "UserName", 2);
		String password = reader.getCellData("TC1", "Password", 2);
		System.out.println(username);
		System.out.println(password);
		System.out.println("RUN WITH");
		}
	@Test(priority=2)
	public void Test2() {
		System.out.println("Test 2");
	}
	
	
	@Test(priority=3)
	public void Test3() {
		System.out.println("Test 3");
	}
}
