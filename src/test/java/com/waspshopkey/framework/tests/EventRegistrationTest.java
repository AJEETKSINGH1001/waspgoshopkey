package com.waspshopkey.framework.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.waspshopkey.framework.pages.EventRegistrationPage;



public class EventRegistrationTest {
	
	private ExtentReports extentReports;
    private ExtentTest extentTest;

    @BeforeMethod
    public void setup() {
        extentReports = new ExtentReports();
        extentTest = extentReports.createTest("MyTest");
    }

    private WebDriver driver;
    private EventRegistrationPage registrationPage;

    @BeforeClass
    public void setUp() {
        // Set the path to your ChromeDriver executable
    	//variable path declaration
    	// Get the current working directory
    	String currentDirectory = System.getProperty("user.dir");
    	// Specify the relative path to the Chromedriver executable
    	String chromeDriverPath = currentDirectory + "/src/test/resources/drivers/chromedriver.exe";
    	// Set the system property for ChromeDriver
    	System.setProperty("webdriver.chrome.driver", chromeDriverPath);

    	//System.setProperty("webdriver.chrome.driver","C:/Users/Ajeet/eclipse-workspace/demoqa/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        registrationPage = new EventRegistrationPage(driver);
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @Test
    public void testEventRegistration() {
        registrationPage.enterName("John Doe");
        registrationPage.enterln("Alexa");
        registrationPage.enterEmail("jhhjghg667@demo.com");
        registrationPage.enterPassword("password123");
        registrationPage.selectGender("male");
        registrationPage.clickSubmitButton();

        // Add assertions or verifications here based on the expected behavior after form submission
    }

   // @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
    
}
