package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class CostcoAutomation {

	public static void productHandle() {
		WebDriver driver;
		SeleniumPageFactory pf;
		// go to https://www.costco.com/
	
		
		driver = DriverManager.getBrowser("chrome");
		pf = new SeleniumPageFactory(driver);
		driver.manage().window().maximize();
		driver.navigate().to(Constants.COSTCO_URL);
		SeleniumWait.getImplicitWait(driver, 5);

		// get the page name=>title>getTitle()
		System.out.println("Home page title/name = " + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco home welcome page");
		// check current URL is matched or not => getCurrentURL()
		// driver.getCurrentUrl();
		System.out.println("Current page URL =" + driver.getCurrentUrl());
		// expectation =
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(driver.getCurrentUrl(), Constants.COSTCO_URL);
		// go to sign in page
		
		SeleniumWait.getExplicitWait(driver, pf.getCostcoSignin().get(0), 60);
		HighLighter.getColor(driver, pf.getCostcoSignin().get(0), "red");
		pf.getCostcoSignin().get(0).click();
		
		// get the page name
		System.out.println("Login page title/name =" + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco Sign in page");
		// 6= go back to the home page> navigate().back()
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		while (true) {
			if (pf.getCostcoSignin().size() > 0) {
				break;
			} else {
				driver.navigate().back();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}
		// no 7
		System.out.println("Menu count = " + pf.getCostcoMenuBtn().size());

		for (int i = 0; i < pf.getCostcoMenuBtn().size(); i++) {
			HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "white");
			System.out.println(pf.getCostcoMenuBtn().get(i).getText());

		}
		//8 If the deal was there, then mouse over it and read all options
		
		for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
			if(pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {
				HighLighter.getColor(driver,pf.getCostcoMenuBtn().get(i), "red");
				Actions ac =new Actions(driver);
				ac.moveToElement(pf.getCostcoMenuBtn().get(i)).perform();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("Deal options count="+pf.getCostcoDealBtn().size());
		for (int j = 0; j<pf.getCostcoDealBtn().size();j++) {
			HighLighter.getColor(driver,pf.getCostcoDealBtn().get(j), "red");
			System.out.println(pf.getCostcoDealBtn().get(j).getText());
			
		}
		
		//9 if computer section was there inside the deal, then click it
		
		pf.getComputers().get(0).click();
			

		sf.assertAll();
	}

	public static void main(String[] args) {
		productHandle();

	}
}
