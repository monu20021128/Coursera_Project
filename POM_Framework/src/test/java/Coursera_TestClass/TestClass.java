package Coursera_TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Coursera_BaseClasses.PageBaseClass;
import Coursera_PageClasses.HomePage;
import Coursera_PageClasses.FreeCoursesPage;
import Coursera_PageClasses.GovernmentPage;
import Coursera_PageClasses.LanguageLearning;
import Coursera_PageClasses.WebDevelopementPage;
import Coursera_PageClasses.HomePage;

public class TestClass extends PageBaseClass{

	@Test
	public void coursera() throws InterruptedException, IOException {

		logger=report.createTest("Test One");
		PageBaseClass page=new PageBaseClass();
		
		logger.log(Status.INFO, "Initializing the Browser");
		page.invokeBrowser("Chrome");
		
		logger.log(Status.INFO, "Opening Coursera");
		HomePage home=page.OpenApplication();
		
		logger.log(Status.INFO, "Seaching Course");
		WebDevelopementPage web=home.searchCourse();
		
		logger.log(Status.INFO, "Hover on Explore and Click to Language Learning");
		LanguageLearning langlearn=web.click_language_learning();
		
		logger.log(Status.INFO, "Scroll and Click Free courses Link");
		FreeCoursesPage free=langlearn.click_free_courses();
		
		logger.log(Status.INFO, "Extract the information of available courses");
		HomePage home2=free.extractdata();
		
		logger.log(Status.INFO, "Click on 'For Government' Link on Top");
		GovernmentPage gov=home2.goToGovernmentPage();
		

		// Scroll to the form
		logger.log(Status.INFO, "Scroll to Form");
		gov.scrollToForm();

//		 Fill the form with test data
		logger.log(Status.INFO, "Enter details in form");
		
        gov.enterFirstName("Monu");
        gov.enterLastName("Sahu");
		gov.enterWorkEmail("abc"); // Invalid email to test validation
        gov.enterPhoneNumber("7447207375");
        gov.selectOrganizationType("Government");
        gov.enterJobTitle("Tester");
        gov.enterOrganizationName("Infosys");
        gov.selectOrganizationSize("1-500");
        gov.selectNeed("Other");
        gov.selectExpectedLearners("26-100");
        gov.enterDescribeNeed("Need training for new employees");
        gov.selectCountry("India");
        
        logger.log(Status.FAIL, "Test Case Pass");
        gov.submitFormAndCaptureEmailError();    
	}
	
	@AfterMethod
    public void flush() {
    	report.flush();
    }
}
