package com.Abhishek.app;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReddifLogin {
	
	
	@Test
	public void basePage() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/abhishekpatel/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.reddit.com/");
		
		driver.findElement(By.xpath("//div[@class='_1JBkpB_FOZMZ7IPr3FyNfH']/a")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='_25r3t_lrPF3M6zD2YkWvZU']"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.id("loginUsername")).sendKeys("abhipatel4592@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("Hello");
		driver.findElement(By.cssSelector(".AnimatedForm__submitButton")).click();
		
		boolean ErrorMessage = driver.findElement(By.cssSelector(".AnimatedForm__errorMessage")).isDisplayed();
		Assert.assertTrue(ErrorMessage);
		
		//<div class="AnimatedForm__errorMessage" xpath="1">Incorrect password</div>
		
		
	}

}
