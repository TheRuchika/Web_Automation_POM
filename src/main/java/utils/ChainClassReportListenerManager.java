package utils;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ChainClassReportListenerManager extends pages.Base.BaseClass implements ITestListener {


        public void onTestStart(ITestResult result) {
            ChainTestListener.log("Started test execution: " + result.getTestClass().getName() + " - " + result.getMethod());
        }

        public void onTestSuccess(ITestResult result) {
            ChainTestListener.log(result.getName() + " : Test case passed");
        }

        public void onTestFailure(ITestResult result) {
            ChainTestListener.log(result.getName() + " : Test case failed");
            ChainTestListener.embed(takeScreenshot(),"image/png");

        }

        public void onTestSkipped(ITestResult result){
            ChainTestListener.log(result.getName()+": Test case got skipped");
        }
    }
