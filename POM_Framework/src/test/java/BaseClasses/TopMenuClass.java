package BaseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageClasses.NewsPage;
import PageClasses.PortfolioSignInPage;

public class TopMenuClass extends RediffBaseClass{
	
	public TopMenuClass(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	@FindBy(xpath="//*/span[@class='navlink first ']/a")
	public WebElement newsLink;
	
	@FindBy(xpath="//span[@class='navlink']/a[text()='My Portfolio']")
	public WebElement myportfolioLink;
	
	public NewsPage clickNewsLink() {
		newsLink.click();
		return PageFactory.initElements(driver, NewsPage.class);
	}
	
	public PortfolioSignInPage clickMyportfolioLink() {
		myportfolioLink.click();
		return PageFactory.initElements(driver, PortfolioSignInPage.class);
	}

	public PortfolioSignInPage clickSignIn() throws InterruptedException
	{
		WebElement clickSignin=driver.findElement(By.xpath("//span[@id='signin_info']/a[1]"));
		clickSignin.click();
		return PageFactory.initElements(driver, PortfolioSignInPage.class);
	}
	
}
