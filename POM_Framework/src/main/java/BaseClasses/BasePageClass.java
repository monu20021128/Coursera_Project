package BaseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReportManager;

public class BasePageClass {
	 public WebDriver driver;
		public WebDriverWait wait;
		public ExtentReports report= ExtentReportManager.getReportInstance();
		public ExtentTest logger;
		/****************** Invoke Browser ******************/
		
		public void invokeBrowser(String browserName) {
			
			try {
				if (browserName.equalsIgnoreCase("Chrome")) {
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\monus\\eclipse-workspace\\POM_Framework\\Drivers\\chromedriver.exe");
					
					driver = new ChromeDriver();
				} 	else {
					System.setProperty("webdriver.chrome.driver",
							"C:\\Users\\Prachi\\eclipse-workspace\\CourseraPOMFrameWorkProject\\Drivers\\msedgedriver.exe");
					driver = new EdgeDriver();
				}
			}
				
			
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
		
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().window().maximize();

			} 
		
		public HomePage OpenApplication() {
	        driver.get("https://www.coursera.org/");
	        return PageFactory.initElements(driver, HomePage.class);
	    }
		
		
		
		

		
		

}
