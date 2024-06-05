package org.impero.base;

import io.qameta.allure.Allure;
import org.impero.util.Configs;
import org.impero.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest
{

    protected WebDriver driver;
    public WebPage webPage;

    @Parameters( { "browser" } )
    @BeforeMethod
    public void initDriver( @Optional( "chrome" ) String browser )
    {
        initializeWebDriver( browser );

        Allure.step( "Navigate to URL : " + Configs.URL );
        driver.navigate().to( Configs.URL );

        webPage = new WebPage( driver );
    }

    @AfterMethod
    public void quitDriver()
    {
        Allure.step( "Quit Browser" );
        driver.close();
        driver.quit();
    }

    public void initializeWebDriver( String browser )
    {
        switch( browser )
        {
            case "chrome":
                Allure.step( "Initialize Chrome Driver" );
                driver = new ChromeDriver();
                break;
            case "firefox":
                Allure.step( "Initialize FireFox Driver" );
                driver = new FirefoxDriver();
                break;
            case "edge":
                Allure.step( "Initialize Edge Driver" );
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException( "Unsupported browser: " + browser );
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds( TestUtil.PAGE_LOAD_TIMEOUT ) );
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( TestUtil.IMPLICIT_WAIT ) );
    }
}
