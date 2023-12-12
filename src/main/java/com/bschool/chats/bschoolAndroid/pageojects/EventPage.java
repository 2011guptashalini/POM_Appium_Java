package com.bschool.chats.bschoolAndroid.pageojects;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;


public class EventPage extends AbstractComponents {
	
	AndroidDriver driver;
	
	//Random selecton of events
	List<String> myEvents = Arrays.asList("Technical meet", "Happiest hour", "Dreamtechno", "Project Exhibitions"
			,"Gear Game","Innovatenations","Mini dirt races", "Design comptetions","Debate on some technical topics", "Techfairs"
			,"Technovas", "TechTonight","YoTechnos","TechFestivals","Tfests","Quantums","Radiances","RendezvouXs","Revelations","Revelatiiis","Technovanzas","Xeniums","Xtremes","Xpression","Zests"
);
	Random e = new Random();

    int randomitem = e.nextInt(myEvents.size());
    String EventName = myEvents.get(randomitem);
    
    
    //Links
    List<String> myLinks = Arrays.asList("www.google.com", "www.bschool.com", "www.facebook.com");

	Random l = new Random();

    int randomLinks = l.nextInt(myLinks.size());
    String Link = myLinks.get(randomLinks);
    
    String eventComment = "Nice Event";
    
    String shortDescription = "Meeting to connect with MBA students";
    
	
	public EventPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//This needs to be changed
	

    // Events label
	@FindBy(xpath="(//android.widget.TextView[@text=\"Events\"])[1]")
	WebElement eventPageElement;	

	//All events button
	@FindBy(xpath="//android.widget.TextView[@text=\"All Events\"]")
	WebElement allEventElement;

	//Past events
	@FindBy(xpath="//android.widget.TextView[@text=\"Past Events\"]")
	WebElement pastEventElement;

