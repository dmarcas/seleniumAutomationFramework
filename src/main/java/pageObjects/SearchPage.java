package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;


public class SearchPage {
		
	WebDriver driver;
	ConfigFileReader configFileReader;
	WebDriverWait w;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.w = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
	}
		
	@FindBy(how = How.ID, using ="sp-cc-accept")
	private WebElement btn_acceptCookies;
	
	@FindBy(how = How.ID, using ="twotabsearchtextbox")
	private WebElement input_SearchInput;
	
	@FindBy(how = How.ID, using ="nav-search-submit-button")
	private WebElement input_submitSearch;
	
	@FindBy(how = How.XPATH, using="//*[contains(@data-cel-widget, \"search_result\")]")
	private List<WebElement> list_ProductItems;
	
//----------------- Functions--------------------------//
	
	public void navigateToAmazonHomePage() {
		driver.get(configFileReader.getApplicationUrl());
	}
	
	public void acceptCookies(){
		btn_acceptCookies.click();
	}
	
	public void inputTextSearch(String text){
		input_SearchInput.sendKeys(text);
	}
	
	public void clickOnSearchProduct() {
		input_submitSearch.click();
	}
	
	public void selectProductItem(String productDataNumber){
		for (WebElement webElement : list_ProductItems) {
			if(webElement.getAttribute("data-asin").matches(productDataNumber)) {
				webElement.click();
				break;
			}
		}
	}
	
	public void searchProduct(String product) {
		this.inputTextSearch(product);
		this.clickOnSearchProduct();
	}
		
}
