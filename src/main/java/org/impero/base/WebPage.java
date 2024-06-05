package org.impero.base;

import org.impero.pages.HomePage;
import org.impero.pages.ResultsPage;
import org.openqa.selenium.WebDriver;

public class WebPage
{
    private final HomePage homePage;
    private final ResultsPage resultsPage;

    public WebPage( WebDriver driver )
    {
        homePage = new HomePage( driver );
        resultsPage = new ResultsPage( driver );
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
