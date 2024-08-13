package com.nba.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hooks {


    @Before
    public void createDriver() {
        WebDriver driver;
        switch (ConfigFactory.getConfig().browser().toLowerCase()) {
            case "chrome", default -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }

        driver.manage().window().maximize();

        TestContext.CONTEXT.setDriver(driver);
    }

    @After(order = 2)
    public void attachScreenShotOnFailure(Scenario scenario){
        WebDriver driver = TestContext.CONTEXT.getDriver();
        if(scenario.isFailed() && null!=driver){
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", scenario.getName());
        }
    }

    @After(order = 1)
    public void attachReport(Scenario scenario) throws IOException {
        if (Files.exists(Path.of("report"))) {
            File csvFile = new File("report/" + ConfigFactory.getConfig().getOutputFile());
            byte[] fileContent = Files.readAllBytes(csvFile.toPath());
            scenario.attach(fileContent, "text/plain", "Attached File for scenario: " + scenario.getName());
        }
    }

    @After(order = 0)
    public void closeDriver() {
        TestContext.CONTEXT.getDriver().quit();
    }
}
