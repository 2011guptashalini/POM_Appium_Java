package com.bschool.chats.bschoolAndroid.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import io.appium.java_client.android.AndroidDriver;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.zeroturnaround.zip.ZipUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.bschool.chats.bschoolAndroid.pageojects.*;

public class BaseTestLocal {
	
	public static AndroidDriver driver;
	public static AndroidDriver driver1;
	Properties prop = new Properties();
	
	// Create objects of pages
	public LaunchPage launchPage; 
	public LoginPage loginPage;
	public HomePage homePage;
	public EventPage eventPage;
	public ChatPage chatPage;
	
	public AndroidDriver initializeDriver(String deviceName) throws URISyntaxException, IOException
	{
		//When testing needs to be performed on mobile app, some capabilities will change.
		
		//Path to apk file
		        
				String apkPath = System.getProperty("user.dir")+"/app-debug.apk";	
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", deviceName);
				cap.setCapability("platformName", "Android"); 
				cap.setCapability("appium:automationName", "UiAutomator2"); 
				cap.setCapability("app", apkPath);
				
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), cap);
						
				// Specify the path of the photo you want to send
				String photoPath = System.getProperty("user.dir")+"//testphoto.jpeg";
				File photo = new File(photoPath);
		        
		        // Push the photo file to the device
		        driver.pushFile("/sdcard/DCIM/Camera/photo.jpg", photo);
				return driver;
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public HomePage logintoApp() throws URISyntaxException, IOException
	{
		//String deviceName = "Pixel 7 Pro API 30";
		String dName = getProp("device_name");
		initializeDriver(dName);
		launchPage = new LaunchPage(driver);
		launchPage.goTo();
		loginPage = new LoginPage(driver);
		loginPage.loginApplication(getProp("schoolemail"), getProp("password"));
		homePage = new HomePage(driver);
		//loginPage.loginApplication("test", "test");
		return homePage;
		
		
	}
	
	public HomePage logintoSecondDevice() throws URISyntaxException, IOException
	{
		//String deviceName = null;
		String dName = getProp("second_device_name");
		initializeDriver(dName);
		
		launchPage = new LaunchPage(driver);
		launchPage.goTo();
		loginPage = new LoginPage(driver);	
		
		loginPage.loginApplication(getProp("second_school_email"), getProp("password"));
		homePage = new HomePage(driver);
		return homePage;
		
	}
	public String getScreenshot(String testCaseName,AndroidDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	public String getProp(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java/com//bschool//chats//bschoolAndroid//resources//GlobalData.properties");
		prop.load(fis);
		String keyValue = prop.getProperty(key);
		return keyValue;
	}
	
	@BeforeSuite(alwaysRun=true)
	public void beforeRunningTest() {
		try {
			String folderPath = System.getProperty("user.dir")+"/reports";
			String zippedFilePath = System.getProperty("user.dir")+"/reports.zip";
            FileUtils.forceDelete(new File(zippedFilePath)); //delete directory
            FileUtils.forceDelete(new File(folderPath));
            FileUtils.forceMkdir(new File(folderPath)); //create directory
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
	
	
	
	@AfterSuite(alwaysRun=true)
	public void sendReports() throws AddressException {
		InternetAddress[] toEmails = {new InternetAddress("2011guptashalini@gmail.com"),new InternetAddress("shalinigupta2006@gmail.com")};
		//String to[]= {"2011guptashalini@gmail.com", "shalinigupta2006@gmail.com"};
		sendEmail("Test message","Test subject", toEmails,"sgka6475@gmail.com", "qsss oijz iraw ktdx");
	}
	
	
	public static void sendEmail(String message, String subject, InternetAddress[] toEmails, String from, String password) {
		
		//Variable for gmail host
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		
		//Host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//Get the session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		
			
		
	});
		
		//Compose message
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setFrom(from);
			
			msg.addRecipients(Message.RecipientType.TO, toEmails);
			msg.setSubject(subject);
			// msg.setText(message); - sending text message
			String folderPath = System.getProperty("user.dir")+"/reports";
			String zippedFilePath = System.getProperty("user.dir")+"/reports.zip";
			ZipUtil.pack(new File(folderPath), new File(zippedFilePath)); 
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			MimeBodyPart textMime = new MimeBodyPart();
			MimeBodyPart fileMime = new MimeBodyPart();
			
			
			try {
				textMime.setText(message);
				File reports = new File(zippedFilePath);
				fileMime.attachFile(reports);
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Send the message using transport
			msg.setContent(mimeMultipart);
			Transport.send(msg);
			System.out.println("Email sent");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.removeApp("com.bschool.chats");
		driver.quit();
		
	}
	
}