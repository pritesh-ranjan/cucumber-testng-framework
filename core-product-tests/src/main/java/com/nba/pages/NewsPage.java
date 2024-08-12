package com.nba.pages;

import org.openqa.selenium.By;

import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class NewsPage extends BasePage{
    private static final By FEEDS = By.xpath("//div[@data-testid='tile-article']");

    public int getFeedsCountByAge(int days){
        return (int) getFeedsInPage().filter(i-> i>=days).count();
    }

    public int getTotalFeedsCount(){
        return (int) getFeedsInPage().count();
    }

    private Stream<Integer> getFeedsInPage() {
        return driver.findElements(FEEDS).stream().map(el -> {
            String res = el.findElement(By.xpath(".//time")).getText().trim().replace("d", "");
            if(!isNumeric(res))
                return 0;
            return Integer.parseInt(res);
        });
    }

}
