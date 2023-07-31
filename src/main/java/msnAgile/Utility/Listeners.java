package msnAgile.Utility;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

	public void onTestSuccess(ITestResult tr) {
		System.out.println("test is passed");
		System.out.println("passed test from listner is " + tr.getName());

	}

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("test is failure");
		System.out.println("failed test from listner is " + tr.getName());

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("test is skipped");
		System.out.println("skipped test from listner is " + tr.getName());

	}

}
