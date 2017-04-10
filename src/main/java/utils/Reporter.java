package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter extends ReportConfig {

	public static ExtentReports extent;
	public String testCaseName, testDescription, category;
	public ExtentTest test;

	public void reportStep(String desc, String status) {
		long snapNumber = 100000l;

		try {
			snapNumber = takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// Write if it is successful or failure or information
			if (status.toUpperCase().equals("PASS")) {
				test.log(Status.PASS,
						desc, MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".jpg").build());
			} else if (status.toUpperCase().equals("FAIL")) {
				test.log(Status.FAIL,
						desc, MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".jpg").build());
				throw new RuntimeException("FAILED");
			} else if (status.toUpperCase().equals("INFO")) {
				test.log(Status.INFO, desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract long takeScreenshot();
	
	public ExtentReports startResult(){

		String reportPath = "..\\sofa\\Reports\\";

		String reportName = "extent_" + new SimpleDateFormat("dd_mm_yyyy_hhmmss").format(new Date()) + ".html";


		File report = new File(reportPath + reportName);
		
		htmlReporter = new ExtentHtmlReporter(report);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("os", "win7");
		
		return extent;
	}

	
	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.createTest(testCaseName, testDescription);
		return test;
	}
	
	public void endResult(){		
		extent.flush();
	}
	

	
}
