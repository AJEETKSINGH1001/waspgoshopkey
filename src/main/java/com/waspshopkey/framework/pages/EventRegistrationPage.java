package com.waspshopkey.framework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventRegistrationPage {

    private final WebDriver driver;

    // Locators
    private final By nameInput = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input");
    private final By lnInput = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input");
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By maleRadioButton = By.id("male");
    private final By femaleRadioButton = By.id("female");
    private final By submitButton = By.id("submit");

    public EventRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
    
    public void enterln(String ln) {
        driver.findElement(lnInput).sendKeys(ln);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(maleRadioButton).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(femaleRadioButton).click();
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
