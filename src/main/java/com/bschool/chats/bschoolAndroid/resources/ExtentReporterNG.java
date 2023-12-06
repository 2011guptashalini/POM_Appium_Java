package com.bschool.chats.bschoolAndroid.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	

	
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Mobile Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Shalini");
		return extent;
		
		
		
	}
}
