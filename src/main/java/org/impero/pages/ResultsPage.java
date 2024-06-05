package org.impero.pages;

import io.qameta.allure.Allure;
import org.impero.pageobjects.ResultsPageObjects;
import org.impero.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class ResultsPage
{

    WebDriver driver;
    ResultsPageObjects resultsPageObjects;

    public ResultsPage( WebDriver driver )
    {
        this.driver = driver;
        resultsPageObjects = new ResultsPageObjects( driver );
    }

    public void verifyCorrectSearchResult( String keyword ) throws IOException
    {
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
