package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.RediffBaseClass;
import BaseClasses.TopMenuClass;

public class NewsPage extends RediffBaseClass{

	TopMenuClass topmenu;
	public NewsPage(WebDriver driver){
		this.driver=driver;
		topmenu=PageFactory.initElements(driver, TopMenuClass.class);
	}
	public TopMenuClass getMenu() {
		return topmenu;	
	}
}
