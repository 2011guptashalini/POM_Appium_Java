package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class HomePage extends AbstractComponents {
	
	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(xpath="//android.widget.Button[@content-desc=\"Home, tab, 1 of 5\"]")
WebElement homeElement;


public Boolean VerifyHomePageDisplayed() {
	Boolean match = homeElement.isDisplayed();
	return match;

}

public EventPage goToEventPage() {
	
	clickEvents();
	EventPage eventPage = new EventPage(driver);
	return eventPage;
}

public ChatPage goToChatPage() {
	
	clickChat();
	ChatPage chatPage = new ChatPage(driver);
	return chatPage;
}


}
	
	

