# Description

This is a general automation framework used for general purposes.

# Setup

- You will need to have java installed (In this project I used JAVA 17)
- Set up Java environment variables
- You will need to have maven installed
- Set up Maven environment variables
- To use cucumber from the IDE, you will need to install the plugin.
- You will need to download chromedriver.

# How to use

- First of all ensure that you have downloaded the chromedriver and update the config.properties file (in configs folder: seleniumAutomationFramework/configs) with the path of the location for the key "driverPath" (I didn't use webdriver manager to avoid problems with the browser version, but you can modified if it's better for you).
- To run the test from command line, just go to the folder project and run mvn test or you can run it from the IDE selecting "run as/junit"
- The report is stored in target/HtmlReports

# The framework

This automation framework is based on Page Object Model design creating objects repository for storing all web elements. In this way we reduce code duplication, we improve test case manintenance and we improve the readability. We try too to decouple the technology to the test and Has been used some managers and auxiliar classes to support the automation.

The structure is the following:

|- src/main/java
|    |- cucumber package:
|    |    |- TestContext: class that manage the page objects and help to use the context between them in the test.
|    |- dataProviders package:
|    |    |- ConfigFileReader: class that give support in read the config properties file
|    |- enums package:
|    |    |- DriverType: enum used to define the different types of driver available.
|    |    |- EnvironmentType: enum used to define the diferente execution types.
|    |- managers package:
|    |    |- FileReaderManager: singleton class used to call the get Config reader (and can be added to manage other classess related to file reader if needed)
|    |    |- PageObjectManager: class used to manage the differents page Objects.
|    |    |- WebDriverManagers: class used to manage the webdriver
|    |-pageObjects package:
|    |    |- CartPage
|    |    |- ProductPage
|    |    |- SearchPage
|    |-selenium package:
|    |    |- Wait: class to give support the automationn with wait methods.
|
|- src/test/java
|    |-runners package:
|    |    |- TestRunner: This class contains the config to run the tests with cucumber and some cucumber options config.
|    |-stepDefinition:
|    |    |- Hooks:
|    |    |- SearchTocartSteps: this class contains the steps implementation
|
|- src/test/resources:
|   |- feature folder: Contain the features to be implemented
|   |   |- addToCart.feature
|
|- configs folder:
|    |- Configuration.properties: contain some config like the path of the driver, etc.
|

Finally, in target/HtmlReports you will find the report generated once the test ins launched.

    


