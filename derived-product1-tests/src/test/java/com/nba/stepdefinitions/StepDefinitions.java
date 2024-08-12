package com.nba.stepdefinitions;

import com.nba.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class StepDefinitions {
    HomePage homePage;


    @Given("User opens dp home page")
    public void userOpensDpHomePage() {
        homePage = new HomePage().loadPage();
    }

    @When("user validates the page has loaded")
    public void userValidatesThePageHasLoaded() {
        List<WebElement> slides = homePage.getSlides();
        assertEquals(slides.size(), 5);
    }

    @Then("count the number of slides")
    public void countTheNumberOfSlides() {
        homePage.getSlides().size();
    }

    @And("Count how much duration each slide is playing and validate with the expected duration of {int} seconds")
    public void countHowMuchDurationEachSlideIsPlayingAndValidateWithTheExpectedDurationOfSeconds(int acceptedDuration) {
        Map<String, Long> slideTime = homePage.getSlideTimes();
        SoftAssert softAssert = new SoftAssert();
        for (Map.Entry<String, Long> entry : slideTime.entrySet()) {
            System.out.println(entry.getValue());
            softAssert.assertTrue(entry.getValue() < acceptedDuration);
        }

        softAssert.assertAll();
    }
}
