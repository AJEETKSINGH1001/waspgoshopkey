package com.waspshopkey.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.waspshopkey.framework.base.BaseTest1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksAndImagesTest extends BaseTest1 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your WebDriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajeet\\Documents\\chromedriver.exe");
        // Initialize WebDriver
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void loginAndNavigateToDashboard() {
        // Open the login page and perform login
        driver.get("https://wasp.shopkey.dev/app/login");
        
        // Example: Find username and password fields and submit
        WebElement usernameInput = driver.findElement(By.id("email_address"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/main/section[2]/div/form/button"));

        usernameInput.sendKeys("parminder@gamechangesns.com");
        passwordInput.sendKeys("Qwerty@123");
        loginButton.click();

        // Wait for dashboard page to load after login
        // Add appropriate wait here before proceeding to dashboard
        // Example: You can wait for a specific element on the dashboard
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboardElement")));
        
        // Navigate to the dashboard page
        driver.get("https://wasp.shopkey.dev/app/accounts/1/dashboard");
    }

    @Test(description = "Verify broken links and images")
    public void testBrokenLinksAndImages() {
        // Find all images on the page
        List<WebElement> imagesList = driver.findElements(By.tagName("img"));
        System.out.println("Total images found: " + imagesList.size());

        // Check each image for broken links
        for (WebElement imageElement : imagesList) {
            String imageURL = imageElement.getAttribute("src");
            if (imageURL != null && !imageURL.isEmpty()) {
                verifyLink(imageURL);
            }
        }

        // Find all links on the page
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + linksList.size());

        // Check each link for broken links
        for (WebElement linkElement : linksList) {
            String linkURL = linkElement.getAttribute("href");
            if (linkURL != null && !linkURL.isEmpty()) {
                verifyLink(linkURL);
            }
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    // Method to verify the HTTP response code of a URL
    public void verifyLink(String url) {
        try {
            URL linkURL = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) linkURL.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Timeout for connection in milliseconds
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage());
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            System.out.println(url + " - " + "Failed to connect: " + e.getMessage());
        }
    }
}
