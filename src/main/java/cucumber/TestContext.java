package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManagers;

public class TestContext {
	 private WebDriverManagers webDriverManagers;
	 private PageObjectManager pageObjectManager;
	 
	 public TestContext(){
		 webDriverManagers = new WebDriverManagers();
		 pageObjectManager = new PageObjectManager(webDriverManagers.getDriver());
	 }
	 
	 public WebDriverManagers getWebDriverManager() {
		 return webDriverManagers;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
		 return pageObjectManager;
	 }
	 
	 
	 
}
