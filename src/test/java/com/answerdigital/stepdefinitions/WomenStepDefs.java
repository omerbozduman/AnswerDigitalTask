package com.answerdigital.stepdefinitions;

import com.answerdigital.pages.WomenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WomenStepDefs {

    WomenPage womenPage = new WomenPage();

    @When("the user navigate to {string} module")
    public void the_user_navigate_to_module(String module) {
        womenPage.navigateToModule(module);
    }


    @When("the user navigate to {string} sub module")
    public void the_user_navigate_to_sub_module(String subModule) {

        womenPage.navigateToSubModule(subModule);

    }
    @Then("verify the {string} is displayed")
    public void verify_the_is_displayed(String product) {

        String expectedSearchResult = product.toUpperCase().concat(" ");
        String actulaSearchresult = womenPage.getSearchResults(product);
        Assert.assertEquals("verify search result", expectedSearchResult,actulaSearchresult);

    }

    @And("verify that {string} is displayed")
    public void verifyThatIsDisplayed(String expectedNumberOfSearchResult) {
        String actualNumberOfSerachresult = womenPage.getNumberOfSearchResults();
        Assert.assertEquals("verify search result", expectedNumberOfSearchResult,actualNumberOfSerachresult);
    }



}
