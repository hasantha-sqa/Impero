package org.impero.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects
{
    WebDriver driver;

    public HomePageObjects( WebDriver driver )
    {
        this.driver = driver;
    }

    private static final By textareaSearch = By.id( "APjFqb" );

    public WebElement getTextareaSearch()
    {
        return driver.findElement( textareaSearch );
    }
}
