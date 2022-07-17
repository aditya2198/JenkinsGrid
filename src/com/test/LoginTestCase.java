package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class LoginTestCase {
public static RemoteWebDriver driver;
	
	
	@Test
	public void GridTestCase() throws MalformedURLException, InterruptedException {
		String url = "http://192.168.29.56:4444/wd/hub";
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		
		System.setProperty("webdriver.chrome.driver", "./BrowserUtils/chromedriver.exe");
		driver = new RemoteWebDriver(new URL(url),cap);
		
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement button = driver.findElement(By.xpath("//button[@class='radius']//i"));
		
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		button.click();
		Thread.sleep(2000);
		driver.close();
		

}
}
