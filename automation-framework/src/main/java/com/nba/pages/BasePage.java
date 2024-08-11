package com.nba.pages;

import com.nba.utilities.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    private static final By closePopUp = By.xpath("//div[text()='x']");

    public BasePage() {
        driver = TestContext.CONTEXT.getDriver();

    }

    protected void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, String keyword) {
        driver.findElement(locator).sendKeys(keyword);
    }

    protected void sendKeys(By locator, Keys key) {
        driver.findElement(locator).sendKeys(key);
    }

    public void closeAllPopups() {
        click(closePopUp);
    }
}
