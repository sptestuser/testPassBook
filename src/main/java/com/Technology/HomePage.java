package com.Technology;

import org.openqa.selenium.By;

public class HomePage extends Base {
	
	By addBook = By.cssSelector(".btn.btn-primary.m-1");

	public void clickOnAddBook() {
		
		d.findElement(addBook).click();
	}

}