package com.waspshopkey.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	 private WebDriver driver;

	    private By logoutButton = By.id("logoutBtn");

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isLogoutButtonDisplayed() {
	        return driver.findElement(logoutButton).isDisplayed();
	    }

}
