package com.nba.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {

    @Before
    public void createDriver() {
        String browserName = "chrome";
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome", default -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }

        driver.manage().window().maximize();

        TestContext.CONTEXT.setDriver(driver);
    }

    @After
    public void closeDriver() {
        TestContext.CONTEXT.getDriver().quit();
    }
}
