package Coursera_PageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCoursesPage {

//	Remaining for only extracting data of courses
	
	public WebDriver driver;

	@FindBy(xpath="//*/div[@class='css-1oiads2']/button[@data-testid='chip-button-inactive']/div[text()='Topic']")
	public WebElement topic;
	
	@FindBy(xpath="//div[@class='cds-checkboxAndRadio-labelText']/span/span[text()='Language Learning']")
	public WebElement lang_learn_chkbox;
	
	@FindBy(xpath="//*/div/button/span[text()='View']")
	public WebElement viewbtn;
	
	@FindBy(xpath="//div[@class='cds-9 css-0 cds-11 cds-grid-item']/a[@data-testid='home-logo']")
	public WebElement coursera;
	
	public FreeCoursesPage(WebDriver driver) {
		this.driver=driver;
	}

	public HomePage extractdata() throws InterruptedException{

		topic.click();
		lang_learn_chkbox.click();
		viewbtn.click();
	
//		Extract data of courses
		List<WebElement> courses=driver.findElements(By.xpath("//*/div[@id='searchResults']/div/div/ul/li"));
		for(int i=0;i<courses.size();i++)
		{
			
			
			WebElement course=courses.get(i);
			
			String Cname=course.findElement(By.xpath("//*/div/a/h3")).getText();
			String Crating=course.findElement(By.xpath("//*/div[@class='cds-ProductCard-footer']/div/div/span")).getText();
			String Creview=course.findElement(By.xpath("//*/div[@class='cds-ProductCard-footer']/div/div[2]")).getText();
			String Cduration=course.findElement(By.xpath("//*/div[@class='cds-ProductCard-footer']/div[3]/p")).getText();
			
//			int serial_no=i+1;
//			System.out.println(serial_no+")");
			System.out.println("Course Name: "+Cname);
			System.out.println("Course Rating: "+Crating);
			System.out.println("Course Reviews: "+Creview);
			System.out.println("Course Duration: "+Cduration);
//			System.out.println();
			
		}
		
		coursera.click();
		return PageFactory.initElements(driver, HomePage.class);
	}

}
