package com.nba.stepdefinitions;

import com.nba.pages.HomePage;
import com.nba.utilities.ConfigFactory;
import com.opencsv.CSVWriter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class StepDefinitions {
    HomePage homePage;

    @Given("User loads the page")
    public void userLoadsThePage() {
        homePage = new HomePage().loadPage();
    }

    @When("User scrolls to the bottom of page")
    public void userScrollsToTheBottomOfPage() {
        homePage.scrollToBottom();
    }

    @And("store them in a file")
    public void storeThemInAFile() {
    }

    @Then("User verifies all links are visible and store them in a file")
    public void userVerifiesAllLinksAreVisibleAndStoreThemInAFile() throws IOException {
        Map<String, String> categoryLinkMap = homePage.getCategoryLinkMap();
        Files.createDirectories(Path.of("report"));
        File csvFile = new File("report"+ "/" + ConfigFactory.getConfig().getOutputFile());

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            String[] header = {"Category", "Link"};
            writer.writeNext(header);

            for (Map.Entry<String, String> entry : categoryLinkMap.entrySet()) {
                Assertions.assertThat(entry.getKey()).isNotEmpty();
                String[] line = {entry.getValue(), entry.getKey()};
                writer.writeNext(line);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("User verifies all links are visible and store them in a file \"<out.csv>>")
    public void userVerifiesAllLinksAreVisibleAndStoreThemInAFileOutCsv() throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }


}
