package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePkg.MainClass;
import pageFactoryPkg.HomePage;
import pageFactoryPkg.SearchResultPage;

// Assignment: any application | Create TDD POM | 4-5 Features -> as many test cases | Share report

public class SearchFunctionalityTest extends MainClass{
	HomePage hp;
	SearchResultPage srp;
	
	@BeforeMethod
	public void loadApp() {
		initialization();
		hp = new HomePage();
		srp = new SearchResultPage();
	}
	
	@AfterMethod
	public void closeApp() {
		tearDown();
	}
	
	@Test(enabled=true, dataProviderClass=dataPkg.SearchFunctionalityData.class, 
			dataProvider="positiveSearchFunctionalityData")
	public void positiveSearchFunctionalityTest(String product) {		
		hp.enterProductInSearchField(product);
		hp.clickSearchBtn();
		Assert.assertTrue(srp.searchResultPageTitle().contains(product));
	}
	
	@Test(dataProviderClass=dataPkg.SearchFunctionalityData.class, 
			dataProvider="negativeSearchData")
	public void negativeSearchFunctionalityTest(String product) {
//		WebElement searchTxtbox = driver.findElement(By.id("twotabsearchtextbox"));
//		String productForSearch = product;
//		searchTxtbox.sendKeys(productForSearch);
		hp.enterProductInSearchField(product);
		
//		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
//		searchBtn.click();
		hp.clickSearchBtn();
		
//		WebElement noResultErrorMsg = driver.findElement(By.
//				xpath("//div[@class='a-row']/span[1]"));
//		Assert.assertTrue(noResultErrorMsg.isDisplayed());
		Assert.assertTrue(srp.validateVisibiltyOfNoResultErrorMsg());
	}
}
