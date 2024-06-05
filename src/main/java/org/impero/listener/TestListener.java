package org.impero.listener;

import io.qameta.allure.Allure;
import org.impero.base.BaseTest;
import org.impero.util.TestUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener
{
    @Override
    public void onTestSuccess( ITestResult result )
    {
        try
        {
            Allure.attachment( "TestSuccess", TestUtil.takeScreenshot( getDriver() ) );
        }
        catch( Exception ignored )
        {
        }
    }

    @Override
    public void onTestFailure( ITestResult result )
    {
        try
        {
            Allure.attachment( "TestFailure", TestUtil.takeScreenshot( getDriver() ) );
        }
        catch( Exception ignored )
        {
        }
    }

    @Override
    public void onTestSkipped( ITestResult result )
    {
        try
        {
            Allure.attachment( "TestSkipped", TestUtil.takeScreenshot( getDriver() ) );
        }
        catch( Exception ignored )
        {
        }
    }
}
