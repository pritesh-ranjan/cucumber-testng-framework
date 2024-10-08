package com.nba.runner;

import com.nba.utilities.NbaTestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        snippets = CAMELCASE,
        plugin = {
                "json:target/cucumber-report.json",
                "html:target/cucumber-reports/report.html"},
        features = "src/test/resources/features",
        glue = {"com.nba.stepdefinitions", "com.nba.utilities"},
        monochrome = true,
        dryRun = false
)
@Listeners(NbaTestListener.class)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
