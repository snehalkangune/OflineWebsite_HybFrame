package com.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.TestBase;

public class TestListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		log.info("Test case is starting with name:" + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test case is passed with name:" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		log.info("Test case is failed with name:" + result.getName());
		getScreenshot(result.getName());
		log.info("Screenshot Capture for failed testcase");
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test case is Skipped with name:" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext result) {
		log.info("Test suit Started");

	}

	public void onFinish(ITestContext arg0) {
		log.info("Test suit Finished");

	}

}
