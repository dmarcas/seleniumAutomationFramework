package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;

public class PageObjectManager {

	private WebDriver driver;
	private SearchPage searchPage;
	private ProductPage productPage;
	private CartPage cartPage;

	public PageObjectManager(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver = driver;
	}
	
	public SearchPage getSearchPage() {
		return (searchPage==null)? searchPage = new SearchPage(driver):searchPage;
	}
	
	public ProductPage getProductPage() {
		return (productPage==null)? productPage = new ProductPage(driver):productPage;
	}
	
	public CartPage getCartPage() {
		return (cartPage==null)? cartPage = new CartPage(driver):cartPage;
	}
	
}
