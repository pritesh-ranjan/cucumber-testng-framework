package com.nba.pages;


import com.nba.utilities.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage{
    private static final By CATEGORIES = By.xpath("//li[@data-testid='footer-list-item']/a");

    public HomePage loadPage() {
        driver.get(ConfigFactory.getConfig().derivedProduct2Url());
        return this;
    }

    public HomePage scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        return this;
    }

    public Map<String, String> getCategoryLinkMap() {
        List<WebElement> categories = driver.findElements(CATEGORIES);
        Map<String, String> categoryMap = new HashMap<>();
        for(WebElement categoryEl: categories){
            categoryMap.put(categoryEl.getAttribute("href"), categoryEl.getText().trim());
        }
        return categoryMap;
    }
}
