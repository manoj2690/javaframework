package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportConfig {

	static ExtentHtmlReporter htmlReporter;
	
	public static void configHtmlReporter() {

		
        htmlReporter.setAppendExisting(true); 
        
        htmlReporter.config().setChartVisibilityOnOpen(true);
        
		htmlReporter.config().setDocumentTitle("SOFA Report");

		// encoding, default = UTF-8
		htmlReporter.config().setEncoding("UTF-8");

		/*// protocol (http, https)
		htmlReporter.config().setProtocol(Protocol.HTTPS);*/
		
		// report or build name
		htmlReporter.config().setReportName("SOFA Report");

		// chart location - top, bottom
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

		// theme - standard, dark
		htmlReporter.config().setTheme(Theme.DARK);

		// set timeStamp format
		htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");

		// add custom css
		htmlReporter.config().setCSS("css-string");

		// add custom javascript
		htmlReporter.config().setJS("js-string");
		
	}

}
