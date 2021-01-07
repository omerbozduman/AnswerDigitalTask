package com.answerdigital.stepdefinitions;

import com.answerdigital.pages.MyBasketPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyBasketStepDefs {

    MyBasketPage myBasketPage = new MyBasketPage();
    
    @Given("the user is on {string} homepage")
    public void the_user_is_on_homepage(String expectedPageTitle) {
        Assert.assertEquals("verify page title" ,expectedPageTitle, myBasketPage.getPageTitle());
    }

    @When("the user select {int} random product")
    public void theUserSelectRandomProduct(int numberOfSelection) {
        myBasketPage.selectProduct(numberOfSelection);
    }

    @Then("the user checks the shopping cart")
    public void the_user_checks_the_shopping_cart() {

        myBasketPage.checkTheShoppingCart();
    }
    @Then("verify that shopping cart is not empty")
    public void verify_that_shopping_cart_is_not_empty() {

        Assert.assertNotEquals("verify cart is not empty" , myBasketPage.numberOfItem,0);
        
    }
    @Then("the user check the shopping cart has {string} button")
    public void the_user_check_the_shopping_cart_has_button(String button) {

        Assert.assertTrue(myBasketPage.checkTheButton());
        
    }
    @Then("the user remove the items from the shopping cart")
    public void the_user_remove_the_items_from_the_shopping_cart() {
        myBasketPage.removeProductFromCart();
        
    }
    @Then("verify that shopping cart is empty")
    public void verifyThatShoppingCartIsEmpty() {
        myBasketPage.viewMyCart.click();
        Assert.assertEquals("verify cart is empty" , myBasketPage.numberOfItem,0);
    }

    @Then("verify banner should display {string}")
    public void verify_banner_should_display(String expectedMessage) {

        Assert.assertEquals("verify cart message",expectedMessage, myBasketPage.getAlertMessage());
        
    }


}
