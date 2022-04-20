package stepDefinition;

import static org.junit.Assert.assertTrue;

import cucumber.TestContext;
import dataProviders.ConfigFileReader;
import managers.FileReaderManager;
import pageObjects.CartPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchToCartSteps {
	
	TestContext testContext;
	SearchPage searchPage;
	ProductPage productPage;
	CartPage cartPage;
	ConfigFileReader configFileReader;
	
	public SearchToCartSteps(TestContext context) {
		 testContext = context;
		 searchPage = testContext.getPageObjectManager().getSearchPage();
		 productPage = testContext.getPageObjectManager().getProductPage();
		 cartPage = testContext.getPageObjectManager().getCartPage();
  		 FileReaderManager fileReaderManager = FileReaderManager.getInstance();
		 configFileReader = fileReaderManager.getConfigReader();
		 System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
	}
	
	@Given("I am in the search product page")
	public void i_am_in_the_search_product_page() {
		searchPage.navigateToAmazonHomePage();
		searchPage.acceptCookies();
	}

	@When("I search for the product {string}")
	public void i_search_for_the_product(String string) {
		searchPage.searchProduct(string);
	}

	@When("I add the product {string} to the cart")
	public void i_add_the_product_to_the_cart(String string) throws InterruptedException {
		searchPage.selectProductItem(string);
		productPage.clickOnAddToCart();
	}

	@Then("The product {string} is listed in the cart list")
	public void the_product_is_listed_in_the_cart_list(String string) {
		productPage.clickOnViewCart();
		assertTrue("The product is added to the cart", cartPage.checkProductIsAddedToCart(string));
	}
	
	
}
