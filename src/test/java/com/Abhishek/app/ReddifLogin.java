package com.Abhishek.app;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReddifLogin {
	WebDriver driver;
	
	@Test
	public void basePage() {
		System.out.println("Hello");
		System.setProperty("webdriver.chrome.driver", "/Users/abhishekpatel/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.reddit.com/");
		
		driver.findElement(By.xpath("//div[@class='_1JBkpB_FOZMZ7IPr3FyNfH']/a")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='_25r3t_lrPF3M6zD2YkWvZU']"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.id("loginUsername")).sendKeys("abhipatel4592");
		driver.findElement(By.id("loginPassword")).sendKeys("Hello");
		driver.findElement(By.cssSelector(".AnimatedForm__submitButton")).click();
		
		String ErrorMessage = driver.findElement(By.cssSelector(".AnimatedForm__errorMessage")).getText();
		
		if(ErrorMessage == "Incorrect Username and Password") {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		driver.switchTo().parentFrame();
		
		
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
		}

}
