package com.TestTechnology;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Technology.AddEBookPage;
import com.Technology.Base;
import com.Technology.HomePage;
import com.Technology.LoginPage;

import junit.framework.Assert;

@Listeners(com.Technology.listeners.class)

public class TestApp extends Base {
	
	AddEBookPage bookpage = new AddEBookPage();
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	
	
	
	
	@BeforeTest
	public void browser() throws InterruptedException {
		initialiseDriver1();
		System.out.println(d+prop.getProperty("url"));
		d.get(prop.getProperty("url"));
	}
	
	@Test(priority=1)
	public void loginPage() throws IOException, InterruptedException {
		System.out.println("test1");
		login.loginBtn();
		login.loginApp("testuser@spsoft.in","Spsoft@123");
	}
	
	@Test(priority=4)
	public void logoutPage() throws IOException, InterruptedException {
		System.out.println("test3");
		login.clickLogOut();
		d.close();
	}
	
	@Test(priority=2)
	public void verifyloginUser() throws IOException, InterruptedException {
		String actualUserName = d.findElement(By.cssSelector("[title='Manage']")).getText();
		String actualValue =actualUserName.substring(8,actualUserName.length()-1);
		System.out.println("actualValue"+actualValue);
		Assert.assertEquals("testuser@spsoft.in", actualValue);
		
	}
	
	@Test(priority=3)
	public void verifyBook() throws IOException, InterruptedException {
		
		home.clickOnAddBook();
		Thread.sleep(3000);
		bookpage.AddEBook();
		
	}

}
