package com.nba.pages;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ShopPage extends BasePage {
    private static final By SEARCH_BAR = By.xpath("//input[@placeholder='Search']");
    private static final By SEARCH_BUTTON = By.xpath("//button[@aria-label='Search Product']");
    private static final By PRODUCTS = By.xpath("//div[@class='product-card row']");
    private static final By NEXT = By.xpath("//li[@class='next-page']/a");


    public ShopPage searchFor(String keyword) {
        sendKeys(SEARCH_BAR, keyword);
        sendKeys(SEARCH_BAR, Keys.ESCAPE);
        click(SEARCH_BUTTON);
        return this;
    }


    public ShopPage switchToShopWindow() {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains("Golden Gate Warriors Shop"))
                break;
        }
        return this;
    }

    public void getResults() throws IOException {

        try (CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
            String[] header = {"Title", "Price", "Comment"};
            writer.writeNext(header);

            while (!driver.findElements(NEXT).isEmpty()) {
                click(NEXT);
                List<WebElement> products = driver.findElements(PRODUCTS);
                for (WebElement el : products) {
                    String[] asd = el.getText().split("\\n");
                    String title = asd[asd.length - 1];
                    String price = getPrice(asd);
                    String comment = "";
                    if (!asd[0].contains("$"))
                        comment = asd[0];
                    else comment = "";
                    String[] row = {title, price, comment};
                    writer.writeNext(row);
                }
            }
        }
    }

    private String getPrice(String[] asd) {
        for (String i : asd) {
            if (i.contains("$"))
                return i;
        }
        return null;
    }
}
