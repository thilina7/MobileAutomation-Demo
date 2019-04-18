package com.E25.MobileTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest{
	
	private static AndroidDriver driver;

	public static void main(String []args) throws MalformedURLException, InterruptedException {
		
		// Create object of DesiredCapabilities class

				DesiredCapabilities capabilities = new DesiredCapabilities();

				// Optional

				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

				// Specify the device name (any name)

				capabilities.setCapability("deviceName", "My New Phone");

				// Platform version

				capabilities.setCapability("platformVersion", "4.4.4");

				// platform name

				capabilities.setCapability("platformName", "Android");

				// specify the application package that we copied from appium

				capabilities.setCapability("appPackage", "io.selendroid.testapp");

				// specify the application activity that we copied from appium

				capabilities.setCapability("appActivity", ".HomeScreenActivity");

				// Start android driver I used 4727 port by default it will be 4723
				System.out.println("setup done0");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				System.out.println("setup done1");
				// Specify the implicit wait of 5 second

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				// Enter the text in textbox
				
				
				driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']"))
						.sendKeys("Rana Selenium Appium");

				// click on registration button
				
			driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
				
				

				// filling the username
				
				driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("User1");
				
				driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("Test@test.com");
				
				driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("123456");

				driver.pressKeyCode(AndroidKeyCode.BACK);
				
				driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
				
				
				driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
				
				String test=driver.findElement(By.xpath("//android.widget.TextView[@text='Verify user']")).getText();
				
				System.out.println(test);
				
				Assert.assertEquals("Verify user", test);
			
				
				driver.findElement(By.id("io.selendroid.testapp:id/buttonRegisterUser")).click();
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				//driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
				
				
				Thread.sleep(10000);
				
				driver.pressKeyCode(AndroidKeyCode.BACK);
				// Wait for 10 second

				System.out.println("back");
				
				driver.findElement(By.id("io.selendroid.testapp:id/visibleButtonTest")).click();
				
				String TextView= driver.findElement(By.id("io.selendroid.testapp:id/visibleTextView")).getText();
				
				System.out.println(TextView);
				
				Assert.assertEquals(TextView, "Text is sometimes displayed");
				
				//WebElement toast = driver.findElement(By.id("io.selendroid.testapp:id/showToastButton"));
				//toast.click();
				
				

	}
	
	}
