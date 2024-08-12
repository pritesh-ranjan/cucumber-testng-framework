package com.nba.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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


    @After
    public void attachReport(Scenario scenario) throws IOException {
        if(Files.exists(Path.of("report"))){
            File csvFile = new File("report/"+ConfigFactory.getConfig().getOutputFile());
            byte[] fileContent = Files.readAllBytes(csvFile.toPath());
            scenario.attach(fileContent, "text/plain", "Attached File");
        }
    }
}
