package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {

	public void getLogin(){
		//open a browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		// go to URL
		driver.navigate().to(Constants.URL);
		
		ScreenShot.getScreenShot(driver, "Home Page");
		//explicit wait=WebDriver wait
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSignin().get(0), 3);
		//click sign in
		HighLighter.getColor(driver, pf.getSignin().get(0));
		pf.getSignin().get(0).click();
		
		ScreenShot.getScreenShot(driver, "Login Page");
		//put user
		HighLighter.getColor(driver, pf.getUsername());
		pf.getUsername().click();
		pf.getUsername().sendKeys(Constants.user);
		//put pass
		HighLighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
		//click second sign in
		HighLighter.getColor(driver, pf.getSecondsignin());
		SeleniumWait.getExplicitWait(driver, pf.getSecondsignin(),5);
		pf.getSecondsignin().click();
		ScreenShot.getScreenShot(driver, "Login Validation");
		//validation	
		HighLighter.getColor(driver, pf.getWelcome().get(0));
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
		
	}
		
	}

