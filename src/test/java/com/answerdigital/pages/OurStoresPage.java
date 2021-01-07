package com.answerdigital.pages;

import com.answerdigital.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OurStoresPage extends BasePage {

    @FindBy(xpath = "//img[@src='http://maps.gstatic.com/mapfiles/transparent.png']/..")
    public List<WebElement> ourStorePoints;

    @FindBy(xpath = "//div[@class=\"gm-style-iw-d\"]/div/b")
    public WebElement ourStoreAddress;

    @FindBy(xpath = "//a[@title=\"Our stores\"]")
    public WebElement ourStores;

    @FindBy(css = ".dismissButton")
    public WebElement dismissButton;

    @FindBy(css=".page-heading")
    public WebElement pageSubTitle;


    public String getOurStoreAddress(String storeName) {

  //      ourStores.click();
        dismissButton.click();

        for(int i=0; i<=ourStorePoints.size();i++){

            BrowserUtils.waitForClickablility(ourStorePoints.get(i),10);
            ourStorePoints.get(i).click();
            BrowserUtils.waitForVisibility(ourStoreAddress,10);
            System.out.println("ourStoreAddress = " + ourStoreAddress.getText());
            if(ourStoreAddress.getText().equals(storeName)){
                break;
            }
        }
        return ourStoreAddress.getText();
    }

    public String getPageSubTitle(){

        return pageSubTitle.getText();
    }
}
