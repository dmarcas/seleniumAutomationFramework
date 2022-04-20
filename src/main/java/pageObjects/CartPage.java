package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;


public class CartPage {
		
	WebDriver driver;
	ConfigFileReader configFileReader;
	WebDriverWait w;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.w = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
	}
	
	
	@FindBy(how = How.XPATH, using="//*[@data-name=\"Active Items\"]")
	private List<WebElement> list_ActiveProductItems;
	
	
//----------------- Functions--------------------------//
	
	
	public Boolean checkProductIsAddedToCart(String productDataNumber){
		return list_ActiveProductItems.get(0).findElement(By.xpath("//div[@data-asin='"+productDataNumber+"']")).isDisplayed();
	}
	
	
}
