package com.bschool.chats.bschoolAndroid.pageojects;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;
import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents.ScrollDirection;

import io.appium.java_client.android.AndroidDriver;

public class ChatPage extends AbstractComponents {
	
	AndroidDriver driver;
	public ChatPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	List<String> myGroups = Arrays.asList("MBA Association",
			"Consulting Club",
			"Entrepreneurship Society",
			"Finance Club",
			"Marketing Association",
			"Technology and Innovation Club",
			"Healthcare Management Club",
			"International Business Club",
			"Social Impact Club",
			"Women in Business"
);
	Random e = new Random();

    int randomitem = e.nextInt(myGroups.size());
    String GroupName = myGroups.get(randomitem);
	
	//Chat heading
	@FindBy(xpath="(//android.widget.TextView[@text=\"Chats\"])[1]")
	WebElement chatHeading;
	
	//Recent tab
	@FindBy(xpath="//android.widget.TextView[@text=\"RECENT\"]")
	WebElement recentTab;
	
	//All chats tab
	@FindBy(xpath="//android.widget.TextView[@text=\"ALL CHATS\"]")
	WebElement allChatsTab;
	
	//Create group chat
	@FindBy(xpath="//android.widget.TextView[@text=\"Create Chat\"]")
	WebElement createChat;
	
	//All chats tab
	@FindBy(xpath="//android.widget.TextView[@text=\"BOISE STATE UNIVERSITY CHATS\"]")
	WebElement boiseStateUniversityChatasTab;
	
	//Recent chats
	@FindBy(xpath="//android.widget.TextView[@text=\"Recent Chat Messages \"]")
	WebElement recentChats;
	
	//Cover image
	@FindBy(xpath="//android.widget.TextView[@text=\"+\"]")
	WebElement coverImages;
	
	
	//Group name , no xpath as of now
	
	//Close smileys popup
	@FindBy(xpath="//android.widget.TextView[@text=\"X\"]")
	WebElement closeButtonForSmileys;
	
	//Group name
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"CreateChatsGroupNameText\"]")
	WebElement groupName;
	
	//Group type public
	@FindBy(xpath="//android.widget.TextView[@text=\"Public\"]")
	WebElement groupTypePublic;
	
	//Group type public
	@FindBy(xpath="//android.widget.TextView[@text=\"Add Member\"]")
	WebElement addMember;
	
	//Create group
	@FindBy(xpath="//android.widget.TextView[@text=\"Create Group\"]")
	WebElement createGroup;
	
	//Member 1
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
	WebElement member1;
	
	//Member 2
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
	WebElement member2;
	
	//Invite member
	@FindBy(xpath="//android.widget.TextView[@text=\"Invite friend\"]")
	WebElement inviteMember;
	
	//This will be used for asserting but need to take the xpath dynamically as it is based on group name
	@FindBy(xpath="//android.widget.TextView[@text=\"techno group\"]")
	WebElement createdGroup;
	
	//Message box
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"auto-complete-text-input\"]")
	WebElement sendMessageTextBox;
	
	//Select a group
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"channel-list-messenger\"]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
	WebElement selectAGroupWithChat;
	
	//Other user message
	@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"message-simple-wrapper\"])[1]")
	WebElement otherUserMessage;
	
	//Select an smiley, no xpath as of now
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
	WebElement smileyXpath;
	
	//Select smiley picker
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]")
	WebElement smileyPickerXpath;
	
	//Search member
	@FindBy(xpath="//android.widget.EditText[@text=\"Search People\"]")
	WebElement searchMember;
	

	public void ClickCreateChatButton() {
		createChat.click();
		
	}
	
	public void UploadCoverImage() {
		coverImages.click();
		
	}
	

	public void SmileyPicker() {
		smileyXpath.click();
		waitForAWhile(10);
		smileyPickerXpath.click();
		
	}
	
	public void SmileyClose() {
		closeButtonForSmileys.click();
		
	}
	
	public void EnterGroupName() {
		groupName.sendKeys(GroupName);
		
	}
	
	public void SelectPublicPrivacy() {
		groupTypePublic.click();
		
	}
	
	public void ClickAddMember() {
		addMember.click();
		
	}
	
	public void TypeInSearch() {
		searchMember.sendKeys("Miles Tucker");
		
	}
	
	public void AddMemberToGroup() {
		member1.click();
		
	}
	public void InviteMember() {
		inviteMember.click();
	}
	
	public void ClickCreateGroup() {
		createGroup.click();
		
	}
	
	public void createAGroupChat() {
		ClickCreateChatButton();
		waitForAWhile(10);
		UploadCoverImage();
		waitForAWhile(10);
		SmileyPicker();
		waitForAWhile(10);
		//SmileyClose();
		//waitForAWhile(10);
		EnterGroupName();
		waitForAWhile(10);
		SelectPublicPrivacy();
		scroll(ScrollDirection.DOWN, 0.7);
		waitForAWhile(10);
		ClickAddMember();
		waitForAWhile(10);
		TypeInSearch();
		waitForAWhile(10);
		AddMemberToGroup();
		waitForAWhile(10);
		InviteMember();
		waitForAWhile(10);
		ClickCreateGroup();
		waitForAWhile(10);
		clickChat();		
		
	}
	
	
	
	//Methods
	public Boolean VerifyChatHeadingIsDisplayed() {

		Boolean match = chatHeading.isDisplayed();
		return match;

	}
	
	public Boolean VerifyRecentTabIsDisplayed() {

		Boolean match = recentTab.isDisplayed();
		return match;

	}
	public Boolean VerifyBoiseAndStateTabIsDisplayed() {

		Boolean match = boiseStateUniversityChatasTab.isDisplayed();
		return match;

	}
	public Boolean VerifyAllChatsTabIsDisplayed() {

		Boolean match = allChatsTab.isDisplayed();
		return match;

	}
	
	public Boolean VerifyRecentChatsIsDisplayed() {

		Boolean match = recentChats.isDisplayed();
		return match;

	}
	
}
	

