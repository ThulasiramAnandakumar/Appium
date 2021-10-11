package AppiumDemo.Appium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;

public class Flipkart
{
	
	@Test
	void Run()
	{
		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability("platformName", "Android");
		dc.setCapability("automation_Name", "UiAutomator2");
		dc.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		dc.setCapability("appPackage", "com.flipkart.android");
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(dc);
		
		
		//Scroll Down
	    driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        + "English" + "\").instance(0))")
        .click();
	    
	    //Click Continue
	    driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();
	    
	    
	    WebDriverWait wait=new WebDriverWait(driver, 10);
	    //Skip Signup Operation
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.gms:id/cancel")));
	    driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
	    
	    
	    driver.findElement(By.id("com.flipkart.android:id/custom_back_icon")).click();
	    
	    
	    //Tap Search Box
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text=\"Search for Products, Brands and More\"]")));
	    driver.findElement(By.xpath("//*[@text=\"Search for Products, Brands and More\"]")).click();
	    
	    //Select Prdouct
	    driver.findElement(By.id("com.flipkart.android:id/search_autoCompleteTextView")).sendKeys("Iphone 12");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@text,\"iphone 12\")])[1]")));
	    driver.findElement(By.xpath("(//*[contains(@text,\"iphone 12\")])[1]")).click();
	    
	    
	    //location Persmission
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("com.flipkart.android:id/not_now_button")).click();
	    
	    driver.findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "APPLE iPhone 12 (White, 64 GB)"
				+ "\").instance(0))")
		.click();
	    
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[contains(@text,\"BUY NOW\")]")).click();
	    
	}
}

