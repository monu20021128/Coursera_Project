package BaseClasses;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import PageClasses.RediffLandingPage;


public class RediffBaseClass 
{
	public WebDriver driver;
	
	
	
	public void OpenBrowser() {
		System.setProperty("webdriver.driver.chromedriver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	public RediffLandingPage OpenWebsite(String websiteURL) {
		driver.get(websiteURL);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		return PageFactory.initElements(driver, RediffLandingPage.class);
	}
	
	public void GetTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}
	
	
}
