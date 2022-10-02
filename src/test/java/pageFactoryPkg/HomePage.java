package pageFactoryPkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.MainClass;

public class HomePage extends MainClass{
	// 1. Creating webElement -> @FindBy
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTxtBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	// 2. Initialize webElement created to driver instance -> in constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// 3. Action to be performed on webElement & page -> method
	public void enterProductInSearchField(String product) {
		searchTxtBox.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();	
	}
	
}
