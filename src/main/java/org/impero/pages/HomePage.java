package org.impero.pages;

import io.qameta.allure.Allure;
import org.impero.pageobjects.HomePageObjects;
import org.impero.util.Configs;
import org.impero.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class HomePage
{
    WebDriver driver;
    HomePageObjects homePageObjects;

    public HomePage( WebDriver driver )
    {
        this.driver = driver;
        homePageObjects = new HomePageObjects( driver );
    }

    public void verifyLoadedHomePage() throws IOException
    {
        Allure.attachment("HomePage", TestUtil.takeScreenshot(driver));

        Allure.step( "Assert the Loaded URL" );
        Assert.assertEquals( this.driver.getCurrentUrl(), Configs.URL );

        Allure.step( "Assert the Page Title" );
        Assert.assertEquals( this.driver.getTitle(), Configs.PAGE_TITLE );
    }

    public void typeSearchKeywordAndClickEnter(String keyword)
    {
        Allure.step( "Type Keyword to Search and Press ENTER" );
        homePageObjects.getTextareaSearch().sendKeys( keyword, Keys.RETURN );
    }
}
