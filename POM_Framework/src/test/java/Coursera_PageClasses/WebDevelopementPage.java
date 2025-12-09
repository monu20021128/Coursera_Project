package Coursera_PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WebDevelopementPage {

	WebDriver driver;
	
	public WebDevelopementPage(WebDriver driver) {
		this.driver = driver;
	}
	

//    Hover part
	@FindBy(xpath="//*/div/button[@aria-label='Explore our catalog']")
	public WebElement explore_btn;
	@FindBy(linkText="Language Learning")
	public WebElement lang_learning;
	
	public LanguageLearning click_language_learning() {
		
		Actions action = new Actions(driver);
		action.moveToElement(explore_btn).build().perform();
		lang_learning.click();
		
		return PageFactory.initElements(driver, LanguageLearning.class);	
	}
}
