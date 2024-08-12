package com.nba.runners;

import com.nba.utilities.NbaTestListner;
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
        dryRun = false,
        tags = "@smoke2"
)
@Listeners(NbaTestListner.class)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
