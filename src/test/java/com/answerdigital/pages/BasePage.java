package com.answerdigital.pages;

import com.answerdigital.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public String getPageTitle(){
        return Driver.get().getTitle();
    }

    Actions actions = new Actions(Driver.get());

    public void navigateToModule(String module) {

        String moduleLocator = "//a[@title='" + module + "']";
        WebElement moduleElement;
        if (module.equals("Dresses")) {
            moduleLocator = "//a[@title='" + module + "'](" + 2 + ")";
            moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
        } else {
            moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
        }
       actions.moveToElement(moduleElement).perform();

    }

    public void clickToModule(String module) {

        String moduleLocator = "//a[contains(text(),'" + module + "')]";
        WebElement moduleElement;

        if (module.equals("Dresses")) {
            moduleLocator = "//a[contains(text(),'" + module + "')](" + 2 + ")";
            moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
        } else {
            moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
        }

        actions.moveToElement(moduleElement).perform();
        actions.click().perform();
    }

    public void takeScreenShot(String fileName) throws IOException {

        File scrFile = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.FILE);
        String projectPath = System.getProperty("user.dir");
        String relativePath = "/target/capture/";
        String filePath=projectPath + relativePath;
        FileUtils.copyFile(scrFile, new File(filePath+fileName+".png"));
    }

}
