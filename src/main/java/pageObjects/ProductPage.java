package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;


public class ProductPage {
		
	WebDriver driver;
	ConfigFileReader configFileReader;
	WebDriverWait w;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.w = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
	}
		
	@FindBy(how = How.ID, using ="add-to-cart-button")
	private WebElement btn_AddToCart;
	
	@FindBy(how = How.ID, using ="attach-sidesheet-view-cart-button")
	private WebElement viewCart;
	
	
//----------------- Functions--------------------------//
	
	
	public void clickOnAddToCart() throws InterruptedException {
		w.until(ExpectedConditions.elementToBeClickable(btn_AddToCart)).click();
	}
	
	public void clickOnViewCart() {
		viewCart.click();
	}

	
	
}
