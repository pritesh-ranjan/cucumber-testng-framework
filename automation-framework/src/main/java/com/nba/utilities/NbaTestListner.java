package com.nba.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class NbaTestListner implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("HELLOW");
//        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
    }
}
