package com.nba.pages;


import com.nba.constants.MenuItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private static final String MENU_XPATH = "//li[@class='menu-item']//a/span[text()='%s']";
    private static final By MEN_SECTION = By.xpath("//a[@title=\"Men's\"]");

    public HomePage loadPage() {
        driver.get("https://www.nba.com/warriors/");
        return this;
    }

    public HomePage openMenu(MenuItems item) {
        WebElement shop = driver.findElement(By.xpath(String.format(MENU_XPATH, item.value)));
        Actions action = new Actions(driver);
        action.moveToElement(shop).build().perform();
        return this;
    }


    public ShopPage openMenSection() {
        click(MEN_SECTION);
        return new ShopPage();
    }
}
