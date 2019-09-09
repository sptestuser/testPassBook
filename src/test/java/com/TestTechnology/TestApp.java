package com.TestTechnology;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Technology.AddEBookPage;
import com.Technology.Base;

@Listeners(com.Technology.listeners.class)

public class TestApp extends Base {

	AddEBookPage bookpage = new AddEBookPage();

	@BeforeTest
	public void browser() throws InterruptedException {
		initialiseDriver1();
		System.out.println(d + prop.getProperty("url"));
		d.get(prop.getProperty("url"));
	}

	@Test(priority = 1)
	public void AddContact() {
		System.out.println("Test1: Creating the new contact record");
		bookpage.enterContactDetails();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void verifyContact() {
		System.out.println("Test2: Verifying the search option");
		bookpage.SetFilterContact();
		bookpage.SetFilterContactName();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void verifyContactEditable() {
		System.out.println("Test3: Verifying the Edit Option");
		bookpage.EditContactDetails();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void verifysortAlphabet() throws InterruptedException {
		System.out.println("Test4: Verifying Sorting on First Name Column");
		bookpage.SortAlphabetWise();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void verifysortLastname() {
		System.out.println("Test5: Verifying Sorting  on LastName Column");
		bookpage.SortLatname();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void verifysortEmail() {
		System.out.println("Test6: Verifying Sorting on Email Column");
		bookpage.SortEmail();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void verifyCancel() {
		System.out.println("Test7: Verifying Cancel Button");
		bookpage.CancelEdit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void exit() {
		d.quit();
	}
}
