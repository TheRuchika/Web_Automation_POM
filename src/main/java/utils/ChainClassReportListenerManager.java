package utils;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Base.BaseClass;

/**
 * ChainClassReportListenerManager
 *
 * TestNG Listener used to integrate ChainTest reporting.
 *
 * Responsibilities:
 * - Log test start, success, failure, and skip events
 * - Capture screenshots on test failure
 *
 * This listener works in combination with BaseClass utilities.
 */
public class ChainClassReportListenerManager extends BaseClass implements ITestListener {

    /**
     * Triggered when a test method starts execution.
     */
    @Override
    public void onTestStart(ITestResult result) {
        ChainTestListener.log(
                "Started test execution: "
                        + result.getTestClass().getName()
                        + " - "
                        + result.getMethod().getMethodName()
        );
    }

    /**
     * Triggered when a test method passes successfully.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        ChainTestListener.log(result.getName() + " : Test case passed");
    }

    /**
     * Triggered when a test method fails.
     * Captures and attaches a screenshot to the report.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        ChainTestListener.log(result.getName() + " : Test case failed");

        // Attach screenshot to ChainTest report
        ChainTestListener.embed(takeScreenshot(), "image/png");
    }

    /**
     * Triggered when a test method is skipped.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        ChainTestListener.log(result.getName() + " : Test case got skipped");
    }
}
