package com.answerdigital.pages;

import com.answerdigital.utilities.BrowserUtils;
import com.answerdigital.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyBasketPage extends BasePage {

    @FindBy(className = "shopping_cart")
    public WebElement shoppingCart;

    @FindBy(className = "ajax_cart_no_product")
    public WebElement cartIsEmpty;

    @FindBy(className = "ajax_cart_quantity")
    public WebElement cartQuantity;

    @FindBy(className = "ajax_cart_product_txt")
    public WebElement oneProduct;

    @FindBy(className = "ajax_cart_product_txt_s")
    public WebElement moreThanOneProduct;

    @FindBy(className = "product_img_link")
    public List<WebElement> productList;

    @FindBy(xpath = "//span[contains(text(),\"Add to cart\")]")
    public List<WebElement> addToCart;

    @FindBy(xpath = "//span[@title=\"Close window\"]")
    public WebElement closeWindow;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    public WebElement viewMyCart;

    @FindBy(id="button_order_cart")
    public WebElement checkOutButton;

    @FindBy(xpath = "//a[@title='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[@title='Delete']")
    public List<WebElement> deleteButtonList;

    @FindBy(className = "alert")
     public WebElement alertMessage;


    Actions actions = new Actions(Driver.get());

    public int numberOfItem;

    public void checkTheShoppingCart(){



        if(cartIsEmpty.getText().equals("(empty)")){
            numberOfItem= 0;
        }else {
            BrowserUtils.waitForVisibility(cartQuantity,10);
            numberOfItem=Integer.parseInt(cartQuantity.getText());
            System.out.println("numberOfItem = " + numberOfItem);
        }
    }

    public void selectProduct(int numberOfSelection){

        for(int i=1; i<=numberOfSelection; i++) {
            BrowserUtils.waitForClickablility(productList.get(i),10);
            actions.moveToElement(productList.get(i)).perform();
            BrowserUtils.waitForClickablility(addToCart.get(i),10);
            addToCart.get(i).click();
            BrowserUtils.waitForClickablility(closeWindow,10);
            closeWindow.click();
        }
    }

    public boolean checkTheButton(){

        boolean flag;
        actions.moveToElement(viewMyCart).perform();
        BrowserUtils.waitForClickablility(checkOutButton,10);
        checkOutButton.click();

        if(deleteButton.isEnabled()){
            flag=true;
        }else {
            flag=false;
        }
        return flag;
    }

    public void removeProductFromCart(){
        System.out.println("numberOfItem = " + numberOfItem);
        if(numberOfItem>1){
            for (WebElement delete : deleteButtonList) {
                BrowserUtils.waitForVisibility(delete,10);
                delete.click();
            }
        }else {
            deleteButton.click();
        }
    }


    public String getAlertMessage(){
        BrowserUtils.waitForVisibility(alertMessage,10);
        return alertMessage.getText();
    }


}
