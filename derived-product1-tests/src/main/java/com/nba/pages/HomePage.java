package com.nba.pages;

import com.nba.utilities.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {
    private static final By SLIDES = By.xpath("//button[contains(@class,'TileHeroStories')]");

    public HomePage loadPage() {
        driver.get(ConfigFactory.getConfig().derivedProduct1Url());
        return this;
    }

    public Map<String, Long> getSlideTimes() {
        List<WebElement> slides = getSlides();
        Map<String, Long> slideTime = new HashMap<>();
        for (WebElement slide : slides) {
            Instant startTime = Instant.now();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.attributeToBe(slide, "aria-selected", "false"));
            Instant endTime = Instant.now();
            Duration duration = Duration.between(startTime, endTime);
            long timeElapsed = duration.toSeconds();
            slideTime.put(slide.findElement(By.xpath("./div")).getText(), timeElapsed);
        }
        return slideTime;
    }

    public List<WebElement> getSlides() {
        return driver.findElements(SLIDES);
    }
}
