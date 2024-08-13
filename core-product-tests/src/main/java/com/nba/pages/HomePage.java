package com.nba.pages;


import com.nba.constants.MenuItems;
import com.nba.utilities.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private static final String MENU_XPATH = "//li[@class='menu-item']//a/span[text()='%s']";
    private static final By MEN_SECTION = By.xpath("//a[@title=\"Men's\"]");
    private static final By NEWS_AND_FEATURES = By.xpath("//a[@title='News & Features']");

    public HomePage loadPage() {
        driver.get(ConfigFactory.getConfig().coreProductUrl());
        return this;
    }

    public HomePage openMenu(MenuItems item) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement shop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(MENU_XPATH, item.value))));
        hoverOn(shop);
        return this;
    }

    public ShopPage openMenSection() {
        click(MEN_SECTION);
        return new ShopPage();
    }

    public NewsPage openNewsAndFeatures() {
        jsclick(NEWS_AND_FEATURES);
        return new NewsPage();
    }
}
