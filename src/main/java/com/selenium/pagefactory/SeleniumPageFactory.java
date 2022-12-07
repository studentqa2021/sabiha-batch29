package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	
	WebDriver driver;
	public SeleniumPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//Luma website
	@FindBy(xpath = "//*[@class='authorization-link']")
	private List<WebElement> signin;

	@FindBy(xpath = "//*[@id='email']")
	private WebElement username;

	@FindBy(xpath = "//*[@title='Password']")
	private WebElement password;

	@FindBy(xpath = "//*[@class='action login primary']")
	private WebElement secondsignin;

	@FindBy(xpath = "//*[@class='greet welcome']")
	private List<WebElement> welcome;
	

	public List<WebElement> getSignin() {
		return signin;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSecondsignin() {
		return secondsignin;
	}

	public List<WebElement> getWelcome() {
		return welcome;
	}

	//Coscto web page
	
	public List<WebElement> getCostcoSignin() {
		return CostcoSignin;
	}

	public List<WebElement> getCostcoMenuBtn() {
		return CostcoMenuBtn;
	}
	
	public List<WebElement> getCostcoDealBtn() {
	return CostcoDealBtn;
	}
	public List<WebElement> getComputers() {
		return Computers;
	}
	
	@FindBy(xpath = "//*[text()='Sign In / Register']")
	private List<WebElement> CostcoSignin;

	@FindBy(xpath = "//*[@id='navigation-widget']//a" )
	private List<WebElement> CostcoMenuBtn;

	@FindBy(xpath = "//*[@class='sub-item']")
	private List<WebElement> CostcoDealBtn;

	@FindBy (xpath = "//*[text()='Computers']") 
	private List<WebElement> Computers;
	

	public void setComputers(List<WebElement> computers) {
		Computers = computers;
	}
	
	}
	
	
	

	

