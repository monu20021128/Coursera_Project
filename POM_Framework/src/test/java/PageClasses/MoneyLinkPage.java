package PageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.RediffBaseClass;
import BaseClasses.TopMenuClass;

public class MoneyLinkPage extends RediffBaseClass {
	
	TopMenuClass topmenu;
	
	public MoneyLinkPage(WebDriver driver){
		this.driver=driver;
		topmenu=PageFactory.initElements(driver, TopMenuClass.class);
	}
	
	@FindBy(xpath="//span[@id='signin_info']/a[1]")
	public WebElement signinbtn;
	
	public PortfolioSignInPage clickSignin() {
		signinbtn.click();
		return PageFactory.initElements(driver, PortfolioSignInPage.class);	
	}
	
	public TopMenuClass getMenu() {
		return topmenu;	
		
	}
}