	//Date element
	@FindBy(xpath="//android.widget.TextView[@text=\"26\"]")
	WebElement dateElement;


	
	//Add event button
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"AddEventButton\"]")
	WebElement addEventElement;
	
	// Add Image 
	@FindBy(xpath="//android.widget.TextView[@text=\"Add Image\"]")
	WebElement addEvenAddImageElement;
	
	//Click Photo of phone 
	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/app_icon\"])[2]")
	WebElement addEvenPhotoElement;
	
	//Add recent photo
	//@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/icon_thumb\"]")
	//@FindBy(id="com.google.android.providers.media.module:id/icon_thumbnail")
	//WebElement addEventRecentElement;
	
	//Photo click
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Photos\"]")
	WebElement photos;
	
	// Select photo
	@FindBy(xpath="//android.view.View[@resource-id=\"com.google.android.apps.photos:id/image\"]")
	WebElement selectPhoto;
	
	//cancel photo
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Cancel\"]")
	WebElement cancelPhoto;
	
	//Back button
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	WebElement navigateUp;
	
	//Event Name Text box
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"EventName\"]")
	WebElement addEventNameElement;

	//Select type dropdown
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"EventsSelectTypeButton\"]")
	WebElement addEventSelectTypeElement;
	
	//Select type public element
	@FindBy(xpath="//android.widget.TextView[@text=\"Public\"]")
	WebElement addEventSelectTypePublicElement;
	
	//Select category
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"EventsSelectCategory\"]")
	WebElement addEventSelectCategoryElement;
	
	//Select category as entertainment
	@FindBy(xpath="//android.widget.TextView[@text=\"Entertainment\"]")
	WebElement addEventSelectCategoryEntertainmentElement;
	
	//Select start date and time
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"EventsSelectStartDateTimeButton\"]")
	WebElement addEventStartTimeAndDateElement;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Select Day\"]")
	WebElement addEventSelectDateOverlay;
	
	//Select Done
	@FindBy(xpath="//android.widget.TextView[@text=\"Done\"]")
	WebElement addEventSelectDateDoneElement;
	
	
	//Select end date time and date
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"SelectEventsEndTime\" and @text=\"End Time and date\"]")
	WebElement addEventEndTimeAndDateElement;
	
	//Short description
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"EventsShortDescription\"]")
	WebElement addEventShortDescriptionElement;
	
	//Location
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Select Location\"]")
	WebElement addEventSelectLocationElement;
	
	//Location text box
	@FindBy(xpath="//android.widget.EditText[@text=\"Type a place\"]")
	WebElement addEventTypeLocationElement;
	
	//Create Event button
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"CreateEventSubmitButton\"]")
	WebElement addEventCreateEventElement;
	
	//Deny button
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
	WebElement addEventDenyElement;
	
	//Ok Button
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	WebElement addEventOKElement;
	
	//Select date
	@FindBy(xpath="//android.view.View[@content-desc=\"Select Day\"]")
	WebElement addEventSelectDate;
	
	
	//Edit event elements
	
	//Edit button
	@FindBy(xpath="//android.widget.TextView[@text=\"Edit\"]")
	WebElement editEventEditButtonElement;
	
	//Select category
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
	WebElement editEventEditCategory;
	
	//Select education
	@FindBy(xpath="//android.widget.TextView[@text=\"Education\"]")
	WebElement editEventSelectEducation;
	
	//Update event
	@FindBy(xpath="//android.widget.TextView[@text=\"Update Event\"]")
	WebElement editEventUpdateEvent;
	
	//Add link
	@FindBy(xpath="//android.widget.TextView[@text=\"Add Link\"]")
	WebElement editEventAddLinkElement;
	
	//Add link text box
	@FindBy(xpath="//android.widget.EditText[@text=\"Enter Link\"]")
	WebElement editEventLinkTextboxElement;
	
	//Save button on add link pop up
	@FindBy(xpath="//android.widget.TextView[@text=\"Save\"]")
	WebElement editEventAddLinkSaveElement;
	
	//Added link on edit mode
	@FindBy(xpath="//android.widget.TextView[@text=\"www.google.com\"]")
	WebElement editEventAddedLinkOnEditElement;
	
	//Added link on Saved mode
	@FindBy(xpath="(//android.widget.TextView[@text=\"null\"])[2]")
	WebElement editEventAddedLinkOnSaveElement;
	
	
	
	//Read Information
	@FindBy(xpath="//android.widget.TextView[@text=\"This is a short description\"]")
	WebElement readInfoShortDescription;
	
	//Discussion and Comment
	@FindBy(xpath="//android.widget.TextView[@text=\"Discussion\"]")
	WebElement discussionTab;
	
	
	//Discussion Tab
	@FindBy(xpath="//android.widget.TextView[@text=\"Discussion\"]")
	WebElement discussion;
	
	//Write comment here text box
	@FindBy(xpath="//android.widget.EditText[@text=\"Write comment here…\"]")
	WebElement commentTextbox;
	
	//Send comment
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")
	WebElement sendComment;
	
	//Read comment
	@FindBy(xpath="//android.widget.TextView[@text=\"Nice Event\"]")
	WebElement readComment;
	
	//Go back to events page 
	@FindBy(xpath="")
	WebElement goBack;
	
	// Click three dots
	@FindBy(xpath="//android.widget.TextView[@text=\"...\"]")
	WebElement threeDots;
	
	//Delete event button
	@FindBy(xpath="//android.widget.TextView[@text=\"Delete\"]")
	WebElement deleteEvent;
	
	//Yes button on delete event confirmation popup
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	WebElement yesButton;
	
	//List view
  	@FindBy(xpath="//android.widget.TextView[@content-desc=\"List view\"]")
  	List<WebElement> listView;
  	
  	//Pick photo
  	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"s8-tweet.jpg\"]")
  	WebElement pickPhoto;
  	
  	//Calendar to get focus
  	@FindBy(xpath="//android.widget.TextView[@resource-id=\"undefined.header.title\"]")
  	WebElement calGetFocus;
	


	//Methods
	
	public WebElement dynamicXpathGenerator(String str) {
		String xpathStr = "\"" + str + "\"";
		WebElement dynamicXpathEvent = driver.findElement(By.xpath("//android.widget.TextView[@text="+xpathStr+"]"));
		return dynamicXpathEvent;
	}
	


	public void clickAddEvent() {
		addEventElement.click();
	}
	
	 public void addImage() throws IOException, InterruptedException {
	    	addEvenAddImageElement.click();
			driver.pullFile("/sdcard/Pictures/s8-tweet.jpg");
			//if(listView.size()>0)
			//{
			    listView.get(0).click();
				waitForAWhile(30);
				pickPhoto.click();
		        waitForAWhile(30);
		        
			//}
			//else 
			//{
			//	addEventRecentElement.click();
			//	waitForAWhile(30);
		        
			//}
	 }
	
	//Method to fill details of event
	public void addEventDetails() throws InterruptedException {
		
		waitForAWhile(10);
		addEventNameElement.sendKeys(EventName);
		waitForAWhile(10);
		addEventSelectTypeElement.click();
		waitForAWhile(10);
		addEventSelectTypePublicElement.click();
		waitForAWhile(10);
		addEventSelectCategoryElement.click();
		waitForAWhile(10);
		addEventSelectCategoryEntertainmentElement.click();
		waitForAWhile(10);
		addEventStartTimeAndDateElement.click();
		waitForAWhile(10);
		addEventSelectDateDoneElement.click();
		waitForAWhile(60);
		
		addEventEndTimeAndDateElement.click();
		swipeUpDate(); 
		waitForAWhile(20);
		addEventSelectDateDoneElement.click();
		
		addEventShortDescriptionElement.sendKeys(shortDescription);	
		waitForAWhile(10);
		scroll(ScrollDirection.DOWN, 0.5);
		
	}

	
	//Method to create event and handling google related stuff
	public void createEvent()
	{
		waitForAWhile(10);
		addEventCreateEventElement.click();
		waitForAWhile(10);
		addEventDenyElement.click();
		waitForAWhile(10);
		addEventOKElement.click();	
		waitForAWhile(40);
		//calGetFocus.sendKeys(Keys.SHIFT);
		scroll(ScrollDirection.DOWN, 0.8);
		scroll(ScrollDirection.DOWN, 0.8);
		
		//js.executeScript("calGetFocus.focus();");
		
		
	}
	
	
	
	//Edit event test methods
	
	public void openAddedEvent() {
		waitForAWhile(10);
		WebElement addedEvent = dynamicXpathGenerator(EventName);
		addedEvent.click();
	}
	
	public void reachToAddedEvent() {
		waitForAWhile(10);
		WebElement addedEvent = dynamicXpathGenerator(EventName);
	
	}
	
	
	public void ClickEditButton() {
		waitForAWhile(10);
		editEventEditButtonElement.click();
					
		
	}
	
	public void goBackinApp() {
		//driver.navigate().back();
		driver.longPressKey(new KeyEvent(AndroidKey.BACK));
		waitForAWhile(10);
		
	}
	
	
	
	public void deleteEvent() {
		reachToAddedEvent();
		clickThreeDots();
		clickDelete();
		confirmDelete();
	}
	
	//Update category
	public void UpdateCategory()
	{
		waitForAWhile(10);
		editEventEditCategory.click();
		waitForAWhile(10);
		editEventSelectEducation.click();	
	}
	
	//Update link to the event	
	public void UpdatingLink() {
		
		waitForAWhile(20);
		editEventAddLinkElement.click();
		waitForAWhile(10);
		editEventLinkTextboxElement.sendKeys(Link);
		waitForAWhile(10);
		editEventAddLinkSaveElement.click();
		waitForAWhile(10);
		scroll(ScrollDirection.DOWN, 0.5);
		editEventUpdateEvent.click();
			
	}
	
	// Read Description
	
    public String EventDescriptionIs() {
		
		WebElement shortDescriptionElement = dynamicXpathGenerator(shortDescription);
		String shrotDescriptionGot = shortDescriptionElement.getText();
		return shrotDescriptionGot;
		
	}
    public Boolean EventDescriptionIsDisplayed() {
		
		WebElement shortDescriptionElement = dynamicXpathGenerator(shortDescription);
		Boolean match = shortDescriptionElement.isDisplayed();
		return match;
		
	}
    //Navigate to discussion
    public void navigateDiscussion() {
    waitForAWhile(20);
    discussion.click();
    
    
    }
    
    //Write comment
    public void writeCommentForEvent()
    {
    	 waitForAWhile(20);
    	 commentTextbox.sendKeys(eventComment);
    	 waitForAWhile(20);
    	 sendComment.click();  	 
    	 waitForAWhile(20);
    	 
    }
    
    //Go back to events page
    public void goBackToEvents()
    {
    	goBack.click();
    }
    
    
    //Read comment
    
  public Boolean readCommentIsDisplayed() {
		
		WebElement displayedCommentElement = dynamicXpathGenerator(eventComment);
		String displayedComment = displayedCommentElement.getText();
		Boolean match = displayedComment.equals(eventComment);
		return match;
		
	}
  
  //click three dots
  
  public void clickThreeDots()
  {
	  threeDots.click();
  }
    
  public void clickDelete()
  {
	  deleteEvent.click();
  }
   
  public void confirmDelete()
  {
	  yesButton.click();
  }
    
    
	
	
	//Assertions
	
	//public Boolean VerifyPhotoOptionsDisplayed() {

	//	Boolean match = addEventRecentElement.isDisplayed();
	//	return match;

	//}
	
	public Boolean VerifyImageIsUploaded() {

		Boolean match = addEventNameElement.isDisplayed();
		return match;

	}
	
	public Boolean VerifyEventPageDisplayed() {

		Boolean match = eventPageElement.isDisplayed();
		return match;

	}
	
	public Boolean VerifyAllEventDisplayed() {
		Boolean match = allEventElement.isDisplayed();
		return match;

	}
	public Boolean VerifyPastEventDisplayed() {
		Boolean match = pastEventElement.isDisplayed();
		return match;

	}
	
	
	public Boolean VerifyEventIsAdded() {
		
		
		WebElement addedEvent = dynamicXpathGenerator(EventName);
		Boolean match = addedEvent.isDisplayed();
		return match;
		
	}
	
	
	//It will click on add link and assert that add link popup is displayed
	public Boolean AddLinkPopupIsDisplayed() {
		waitForAWhile(20);
		scroll(ScrollDirection.DOWN, 0.5);
		editEventAddLinkElement.click();
		waitForAWhile(10);
		Boolean match = editEventAddLinkSaveElement.isDisplayed();
		return match;
		
	}
	
	//Asserting category is updated
	public Boolean CategoryUpdatedAfterSaveIsDisplayed() {
		waitForAWhile(10);
		Boolean match = editEventSelectEducation.isDisplayed();
		return match;
	}
	
	
	//Asserting links is updated and displayed after updating event
	public Boolean AddedLinkAfterUpdatingIsDisplayed() {
		
		waitForAWhile(10);
		WebElement linkAfterSave = dynamicXpathGenerator(Link);
		Boolean match = linkAfterSave.isDisplayed();
		return match;
		
	}
	

}
