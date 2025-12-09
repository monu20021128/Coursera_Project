package MailTests;

import org.testng.annotations.Test;

import BaseClasses.RediffBaseClass;
import BaseClasses.TopMenuClass;
import PageClasses.MoneyLinkPage;
import PageClasses.MyPortfolioPage;
import PageClasses.NewsPage;
import PageClasses.PortfolioSignInPage;
import PageClasses.RediffLandingPage;

public class TestRediff 
{	
	
	@Test
	public void TestRediff() throws InterruptedException 
	{
		RediffBaseClass baseclass=new RediffBaseClass();
		TopMenuClass topMenu;
		baseclass.OpenBrowser();
		RediffLandingPage landingpage=baseclass.OpenWebsite("https://www.rediff.com/");
		baseclass.GetTitle("Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");
		
		MoneyLinkPage moneylinkpage=landingpage.clickMoneyLink();
		topMenu=moneylinkpage.getMenu();
		Thread.sleep(2000);
		PortfolioSignInPage signInPage=topMenu.clickMyportfolioLink();
		Thread.sleep(2000);
		
		topMenu=signInPage.getMenu();
		NewsPage newspage=topMenu.clickNewsLink();		
		Thread.sleep(2000);
		
		TopMenuClass topMenu3=newspage.getMenu();
		PortfolioSignInPage signInPage2=topMenu3.clickSignIn();
		signInPage2.clickSubmit("monusahu2811","#Monu@2811");		
		Thread.sleep(5000);
	}	
}
