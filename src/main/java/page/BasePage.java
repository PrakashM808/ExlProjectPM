package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public void selectFromDrowdown(WebElement element , String visibleTest) {
		// TODO Auto-generated method stub
		Select sel =new Select (element);
		sel.selectByVisibleText(visibleTest);
		
	}
	public int generateRandomNum(int boundryNum) {
		Random rnd = new Random();
		int generatedNum=rnd.nextInt(boundryNum);
		return generatedNum;
		
	}

}