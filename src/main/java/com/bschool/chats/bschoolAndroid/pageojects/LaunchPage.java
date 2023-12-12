package com.bschool.chats.bschoolAndroid.pageojects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class LaunchPage extends AbstractComponents {
	
	AndroidDriver driver;
	public LaunchPage(AndroidDriver dr) {
		super(dr);
		this.driver = dr;
		PageFactory.initElements(dr, this);
	}
	// This needs to be changed
	
	
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"SkipVideoButton\"]")
	WebElement skip; //= driver.findElement(AppiumBy.accessibilityId("SkipVideoButton"));
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Login\"]")
	WebElement login;
	
	//Allow button
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	List<WebElement> allowButton;
	

	
	public void ClickSkip() {
		
		if (allowButton.size() > 0)
		{
			allowButton.get(0).click();
			skip.click();
		}
		else
			skip.click();
	}
	
	public void ClickLoginLink() {
		login.click();
	}
	
	// Reaching to login page
	public LoginPage goTo() {
		
		waitForAWhile(10);
		ClickSkip();
		waitForAWhile(5);
		ClickLoginLink();
		waitForAWhile(10);
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
		
	}

	
	

}
