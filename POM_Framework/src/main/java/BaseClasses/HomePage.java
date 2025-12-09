package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import PageClasses.GovernmentPage;

public class HomePage extends BasePageClass{
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// Government page link
    @FindBy(xpath = "//div[@role = 'navigation']//ul/li[4]//a")
    public WebElement governmentLink;
    
    public GovernmentPage goToGovernmentPage() {
        governmentLink.click();
        return PageFactory.initElements(driver, GovernmentPage.class);
    }


}
