package Coursera_PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Coursera_BaseClasses.PageBaseClass;
import Coursera_PageClasses.GovernmentPage;
import Coursera_PageClasses.WebDevelopementPage;

public class HomePage extends PageBaseClass{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Web Development link
	public WebDevelopementPage searchCourse()
	{
		WebElement search_area=driver.findElement(By.xpath("//*/div[@class='react-autosuggest__container']/input[@class='react-autosuggest__input']"));
		search_area.sendKeys("Web Development");
		
		WebElement search_btn=driver.findElement(By.xpath("//*/button[@class='nostyle search-button']/div[@class='magnifier-wrapper']"));
		search_btn.click();
		
		return PageFactory.initElements(driver, WebDevelopementPage.class);
	}
	
	// Government page link
	@FindBy(xpath = "//div[@role = 'navigation']//ul/li[4]//a")
    public WebElement governmentLink;
	
    public GovernmentPage  goToGovernmentPage() {
    	governmentLink.click();
    	return PageFactory.initElements(driver, GovernmentPage.class);
    	
    }

}
