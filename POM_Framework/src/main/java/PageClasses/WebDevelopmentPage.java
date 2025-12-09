package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDevelopmentPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div/button[@aria-label='Explore our catalog']")
    public WebElement explore_btn;

    @FindBy(linkText = "Language Learning")
    public WebElement lang_learning;

    public WebDevelopmentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void openwebsite() {
        driver.get("https://www.coursera.org/search?query=Web%20development&language=English&productDifficultyLevel=Beginner&sortBy=BEST_MATCH");
    }

    public LanguageLearning click_language_learning() {
        // Hover on Explore
        wait.until(ExpectedConditions.visibilityOf(explore_btn));
        Actions action = new Actions(driver);
        action.moveToElement(explore_btn).build().perform();

        // Click Language Learning
        wait.until(ExpectedConditions.elementToBeClickable(lang_learning));
        lang_learning.click();

        return new LanguageLearning(driver);
    }
}
