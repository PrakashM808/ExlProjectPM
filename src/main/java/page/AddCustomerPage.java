package page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how = How.XPATH, using ="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"account\"]")WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"cid\"]")WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"country\"]")WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"phone\"]")WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"email\"]")WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"address\"]")WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"city\"]")WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"state\"]")WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"zip\"]")WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"submit\"]")WebElement SAVE_BUTTON_ELEMENT;
	
	public void verifyAddContactPage(String addContactHeaderText) {
		
//		WebDriverWait wait =new WebDriverWait(driver , 10);
//		wait.until(ExpectedConditions.invisibilityOf(ADD_CONTACT_HEADER_ELEMENT));
////		
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), addContactHeaderText , "Wrong Page!!");
		
	}
	String insertedName;
	public void insertFullName(String fullName) {
		insertedName =fullName +generateRandomNum(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
		
	}
	
	
	public void selectCompany(String company) {
		selectFromDrowdown(COMPANY_ELEMENT,company);	 
		
	}
	
	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNum(999)+email );
		
	}
	public void insertPhoneNum(String phone) {
		PHONE_ELEMENT.sendKeys(phone+generateRandomNum(999) );
	}
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
		
	}
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
		
	}
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
		
	}	
	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
		
	}
	public void selectCountry(String country) {
		selectFromDrowdown(COUNTRY_ELEMENT,country);
	}
	public void save() {
		SAVE_BUTTON_ELEMENT.click();
		
	}
	
	//tbody/tr[1]/td[3]
	
	//tbody/tr[1]/td[7]/a[2] delete
	
	String begning_Xpath ="//tbody/tr[";
	String after_Xpath ="]/td[3]";
	String after_Xpath_Delete = "]/td[7]/a[2]";
	
	public void validateAndDeletedAddedNameOnCustomerList() {
		
		for(int i=1; i<=10; i++) {
			String nameOnList=driver.findElement(By.xpath(begning_Xpath+ i + after_Xpath)).getText();
			System.out.println(nameOnList);
			//Assert.assertEquals(nameOnList, insertedName, "Name Doesnot Exist");
			if(nameOnList.contains(insertedName)) {
				System.out.println("Entered Name Exist");
				driver.findElement(By.xpath(begning_Xpath+ i + after_Xpath_Delete )).click();;
				break;
			}
			
		}
		
	}
	
	
}
