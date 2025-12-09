package Coursera_PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageLearning {

	WebDriver driver;
	
	public LanguageLearning(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//div/ul/li/a[text()='Free Courses']")
	public WebElement click_free_course;
	
	public FreeCoursesPage click_free_courses(){
	
		Assert.assertEquals(driver.getTitle(), "Language Learning Online Courses | Coursera");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		click_free_course.click();
		
		return PageFactory.initElements(driver, FreeCoursesPage.class);
	}
}
