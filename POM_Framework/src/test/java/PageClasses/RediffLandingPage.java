package PageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.RediffBaseClass;

public class RediffLandingPage extends RediffBaseClass{

	public RediffLandingPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(xpath="//div[@class='toplinks']/a[2]")
	public WebElement moneylink;
	
	public MoneyLinkPage clickMoneyLink() {
		moneylink.click();
		return PageFactory.initElements(driver, MoneyLinkPage.class);
	}
	
}
