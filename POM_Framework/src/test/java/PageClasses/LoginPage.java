package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void passValues() {
		//Verify Page title
				String loginPagetitle=driver.getTitle();
				Assert.assertEquals(loginPagetitle, "Rediffmail - Free Email for Login with Secure Access");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				WebElement email=driver.findElement(By.id("login1"));
				email.sendKeys("monusahu2811@gmail.com");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				WebElement pass=driver.findElement(By.id("password"));
				pass.sendKeys("#Monu@2811");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void clickLogin() throws InterruptedException 
	{
		WebElement clickLogin=driver.findElement(By.className("signin-btn"));
		clickLogin.click();
		Thread.sleep(10000);
//		return PageFactory.initElements(driver, MailPage.class);
	}
	
}
