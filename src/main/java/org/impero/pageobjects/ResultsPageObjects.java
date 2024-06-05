package org.impero.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPageObjects
{
    WebDriver driver;

    public ResultsPageObjects( WebDriver driver )
    {
        this.driver = driver;
    }

    private final By textareaSearch = By.id( "APjFqb" );

    private final By tabImages = By.linkText( "Images" );


    public WebElement getTabImages()
    {
        return driver.findElement( tabImages );
    }

    public WebElement getTextareaSearch()
    {
        return driver.findElement( textareaSearch );
    }
}
