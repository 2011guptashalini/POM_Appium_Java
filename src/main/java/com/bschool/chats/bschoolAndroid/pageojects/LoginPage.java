package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends AbstractComponents {
	
	AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// This needs to be changed
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"EmailLoginEditField\"]")
	WebElement school_email;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"PasswordLoginEditField\"]")
	WebElement password_ele;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]")
	WebElement loginButton;
	
	// login to the app
	public HomePage loginApplication(String email, String password) {
		waitForAWhile(10);
		school_email.sendKeys(email);
		waitForAWhile(10);
		password_ele.sendKeys(password);
		waitForAWhile(10);
		loginButton.click();
		waitForAWhile(20);
		HomePage homePage = new HomePage(driver);
		return homePage;
		
		
	}
	
	
	

}
