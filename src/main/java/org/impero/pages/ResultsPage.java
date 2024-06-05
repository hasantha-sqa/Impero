package org.impero.pages;

import io.qameta.allure.Allure;
import org.impero.pageobjects.ResultsPageObjects;
import org.impero.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.io.IOException;

public class ResultsPage
{

    WebDriver driver;

    FluentWait<WebDriver> fluentWait;

    ResultsPageObjects resultsPageObjects;

    public ResultsPage( WebDriver driver, FluentWait<WebDriver> fluentWait )
    {
        this.driver = driver;
        this.fluentWait = fluentWait;
        resultsPageObjects = new ResultsPageObjects( driver );
    }

    public void verifyCorrectSearchResult( String keyword ) throws IOException
    {
        fluentWait.until( ExpectedConditions.visibilityOf( resultsPageObjects.getTextareaSearch() ) );

        Allure.attachment( "ResultsPage", TestUtil.takeScreenshot( driver ) );

        Allure.step( "Assert the Keyword in Search Results" );
        Assert.assertEquals( resultsPageObjects.getTextareaSearch().getText(), keyword );
    }

    public void clickImageTab() throws IOException
    {
        Allure.step( "Click Image Tab" );
        resultsPageObjects.getTabImages().click();

        Allure.attachment( "ImageTab", TestUtil.takeScreenshot( driver ) );
    }
}
