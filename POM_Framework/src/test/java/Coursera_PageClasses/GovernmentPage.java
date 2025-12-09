package Coursera_PageClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Coursera_BaseClasses.PageBaseClass;

public class GovernmentPage extends PageBaseClass {

    WebDriverWait wait;

    public GovernmentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- Form Fields ---------- //
    
    
    @FindBy(id = "FirstName") 
    public WebElement firstNameInput;
    
    
    @FindBy(id = "LastName") 
    public WebElement lastNameInput;
    
    
    @FindBy(id = "Email") 
    public WebElement workEmailInput;
    
    
    @FindBy(id = "Phone") 
    public WebElement phoneNOInput;
    
    
    @FindBy(id = "rentalField9") 
    public WebElement organizationTypeDropdown;
    
    
    @FindBy(id = "Title") 
    public WebElement jobTitleInput;
    
    
    @FindBy(id = "Company") 
    public WebElement organizationName;
    
    
    @FindBy(id = "Employee_Range__c") 
    public WebElement organizationSizeDropdown;
    
    
    @FindBy(id = "What_the_lead_asked_for_on_the_website__c") 
    public WebElement needDropdown;
    
    
    @FindBy(id = "Self_reported_employees_to_buy_for__c") 
    public WebElement expectedLearnersInput;
    
    
    @FindBy(id = "rentalField5") 
    public WebElement describeNeedInput;
    
    
    @FindBy(id = "Country") 
    public WebElement countryDropdown;
    
    
    @FindBy(id = "State") 
    public WebElement stateDropdown;
    
    
    @FindBy(xpath = "//span//button[@type = 'submit']") 
    public WebElement requestInfoButton;

    // Error messages
    @FindBy(id = "ValidMsgTitle") 
    public WebElement requiredFieldError;
    @FindBy(id = "ValidMsgEmail")
    public WebElement invalidEmailError;

    // ---------- Methods ---------- //

    // Scroll to the  Info Button
    public void scrollToForm() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", requestInfoButton);
    }

    //input Methods
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameInput)).clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterWorkEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(workEmailInput)).clear();
        workEmailInput.sendKeys(email);
    }

    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneNOInput)).clear();
        phoneNOInput.sendKeys(phone);
    }

    public void enterJobTitle(String jobTitle) {
        wait.until(ExpectedConditions.visibilityOf(jobTitleInput)).clear();
        jobTitleInput.sendKeys(jobTitle);
    }

    public void enterOrganizationName(String orgName) {
        wait.until(ExpectedConditions.visibilityOf(organizationName)).clear();
        organizationName.sendKeys(orgName);
    }

    public void enterDescribeNeed(String description) {
        wait.until(ExpectedConditions.visibilityOf(describeNeedInput));
        try {
            describeNeedInput.clear();
            describeNeedInput.sendKeys(description);
        } catch (Exception e) {
           
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value=arguments[1];", describeNeedInput, description);
        }
    }

    // Dropdown 
    public void selectOrganizationType(String type) {
        wait.until(ExpectedConditions.elementToBeClickable(organizationTypeDropdown));
        new Select(organizationTypeDropdown).selectByVisibleText(type);
    }

    public void selectOrganizationSize(String size) {
        wait.until(ExpectedConditions.visibilityOf(organizationSizeDropdown));
        new Select(organizationSizeDropdown).selectByVisibleText(size);
    }

    public void selectNeed(String need) {
        wait.until(ExpectedConditions.elementToBeClickable(needDropdown));
        new Select(needDropdown).selectByVisibleText(need);
    }

    public void selectExpectedLearners(String number) {
        wait.until(ExpectedConditions.visibilityOf(expectedLearnersInput));
        new Select(expectedLearnersInput).selectByVisibleText(number);
    }

    public void selectCountry(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
        new Select(countryDropdown).selectByVisibleText(country);
    }

    public void selectState(String state) {
        wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
        new Select(stateDropdown).selectByVisibleText(state);
    }

    // Click  Request Info button
    public void clickRequestInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(requestInfoButton)).click();
     
    }


 // Submit form and capture Work Email validation error
    public void submitFormAndCaptureEmailError() throws IOException {
        try {
        	
            requestInfoButton.click();
            Thread.sleep(2000);
            
            // Work Email error message
            By emailErrorLocator = By.id("ValidMsgEmail");
            WebElement emailError = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(emailErrorLocator)
            );

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center', behavior:'smooth'});",
                    emailError
            );

         
            takeScreenShot();

            System.out.println("Email error displayed: " + emailError.getText());
            
            


        } catch (Exception e) {
            takeScreenShot();
            throw new AssertionError("Email validation failed: " + e.getMessage());
        }
        finally {
            driver.quit();  
        }
    }

    // Screenshot 
    public void takeScreenShot() throws IOException {
        String filePath = System.getProperty("user.dir") + "/Screenshots/" + generateFile();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(filePath));
    }

    public String generateFile() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".png";
    }

}
