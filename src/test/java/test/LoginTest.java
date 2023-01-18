package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TFios.xlsx");
	String username = exlRead.getCellData("logIninfo", "UserName", 2);
	String password = exlRead.getCellData("logIninfo", "Password", 2);
	String dashboardValidationPage =exlRead.getCellData("logIninfo", "DashboardValidationText", 2);
	
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
	
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.enterusername(username);
		loginpage.enterPassword(password);
		loginpage.clickonSigninbutton();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.verifyDashboardPage(dashboardValidationPage);
		BrowserFactory.tearDown();
		
		
		
	}
	
	

}


