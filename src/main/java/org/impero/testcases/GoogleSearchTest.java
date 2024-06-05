package org.impero.testcases;

import com.google.gson.JsonObject;
import org.impero.base.BaseTest;
import org.impero.listener.TestListener;
import org.impero.util.JsonDataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners( TestListener.class )
public class GoogleSearchTest extends BaseTest
{

    @Test( dataProvider = "GoogleSearch", dataProviderClass = JsonDataProvider.class )
    public void verifyGoogleSearchForImages( JsonObject data ) throws IOException
    {
        webPage.getHomePage().verifyLoadedHomePage();
        webPage.getHomePage().typeSearchKeywordAndClickEnter( data.get( "keyword" ).getAsString() );

        webPage.getResultsPage().verifyCorrectSearchResult( data.get( "keyword" ).getAsString() );
        webPage.getResultsPage().clickImageTab();
    }
}
