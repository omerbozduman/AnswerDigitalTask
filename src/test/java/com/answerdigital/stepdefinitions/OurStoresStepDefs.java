package com.answerdigital.stepdefinitions;

import com.answerdigital.pages.OurStoresPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class OurStoresStepDefs {

    OurStoresPage ourStoresPage = new OurStoresPage();

    @When("the user navigate to {string} page")
    public void theUserNavigateToPage(String module) {

        ourStoresPage.clickToModule(module);
    }

    @Then("verify that page subtitle is {string}")
    public void verifyThatPageSubtitleIs(String expectedPageSubTitle) {

        Assert.assertEquals("verify page subtitle", expectedPageSubTitle.toUpperCase(), ourStoresPage.getPageSubTitle());
    }

    @And("the user checks the {string} store is on the map")
    public void theUserChecksTheStoreIsOnTheMap(String storeName) {
        ourStoresPage.getOurStoreAddress(storeName);
    }

    @And("take screenshot of {string} address")
    public void takeScreenshotOfAddress(String fileName) throws IOException {
        ourStoresPage.takeScreenShot(fileName);
    }
}
