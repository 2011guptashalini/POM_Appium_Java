package com.bschool.chats.bschoolAndroid.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bschool.chats.bschoolAndroid.Data.DataReader;
import com.bschool.chats.bschoolAndroid.TestComponents.BaseTest;
import com.bschool.chats.bschoolAndroid.TestComponents.Retry;

public class EventPageTest extends BaseTest {
	@Test(groups= {"Smoke", "Regression"}, retryAnalyzer=Retry.class)
	public void eventPage_displayedTest() 
	{			
		    eventPage = homePage.goToEventPage();
			Boolean match = eventPage.VerifyEventPageDisplayed();
			Assert.assertTrue(match, "Event page is displayed");
			match = eventPage.VerifyAllEventDisplayed();
			Assert.assertTrue(match, "All events are displayed");
			match = eventPage.VerifyPastEventDisplayed();
			Assert.assertTrue(match, "Past event is displayed");
			
		}
		
	@Test(groups= {"Smoke", "Regression"}, retryAnalyzer=Retry.class)
	public void eventPage_addEventTest() throws InterruptedException {
		
		eventPage = homePage.goToEventPage();
		eventPage.clickAddEvent();
		eventPage.addImage();
		Boolean match = eventPage.VerifyPhotoOptionsDisplayed();
		Assert.assertTrue(match, "Options to select photo is displayed");
		
		match = eventPage.VerifyImageIsUploaded();
		Assert.assertTrue(match, "Photo is uploaded and app returned back to adding event page");
		
		eventPage.addEventDetails();
		eventPage.createEvent();
		match = eventPage.VerifyEventIsAdded();
		Assert.assertTrue(match, "Event is added and displayed");
		
		//Deleting the event created while testing
		eventPage.reachToAddedEvent();
		eventPage.clickThreeDots();
		eventPage.clickDelete();
		eventPage.confirmDelete();
		
	}
	
	@Test(groups= {"Regression"}, retryAnalyzer=Retry.class)
	public void eventPage_editEvent() throws InterruptedException
	{
		eventPage = homePage.goToEventPage();
		eventPage.clickAddEvent();
		
		eventPage.addImage();
		Boolean match = eventPage.VerifyPhotoOptionsDisplayed();
		Assert.assertTrue(match, "Options to select photo is displayed");
		
		match = eventPage.VerifyImageIsUploaded();
		Assert.assertTrue(match, "Photo is uploaded and app returned back to adding event page");
		
		eventPage.addEventDetails();
		eventPage.createEvent();
		match = eventPage.VerifyEventIsAdded();
		Assert.assertTrue(match, "Event is added and displayed");
		
		eventPage.openAddedEvent();
		eventPage.ClickEditButton();
		eventPage.UpdateCategory();
		
		match = eventPage.CategoryUpdatedAfterSaveIsDisplayed();
		Assert.assertTrue(match, "Category is updated");
		
		/*eventPage.UpdatingLink();
		match = eventPage.AddLinkPopupIsDisplayed();
		Assert.assertTrue(match, "Add Link popup is displayed");
		
		
		match = eventPage.AddedLinkAfterUpdatingIsDisplayed();
		Assert.assertTrue(match, "Link is added successfully");*/
				
		
	}
	@Test(groups= {"Regression"}, retryAnalyzer=Retry.class)
	public void eventPage_readDetails() throws InterruptedException {
		eventPage = homePage.goToEventPage();
		eventPage.clickAddEvent();
		
		eventPage.addImage();
		Boolean match = eventPage.VerifyPhotoOptionsDisplayed();
		Assert.assertTrue(match, "Options to select photo is displayed");
		
		match = eventPage.VerifyImageIsUploaded();
		Assert.assertTrue(match, "Photo is uploaded and app returned back to adding event page");
		
		eventPage.addEventDetails();
		eventPage.createEvent();
		match = eventPage.VerifyEventIsAdded();
		Assert.assertTrue(match, "Event is added and displayed");
		
		//Open added event
		eventPage.openAddedEvent();
		
		
		
		String shortDescriptionDisplayed = eventPage.EventDescriptionIs();
		match = eventPage.EventDescriptionIsDisplayed();
		Assert.assertTrue(match, "Event description is displayed and description is"+shortDescriptionDisplayed);
		
	}
	
	
	@Test(groups= {"Regression"}, retryAnalyzer=Retry.class)
	public void eventPage_readComments() throws InterruptedException {
		eventPage = homePage.goToEventPage();
		eventPage.clickAddEvent();
		
		eventPage.addImage();
		Boolean match = eventPage.VerifyPhotoOptionsDisplayed();
		Assert.assertTrue(match, "Options to select photo is displayed");
		
		match = eventPage.VerifyImageIsUploaded();
		Assert.assertTrue(match, "Photo is uploaded and app returned back to adding event page");
		
		eventPage.addEventDetails();
		eventPage.createEvent();
		match = eventPage.VerifyEventIsAdded();
		Assert.assertTrue(match, "Event is added and displayed");
		
		//Open added event
		eventPage.openAddedEvent();
		eventPage.navigateDiscussion();
		eventPage.writeCommentForEvent();
		eventPage.goBackToEvents();
		eventPage.openAddedEvent();
		match = eventPage.readCommentIsDisplayed();
		Assert.assertTrue(match, "Event comment is displayed");
				
	}
	
	@Test(groups= {"Regression"}, retryAnalyzer=Retry.class)
	public void eventPage_writeComments() throws InterruptedException {
		eventPage = homePage.goToEventPage();
		eventPage.clickAddEvent();
		
		eventPage.addImage();
		Boolean match = eventPage.VerifyPhotoOptionsDisplayed();
		Assert.assertTrue(match, "Options to select photo is displayed");
		
		match = eventPage.VerifyImageIsUploaded();
		Assert.assertTrue(match, "Photo is uploaded and app returned back to adding event page");
		
		eventPage.addEventDetails();
		eventPage.createEvent();
		match = eventPage.VerifyEventIsAdded();
		Assert.assertTrue(match, "Event is added and displayed");
		
		//Open added event
		eventPage.openAddedEvent();
		eventPage.navigateDiscussion();
		eventPage.writeCommentForEvent();
		match = eventPage.readCommentIsDisplayed();
		Assert.assertTrue(match, "Event comment is displayed");
		
	
	
		
	}
	
}
	
		
