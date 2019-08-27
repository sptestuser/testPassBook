package com.TestTechnology;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Technology.AddEBookPage;
import com.Technology.Base;

import junit.framework.Assert;

@Listeners(com.Technology.listeners.class)

public class TestApp extends Base {
	
	AddEBookPage bookpage = new AddEBookPage();
	
	@BeforeTest
	public void browser() throws InterruptedException {
		initialiseDriver1();
		System.out.println(d+prop.getProperty("url"));
		d.get(prop.getProperty("url"));
	}
	@Test(priority=1)
	public void AddContact(){
		System.out.println("test1");
		bookpage.enterContactDetails();	
		
	}
	@Test(priority=2)
	public void verifyContact(){
		System.out.println("test2");
		bookpage.SetFilterContact();
		bookpage.SetFilterContactName();
	}
	@Test(priority=3)
	public void verifyContactEditable()
	{
		System.out.println("test3");
		bookpage.EditContactDetails();
	}
	@Test(priority=4)
	public void verifysortAlphabet()
	{
		System.out.println("test4");
		bookpage.SortAlphabetWise();
	}
	@Test(priority=5)
	public void verifysortLastname() 
	{
		System.out.println("test5");
		bookpage.SortLatname();
	}
	@Test(priority=6)
	public void verifyEmail()
	{
		System.out.println("test6");
		Assert.fail();
		bookpage.SortEmail();
		
	}
	@Test(priority=7)
	public void verifyCancel()
	{
		System.out.println("test7");
		bookpage.CancelEdit();
	}
	@AfterTest
	public void exit()
	{
		d.quit();
	}
}
