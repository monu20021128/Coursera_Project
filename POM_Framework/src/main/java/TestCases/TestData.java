package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClasses.BasePageClass;
import BaseClasses.HomePage;
import PageClasses.FreeCoursesPage;
import PageClasses.GovernmentPage;
import PageClasses.LanguageLearning;
import PageClasses.WebDevelopmentPage;

public class TestData extends BasePageClass{

    @Test
    public void runCompleteFlow() throws InterruptedException, IOException {
        
    	 //Invoke browser
        BasePageClass pageBase = new BasePageClass();
        
    	logger=report.createTest("Test One");
    	
        logger.log(Status.INFO, "Initializing the Browser");
        pageBase.invokeBrowser("Chrome");

        // Language Learning → Free Courses
        WebDevelopmentPage webDev = new WebDevelopmentPage(pageBase.driver);
        
        logger.log(Status.INFO, "Opening Coursera");
        webDev.openwebsite(); 

        
        LanguageLearning langPage = new LanguageLearning(pageBase.driver);
        
        logger.log(Status.INFO, "Hover on Explore and Click to Language Learning");
        langPage = webDev.click_language_learning();

        
        FreeCoursesPage freePage = new FreeCoursesPage(pageBase.driver);
        
        logger.log(Status.INFO, "Scroll and Click Free courses Link");
        freePage = langPage.click_free_courses();

        logger.log(Status.INFO, "Extract the information of available courses");
        freePage.extractdata(); // Extract course info

        //Navigate to HomePage and Government page
        HomePage home = PageFactory.initElements(pageBase.driver, HomePage.class);
        
        logger.log(Status.INFO, "Click on 'For Government' Link on Top");
        GovernmentPage gov = home.goToGovernmentPage();

        // Scroll to the form
        logger.log(Status.INFO, "Scroll to Form");
        gov.scrollToForm();

        // Fill the form 
        
        logger.log(Status.INFO, "Enter details in form");
        gov.enterFirstName("Vinamra");
        gov.enterLastName("Dholam");
        gov.enterWorkEmail("vinamradholam@gmail.com");  // Invalid email to test validation
        gov.enterPhoneNumber("9876543210");
        gov.selectOrganizationType("Government");
        gov.enterJobTitle("Tester");
        gov.enterOrganizationName("Infosys");
        gov.selectOrganizationSize("1-500");
        gov.selectNeed("Other");
        gov.selectExpectedLearners("26-100");
        gov.enterDescribeNeed("Need training for new employees");
        gov.selectCountry("India");
        gov.selectState("Maharashtra");

        //Submit form and capture screenshot on validation error
        logger.log(Status.FAIL, "Test Case Pass");
        gov.submitFormAndCaptureEmailError();
        
    }
    
    @AfterMethod
    public void flush() {
    	report.flush();
    }
}

