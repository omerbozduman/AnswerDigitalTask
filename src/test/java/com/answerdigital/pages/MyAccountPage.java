package com.answerdigital.pages;

import com.answerdigital.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    @FindBy(id="email_create")
    public WebElement emailAddressBox;

    @FindBy(id ="SubmitCreate")
    public WebElement createAnAccountButton;

    @FindBy(id ="id_gender1")
    public WebElement titleButtonOfMr;

    @FindBy(id ="id_gender2")
    public WebElement titleButtonofMrs;

    @FindBy(id="customer_firstname")
    public WebElement customerFirstNameBox;

    @FindBy(id="customer_lastname")
    public WebElement customerLastNameBox;

    @FindBy(id="email")
    public WebElement emailBox;

    @FindBy(id="passwd")
    public WebElement passwordBox;

    @FindBy(id="days")
    public WebElement daysButton;

    @FindBy(id="months")
    public WebElement monthsButton;

    @FindBy(id="years")
    public WebElement yearsButton;

    @FindBy(id="firstname")
    public WebElement firstNameBox;

    @FindBy(id="lastname")
    public WebElement lastNameBox;

    @FindBy(id="company")
    public WebElement companyNameBox;

    @FindBy(id="address1")
    public WebElement addressBox;

    @FindBy(id="address2")
    public WebElement addressLine2Box;

    @FindBy(id="city")
    public WebElement cityBox;

    @FindBy(id="id_state")
    public WebElement stateOption;

    @FindBy(id="postcode")
    public WebElement postcodeBox;

    @FindBy(id="id_country")
    public WebElement countryOption;

    @FindBy(id="other")
    public WebElement additionalInformationBox;

    @FindBy(id="phone")
    public WebElement homePhone;

    @FindBy(id="phone_mobile")
    public WebElement mobilePhone;

    @FindBy(id="alias")
    public WebElement futureReferenceAddress;

    @FindBy(id="submitAccount")
    public WebElement registerButton;

    @FindBy(css=".account")
    public WebElement accountName;

    @FindBy(xpath = "//div[@id='create_account_error']/ol/li")
    public WebElement createAccountError;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    public WebElement formErrorMessage;

    Faker faker = new Faker();
    String emailAddress= faker.internet().emailAddress();

    public void clickCreateAnAccount(){
        emailAddressBox.sendKeys(emailAddress);
        createAnAccountButton.click();
    }

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();

    public void fillTheForm(){
        titleButtonOfMr.click();
        customerFirstNameBox.sendKeys(firstName);
        customerLastNameBox.sendKeys(lastName);
        passwordBox.sendKeys(faker.lorem().characters(6,16));
        daysButton.click();
        selectBirthDay("10");
        monthsButton.click();
        selectBirthMonth("8");
        yearsButton.click();
        selectBirthYear("1990");
        firstNameBox.sendKeys(firstName);
        lastNameBox.sendKeys(lastName);
        companyNameBox.sendKeys(faker.company().name());
        addressBox.sendKeys(faker.address().fullAddress());
        addressLine2Box.sendKeys(faker.address().buildingNumber());
        cityBox.sendKeys(faker.address().city());
        stateOption.click();
        selectState("Arizona");
        postcodeBox.sendKeys("73726");
        additionalInformationBox.sendKeys("I am the new customer");
        homePhone.sendKeys("640-070-0653");
        mobilePhone.sendKeys("717-772-8474");
        futureReferenceAddress.sendKeys("My Address");

    }


    public void selectBirthDay(String day){
        String locatorDay = "//select[@id='days']/option[@value='"+day+"']";
        WebElement dayElement = Driver.get().findElement(By.xpath(locatorDay));
        dayElement.click();
    }
    public void selectBirthMonth(String month){
        String locatorMonth = "//select[@id='months']/option[@value='"+month+"']";
        WebElement monthElement = Driver.get().findElement(By.xpath(locatorMonth));
        monthElement.click();

    }
    public void selectBirthYear(String year){
        String locatorYear = "//select[@id='years']/option[@value='"+year+"']";
        WebElement yearElement= Driver.get().findElement(By.xpath(locatorYear));
        yearElement.click();
    }

    public void selectState(String stateName){
        String locatorState = "//select[@id='id_state']/option[contains(text(),'"+stateName+"')]";
        WebElement stateElement = Driver.get().findElement(By.xpath(locatorState));
        stateElement.click();
    }

    public void clickCreateAnAccount(String email){
        emailAddressBox.sendKeys(email);
        createAnAccountButton.click();
    }

    public void fillTheForm(String data, String field){
        titleButtonOfMr.click();
        if(field.equals("first name")){
            customerFirstNameBox.sendKeys(data);
        }else {
            customerFirstNameBox.sendKeys(firstName);
        }
        if(field.equals("last name")){
            customerLastNameBox.sendKeys(data);
        }else {
            customerLastNameBox.sendKeys(lastName);
        }
        if(field.equals("password")){
            passwordBox.sendKeys(data);
        }else {
            passwordBox.sendKeys(faker.lorem().characters(6, 16));
        }
        daysButton.click();
        selectBirthDay("10");
        monthsButton.click();
        selectBirthMonth("8");
        yearsButton.click();
        selectBirthYear("1990");
        if(field.equals("first name")){
            firstNameBox.sendKeys(data);
        }else {
            firstNameBox.sendKeys(firstName);
        }
        if(field.equals("last name")){
            lastNameBox.sendKeys(data);
        }else {
            lastNameBox.sendKeys(lastName);
        }
        companyNameBox.sendKeys(faker.company().name());
        if(field.equals("address")){
            addressBox.sendKeys(data);
        }else {
            addressBox.sendKeys(faker.address().fullAddress());
        }
        addressLine2Box.sendKeys(faker.address().buildingNumber());
        if(field.equals("city")){
            cityBox.sendKeys(data);
        }else {
            cityBox.sendKeys(faker.address().city());
        }
        if(field.equals("state")){
            stateOption.click();
        }else {
            stateOption.click();
            selectState("Arizona");
        }
        if(field.equals("postcode")){
            postcodeBox.sendKeys(data);
        }else {
            postcodeBox.sendKeys("73726");
        }
        additionalInformationBox.sendKeys("I am the new customer");

        if(field.equals("mobile phone")){
            if(data.isEmpty()){
                mobilePhone.sendKeys(data);
                homePhone.sendKeys(data);
            }else {
                mobilePhone.sendKeys(data);
                homePhone.sendKeys("640-070-0653");
            }
        }else {
            mobilePhone.sendKeys("717-772-8474");
            homePhone.sendKeys("640-070-0653");
        }
        futureReferenceAddress.sendKeys("My Address");
    }

}
