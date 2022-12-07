package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	SeleniumPageFactory pf;
	WebDriver driver;

	@Given("open any browser")
	public void open_any_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);

	}

	@Given("go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Constants.URL);

	}

	@When("click sign in button")
	public void click_sign_in_button() {
		ScreenShot.getScreenShot(driver, "Home Page");
		// explicit wait=WebDriver wait
		pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSignin().get(0), 3);
		// click sign in
		HighLighter.getColor(driver, pf.getSignin().get(0));
		pf.getSignin().get(0).click();

	}

	@When("put email")
	public void put_email() {

		ScreenShot.getScreenShot(driver, "Login Page");
		//put user
		HighLighter.getColor(driver, pf.getUsername());
		pf.getUsername().click();
		pf.getUsername().sendKeys(Constants.user);

	}

	@When("put password")
	public void put_password() {
		HighLighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);

	}

	@When("click second sign in button")
	public void click_second_sign_in_button() {
		HighLighter.getColor(driver, pf.getSecondsignin());
		SeleniumWait.getExplicitWait(driver, pf.getSecondsignin(),5);
		pf.getSecondsignin().click();
		ScreenShot.getScreenShot(driver, "Login Validation");

	}

	@Then("validated login was succcessful")
	public void validated_login_was_succcessful() {
		HighLighter.getColor(driver, pf.getWelcome().get(0));
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
		

	}

}
