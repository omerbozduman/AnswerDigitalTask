package com.answerdigital.stepdefinitions;

import com.answerdigital.pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class MyAccountStepDefs {

    MyAccountPage myAccountPage = new MyAccountPage();

    @And("the user click the create an account button with valid email address")
    public void theUserClickTheCreateAnAccountButtonWithValidEmailAddress() {
        myAccountPage.clickCreateAnAccount();

    }

    @Then("the user fills the form with valid personal information")
    public void theUserFillsTheFormWithValidPersonalInformation() {

        myAccountPage.fillTheForm();
    }

    @And("the user clicks the register button")
    public void theUserClicksTheRegisterButton() {
        myAccountPage.registerButton.click();
    }

    @And("the user should see account name on top right")
    public void theUserShouldSeeAccountNameOnTopRight() {

        String expectedAccountName = myAccountPage.firstName + " " + myAccountPage.lastName;
        String actualAccountName = myAccountPage.accountName.getText();

        Assert.assertEquals("verify account name", expectedAccountName,actualAccountName);
    }

    @And("the user click the create an account button with {string}")
    public void theUserClickTheCreateAnAccountButtonWith(String emailAddress) {
    }

    @And("the user fills the form with {string} and {string}")
    public void theUserFillsTheFormWithAnd(String data, String field) {
        myAccountPage.fillTheForm(data,field);
    }

    @Then("verify that related {string} is displayed")
    public void verifyThatRelatedIsDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = myAccountPage.formErrorMessage.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        Assert.assertEquals("verify registration error message " ,expectedErrorMessage,actualErrorMessage);
    }

    @Then("the user click the create an account button with invalid email address")
    public void the_user_click_the_create_an_account_button_with_invalid_email_address(String email){
        myAccountPage.clickCreateAnAccount(email);
    }


    @Then("verify error message is {string}")
    public void verifyErrorMessageIs(String expectedErrorMessage) {
        String actualErrorMessage = myAccountPage.createAccountError.getText();
        Assert.assertEquals("verify error message" ,expectedErrorMessage,actualErrorMessage);
    }


}
