package Utilities;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {
	
	public static ExtentReports getReportInstance()
	{		
		
			String reportName= DateUtils.getTimeStamp()+".html";
			
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\"+reportName);
			ExtentReports report = new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("OS", "Windows 11");
			report.setSystemInfo("Environment", "Integration Testing");
			report.setSystemInfo("Build Number", "12.5.4");
			report.setSystemInfo("Browser", "Chrome");
						
			htmlReporter.config().setDocumentTitle("Integration Testing Automation Results");
			htmlReporter.config().setReportName("All Integration Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			
			return report;
	}
}
