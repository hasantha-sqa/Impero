package org.impero.base;

import org.impero.pages.HomePage;
import org.impero.pages.ResultsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WebPage
{
    private final HomePage homePage;
    private final ResultsPage resultsPage;

    public WebPage( WebDriver driver )
    {
        FluentWait<WebDriver> fluentWait = new FluentWait<>( driver )
                                                   .withTimeout( Duration.ofSeconds( 15 ) )
                                                   .pollingEvery( Duration.ofSeconds( 1 ) )
                                                   .ignoring( NoSuchElementException.class );

        homePage = new HomePage( driver, fluentWait );
        resultsPage = new ResultsPage( driver, fluentWait );
    }

    public HomePage getHomePage()
    {
        return homePage;
    }

    public ResultsPage getResultsPage()
    {
        return resultsPage;
    }

}
