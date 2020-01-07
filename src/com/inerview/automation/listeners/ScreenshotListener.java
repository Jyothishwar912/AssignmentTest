package com.inerview.automation.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("SUITE IS COMPLETED : " +arg0.getName());
	}
	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("SUITE IS STARTED : " +arg0.getName());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("BUILD : " +arg0.getName());
	}
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("TC IS FAILURE : " +arg0.getName());
		
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("TC IS SKIPPED : " +arg0.getName());
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("TC STARTED : " +arg0.getName());
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("TC IS PASSED : " +arg0.getName());
	}
}
