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


