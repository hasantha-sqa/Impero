package org.impero.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{
    @Override
    public void onTestSuccess( ITestResult result )
    {
        System.out.println( "TestSuccess" );
    }

    @Override
    public void onTestFailure( ITestResult result )
    {
        System.out.println( "TestFailure" );
    }

    @Override
    public void onTestSkipped( ITestResult result )
    {
        System.out.println( "TestSkipped" );
    }

}
