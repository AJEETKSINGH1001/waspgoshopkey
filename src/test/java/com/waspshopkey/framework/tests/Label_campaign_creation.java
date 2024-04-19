package com.waspshopkey.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.waspshopkey.framework.base.BaseTest1;

public class Label_campaign_creation extends BaseTest1 {

    
    @Test(priority = 1)
    public void verifyTextAndImageAfterLogin() {
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
        
     // Wait for the dashboard element or any element that indicates successful login
        WebElement dashboardElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section/section/div/div[2]/div[1]/h1"));
        
        // Assert that the dashboard element is displayed after login
        Assert.assertTrue(dashboardElement.isDisplayed(), "Login failed or dashboard element not found");
    }
    
    @Test(priority = 2)
    public void clickCampaignIcon() {
        // Click on the campaign icon to open campaign creation page
        WebElement campaignIcon = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/aside/div/div[1]/a[4]"));
        campaignIcon.click();

        // Verify that campaign creation page is opened
        WebElement createCampaignButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section/div/div[2]/button"));
        Assert.assertTrue(createCampaignButton.isDisplayed(), "Campaign creation page not opened");
        createCampaignButton.click();
        
    }

    @Test(priority = 3)
    public void verifyCampaignCreationPageElements() {
        // Check for elements on the campaign creation page
        WebElement campaignNameInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section/div/div[2]/div[2]/div/div/div/div/h2"));

        // Assert all required elements are displayed
        Assert.assertTrue(campaignNameInput.isDisplayed(), "Create a campaign input not found");
    }
    @Test(priority = 4)
    public void CreateNewCampaign() {
        // Assuming campaign creation page is opened from the previous test
        // Fill out the campaign form
        WebElement campaignNameInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section/div/div[2]/div[2]/div/div/div/form/div[1]/label[1]/input"));
        campaignNameInput.sendKeys("QAtest1_1904");

        
       //Select inboxDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section/div/div[2]/div[2]/div/div/div/form/div[1]/label[2]/select/option[4]")));
     // Locate the dropdown element using its attribute (data-v-a8028ef4) as the identifier
        WebElement dropdown = driver.findElement(By.cssSelector("select[data-v-a8028ef4]"));

        // Click on the dropdown to open options
        dropdown.click();

       

        // Locate the specific option "ShopKey - TP" by its value attribute and click it
        WebElement shopKeyOption = driver.findElement(By.cssSelector("option[value='57']"));
        shopKeyOption.click();

//Selecting audience
        
        WebElement dropdown1 = driver.findElement(By.cssSelector("select[data-v-a8028ef4]"));

        // Create a new Select object
        //Select select = new Select(dropdown);

        // Use WebDriverWait to wait for the dropdown to be clickable and ready
       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // wait.until(ExpectedConditions.elementToBeClickable(dropdown));

        // Click on the dropdown to open the options
        dropdown1.click();

        // Use WebDriverWait to wait for the option "Labels" to be visible and clickable
        WebElement shopKeyOption1 = driver.findElement(By.cssSelector("option[value='labels']"));
        shopKeyOption1.click();
        // Click on the "Labels" option to select it
        shopKeyOption1.click();
        //Audience
        //WebElement audienceInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section/div/div[2]/div[2]/div/div/div/form/div[1]/label[4]/div/div[2]"));
        WebElement audienceInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section/div/div[2]/div[2]/div/div/div/form/div[1]/label[4]/div/div[1]"));
      //*[@id="app"]/div[1]/section/div/div[2]/div[2]/div/div/div/form/div[1]/label[4]/div/div[2]
        audienceInput.sendKeys("qa1");
        audienceInput.sendKeys(Keys.ENTER);
        

        FluentWait<WebDriver> wait = null;
		// Wait for suggestions to appear and select one
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement audienceSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='audience-suggestions']/li")));
        audienceSuggestion.click();

        // Click on the schedule time input to open the calendar
        WebElement scheduleTimeInput = driver.findElement(By.id("schedule-time"));
        scheduleTimeInput.click();

        // Select date and time from the calendar (example: using JavaScript to set date)
        WebElement calendarDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker")));
        // Assuming you want to select tomorrow's date
        String jsScript = "document.querySelector('.datepicker').value = '2024-04-20';";
        ((JavascriptExecutor) driver).executeScript(jsScript);

        // Click "Next" button to proceed
        WebElement nextButton = driver.findElement(By.id("next-button"));
        nextButton.click();

        // Assert that the next step in the campaign creation process is reached (e.g., confirmation page)
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation-message")));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Next step after filling campaign form not reached");
    
    	
    }

}
