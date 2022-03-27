package com.store.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductLoginTest {

	@Test(enabled = true, priority = 1, description = "Testing standard user account", testName = "Functional")
	public static void standarduserLogin() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(currentURL, expectedURL, "Failed! Unable to log in");
		
		driver.quit();
	}
	@Test(enabled = true, priority = 2, description = "Testing locked user account", testName = "Functional")
	public static void lockedoutuserLogin() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		WebElement error = driver.findElement(By.xpath("//*[contains (text(),'Sorry')]"));
		String actualText = error.getText();
		String expectedText = "Epic sadface: Sorry, this user has been locked out.";
		Assert.assertEquals(actualText, expectedText, "Failed! String does not match ");
		
		driver.quit();
	}
	@Test(enabled = true, priority = 3, description = "Testing problem user account", testName = "Functional")
	public static void problemuserLogin() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("problem_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(currentURL, expectedURL, "Failed! Unable to log in");
		
		driver.quit();
	}
	@Test(enabled = true, priority = 4, description = "Testing glitched user account", testName = "Functional")
	public static void performanceglitchuserLogin() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(currentURL, expectedURL, "Failed! Unable to log in");
		
		driver.quit();
	}

}
