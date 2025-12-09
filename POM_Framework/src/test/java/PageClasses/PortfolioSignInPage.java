package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.RediffBaseClass;
import BaseClasses.TopMenuClass;

public class PortfolioSignInPage extends RediffBaseClass{

	TopMenuClass topmenu;
	public PortfolioSignInPage(WebDriver driver){
		this.driver=driver;
		topmenu=PageFactory.initElements(driver, TopMenuClass.class);
	}
	
	@FindBy(id="useremail")
	public WebElement username;
	
	@FindBy(id="userpass")
	public WebElement password;
	
	@FindBy(id="loginsubmit")
	public WebElement submit;
	
	public MyPortfolioPage clickSubmit(String name,String pass) 
	{
		username.sendKeys(name);
		password.sendKeys(pass);
		submit.click();
		return PageFactory.initElements(driver, MyPortfolioPage.class);
	}
	
	public TopMenuClass getMenu() {
		return topmenu;	
	}	
}
