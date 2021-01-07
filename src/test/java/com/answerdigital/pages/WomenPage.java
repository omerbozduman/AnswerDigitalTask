package com.answerdigital.pages;

import com.answerdigital.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class WomenPage extends BasePage {


    public void navigateToSubModule(String subModule){

        String subModuleLocator = "//a[@title='" + subModule+ "']";

        WebElement subModuleElement = Driver.get().findElement(By.xpath(subModuleLocator));
        subModuleElement.click();
    }

    String searchLocator;

    public String getSearchResults(String product){

        searchLocator = "//h1/span[contains(text(),'"+product+"')]";

        WebElement searchElement = Driver.get().findElement(By.xpath(searchLocator));

        return searchElement.getText();
    }

    public String getNumberOfSearchResults(){

        searchLocator=searchLocator+"/following-sibling::span";

        WebElement numberofSearchResult = Driver.get().findElement(By.xpath(searchLocator));

        return numberofSearchResult.getText();
    }


}
