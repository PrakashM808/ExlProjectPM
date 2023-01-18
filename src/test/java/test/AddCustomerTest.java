package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;

import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("src\\\\main\\\\java\\\\testData\\\\TFios.xlsx");
	String username = exlRead.getCellData("logIninfo", "UserName", 2);
	String password = exlRead.getCellData("logIninfo", "Password", 2);
	String dashboardValidationPage = exlRead.getCellData("logIninfo", "DashboardValidationText", 2);
	String AddContactValidationText = exlRead.getCellData("AddContactInfo", "AddContactText", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);

	@Test
	public void validCustomerShouldBeAbleToCreatCustomer() throws InterruptedException {
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterusername(username);
		loginpage.enterPassword(password);
		loginpage.clickonSigninbutton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage(dashboardValidationPage);
		dashboardPage.clickOnCustomer();
		dashboardPage.clickOnAddCustomer();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);

		addCustomerPage.verifyAddContactPage(AddContactValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNum(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.save();
		
		
		dashboardPage.clickOnListCustomer();
		addCustomerPage.validateAndDeletedAddedNameOnCustomerList();

	}

}
//git remote add origin https://github.com/PrakashM808/PomProjectJuly22.git
