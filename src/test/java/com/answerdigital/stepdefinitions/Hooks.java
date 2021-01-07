package com.answerdigital.stepdefinitions;

import com.answerdigital.utilities.ConfigurationReader;
import com.answerdigital.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before ()
    public void setUp() {

        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @After
    public void tearDown(){

        Driver.closeDriver();
    }


}
