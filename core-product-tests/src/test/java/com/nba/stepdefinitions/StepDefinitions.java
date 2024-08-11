package com.nba.stepdefinitions;

import com.nba.constants.MenuItems;
import com.nba.pages.HomePage;
import com.nba.pages.ShopPage;
import io.cucumber.java8.En;

public class StepDefinitions implements En {
    HomePage homePage;
    ShopPage shopPage;

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

        Then("^store all the results into a text file \"([^\"]*)\"$", (String arg0) -> {
            shopPage.getResults();
        });
        When("^User navigates to News and features$", () -> {
        });
        Then("^Go to Each page$", () -> {
        });
        And("^Count the total number of videos$", () -> {
        });

    }
}
