# Appium - Page object Model using Java integration with Browserstack, Lamda Test and local environment

Some interesting screenshots of script running:
<p align="center">
<img height="400" src="https://github.com/2011guptashalini/mffaisapptest/blob/master/LambdaTest-Automation.png">
<img height="400" src="https://github.com/2011guptashalini/mffaisapptest/blob/master/Sample-BrowserStack-App-Automate.png">
</p>

**What is Appium:** Appium is a tool for automating native, mobile web, and hybrid applications on iOS, Android, and Windows platforms. It supports iOS native apps written in Objective-C or Swift and Android native apps written in Java or Kotlin. It also supports mobile web apps accessed using a mobile browser (Appium supports Safari on iOS and Chrome or the built-in 'Browser' app on Android). 

## About Project Structure:
On highlevel there are pages and test folders. Page folders are having information about the locators and methods for a particual page using page object factory. 
Tests are holding all the test. Test components folder is having "BaseTest" files. BaseTest local is for setting up in local environment, BaseTestBS is for BrowserStack and BaseTestLT is for Lamda test.

For Browserstack and Lamda test you need to gain your username, password and need to upload your apk file on the platform. Need to paste this information in BaseTest files. And you can start running your test on these platforms.

For running in local environments, You need to install android studio, appium server, appium inspector and need to set JAVA_HOME, ANDROID_HOME paths.

## Tips for running test on BS and LT:
1. Check which Java appium client they are currently supporting and change your pom.xml accordingly. It is better to know the platform and dependecies in beginning so that you can start your code keeping that appium version in mind.



