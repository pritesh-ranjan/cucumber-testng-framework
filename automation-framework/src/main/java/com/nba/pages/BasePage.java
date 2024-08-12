package com.nba.pages;

import com.nba.utilities.TestContext;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, String keyword) {
        driver.findElement(locator).sendKeys(keyword);
    }

    protected void sendKeys(By locator, Keys key) {
        driver.findElement(locator).sendKeys(key);
    }

    protected void hoverOn(WebElement el) {
        Actions action = new Actions(driver);
        action.moveToElement(el).build().perform();
    }

    public void closeAllPopups() {
        click(closePopUp);
    }

    protected void scrollTo(By locator){
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
