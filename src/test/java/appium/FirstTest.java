package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class FirstTest {

	public static AndroidDriver<WebElement> driver;
	
	@BeforeTest
	public void openApp () throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "android");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability("deviceName", "Nexus6P");
		caps.setCapability("app", "D:\\Apps\\Camelan.apk");
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);	
			
	}
	
	@Test (priority = 1)
	public void searchAd ()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement searchBox = driver.findElement(By.id("com.camelan:id/mainSearchTextView"));
		searchBox.click();
	}
	
	@Test (priority = 2)
	public void searchAdTxt ()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement searchTxt = driver.findElement(By.id("android:id/search_src_text"));
		searchTxt.sendKeys("Cat");
	}
	@Test (priority = 3)
	public void showSingleAd ()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement catSearch = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]"));
		catSearch.click();
	}
	
	@Test (priority = 4)
	public void shareSingleAd ()
	{
		WebElement shareBox = driver.findElement(By.id("com.camelan:id/shareButtonLayout"));
		shareBox.click();
		WebElement gmailIcon = driver.findElement(By.xpath( 
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.ImageView"));
		gmailIcon.click();
		
		WebElement mailtoIcon = driver.findElement(By.id("com.google.android.gm:id/to"));
		mailtoIcon.sendKeys("mmh.abdelghany@gmail.com");
		WebElement sendIcon = driver.findElement(By.id("com.google.android.gm:id/send"));
		sendIcon.click();
		WebElement sendButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"));
		sendButton.click();
	}
	
	@AfterTest
	public void tearDown ()
	{
		driver.resetApp();
		driver.quit();
	}
}
