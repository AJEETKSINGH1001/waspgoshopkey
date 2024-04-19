package com.waspshopkey.framework.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class WebsiteVerificationTest {

    protected WebDriver driver;
    private String baseUrl = "https://wasp.shopkey.dev/app/login"; // Replace with your website URL

    @BeforeClass
    public void setUp() {
        // Set up WebDriver (assuming ChromeDriver is used)
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajeet\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyTextAndImageAfterLogin() throws IOException {
        // Navigate to the website
        driver.get(baseUrl);

        // Perform login (assuming login process here)
        // Example: Find username and password fields and submit
        WebElement usernameInput = driver.findElement(By.id("email_address"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/main/section[2]/div/form/button"));

        usernameInput.sendKeys("parminder@gamechangesns.com");
        passwordInput.sendKeys("Qwerty@123");
        loginButton.click();

        // Wait for login to complete (you might need to add a wait here)

        // Search for specific word or image
        String searchTerm = "Chatwoot";
        String imageAltText = "Chatwoot";

        boolean termFound = driver.getPageSource().contains(searchTerm);
        boolean imageFound = driver.findElement(By.cssSelector("img[alt='" + imageAltText + "']")).isDisplayed();

        // Log the destination if term or image found
        if (termFound || imageFound) {
            String destination = driver.getCurrentUrl();
            System.out.println("Search term or image found. Destination: " + destination);

            // Capture screenshot
            takeScreenshot(driver, "search_result_" + getCurrentTimestamp());
        } else {
            System.out.println("Search term or image not found.");
        }
    }
protected static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File destFile = new File("screenshots/" + fileName + ".png");
    //org.apache.commons.io.FileUtils.copyFile(screenshotFile, destFile);
}

private static String getCurrentTimestamp() {
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    return currentTime.format(formatter);
}
}