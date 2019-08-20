package com.Technology;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoIT {
	WebDriver driver;

	@BeforeTest
	public void start() {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Training\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void autoIt() throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.get("http://192.168.10.55:83");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[href*='Login']")).click();
		driver.findElement(By.cssSelector("#Input_Email")).sendKeys("testuser@spsoft.in");
		driver.findElement(By.cssSelector("#Input_Password")).sendKeys("Spsoft@123");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary.m-1")).click();
		// driver.findElement(By.cssSelector("#upload-dialog")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#upload-dialog"))
				.sendKeys("C:\\Users\\Administrator\\Desktop\\Logix Designer Report(s).pdf");
		// Runtime.getRuntime().exec("C:\\Users\\Administrator\\Desktop\\testFirst.exe");
		driver.findElement(By.cssSelector("[placeholder='Book Name']")).sendKeys("Testing");
		;
		driver.findElement(By.cssSelector("[placeholder='Author Name']")).sendKeys("Tester");
		driver.findElement(By.cssSelector("[placeholder='Published Date (YYYY)']")).sendKeys("2019");
		Select technology = new Select(driver.findElement(By.cssSelector("#book_TechnologyId")));
		technology.selectByValue("5");
		driver.findElement(By.cssSelector("[placeholder='Description']")).sendKeys("Important Book");
		driver.findElement(By.cssSelector("[placeholder='Book Name']"));
		driver.findElement(By.cssSelector("[placeholder='Book Name']"));
		driver.findElement(By.cssSelector("[type='submit']")).click();

		Thread.sleep(5000);

	}

	@AfterTest
	public void tearDown() {

	}

}
