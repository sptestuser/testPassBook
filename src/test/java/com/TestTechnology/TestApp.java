package com.TestTechnology;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Technology.AddEBookPage;
import com.Technology.Base;

@Listeners(com.Technology.listeners.class)

/**
 * The Test Annotations verifies an address book application that Verifies the
 * test data and sorting actions
 *
 * @author Sp Softwrae Pvt Ltd
 * @version 1.0
 * @since 2019-08-16
 */

public class TestApp extends Base {

	AddEBookPage bookpage = new AddEBookPage();

	/**
	 * Lauching the Browser
	 */
	@BeforeTest
	public void browser() throws InterruptedException {
		initialiseDriver1();
		System.out.println(d + prop.getProperty("url"));
		d.get(prop.getProperty("url"));
	}

	/**
	 * Creating the new contact record
	 */
	@Test(priority = 1)
	public void AddContact() {
		System.out.println("Test1: Creating the new contact record");
		bookpage.enterContactDetails();

	}

	/**
	 * Verifying the search option
	 */
	@Test(priority = 2)
	public void verifyContact() {
		System.out.println("Test2: Verifying the search option");
		bookpage.SetFilterContact();
		bookpage.SetFilterContactName();

	}

	/**
	 * Verifying the Edit Option
	 */
	@Test(priority = 3)
	public void verifyContactEditable() {
		System.out.println("Test3: Verifying the Edit Option");
		bookpage.EditContactDetails();

	}

	/**
	 * Verifying Sorting on First Name Column
	 */
	@Test(priority = 4)
	public void verifysortAlphabet() throws InterruptedException {
		System.out.println("Test4: Verifying Sorting on First Name Column");
		bookpage.SortAlphabetWise();

	}

	/**
	 * Verifying Sorting on LastName Column
	 */
	@Test(priority = 5)
	public void verifysortLastname() throws InterruptedException {
		System.out.println("Test5: Verifying Sorting  on LastName Column");
		bookpage.SortLatname();

	}

	/**
	 * Verifying Sorting on Email Column
	 */
	@Test(priority = 6)
	public void verifysortEmail() throws InterruptedException {
		System.out.println("Test6: Verifying Sorting on Email Column");
		bookpage.SortEmail();

	}

	/**
	 * Verifying Cancel Button
	 */
	@Test(priority = 7)
	public void verifyCancel() {
		System.out.println("Test7: Verifying Cancel Button");
		bookpage.CancelEdit();

	}

	/**
	 * To close the browser
	 */
	@AfterTest
	public void exit() {
		d.quit();
	}
}
