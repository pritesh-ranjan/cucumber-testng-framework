package com.nba.stepdefinitions;

import com.nba.constants.MenuItems;
import com.nba.pages.HomePage;
import com.nba.pages.NewsPage;
import com.nba.pages.ShopPage;
import com.nba.utilities.ConfigFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java8.En;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class StepDefinitions implements En {
    HomePage homePage;
    ShopPage shopPage;
    NewsPage newsPage;

    public StepDefinitions() {

        Given("^User opens the core product url$", () -> {
            homePage = new HomePage().loadPage();
            homePage.closeAllPopups();
        });

        When("^User navigates to the Shop And men section", () -> {
            homePage.openMenu(MenuItems.SHOP).openMenSection();
        });

        And("^Searches for \"([^\"]*)\"$", (String keyword) -> {
            shopPage = new ShopPage().switchToShopWindow().searchFor(keyword);
        });

        Then("^store all the results into a text file", () -> {
            shopPage.getResults();
        });

        When("^User navigates to News and features$", () -> {
            newsPage = homePage.openMenu(MenuItems.THREE_DOT_MENU).openNewsAndFeatures();
        });
        Then("^Count the total number of feeds in page$", () -> {
            newsPage.getTotalFeedsCount();
        });
        And("^Count the feeds older than (\\d+) days$", (Integer age) -> {
            newsPage.getFeedsCountByAge(age);
        });

    }
}
