package com.Technology;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddEBookPage extends Base {
	
	By uploadBook = By.cssSelector("#upload-dialog");
	By description = By.cssSelector("[placeholder='Description']");
	By technology = By.cssSelector("#book_TechnologyId");
	By publishedOn = By.cssSelector("[placeholder='Published Date (YYYY)']");
	By author = By.cssSelector("[placeholder='Author Name']");
	By bookName = By.cssSelector("[placeholder='Book Name']");
	By clickAdd = By.cssSelector("[type='submit']");

	public void setUploadBook(String filePath) {
		d.findElement(By.cssSelector("#upload-dialog")).sendKeys(filePath);
		// Runtime.getRuntime().exec("C:\\Users\\Administrator\\Desktop\\testFirst.exe");
	}

	public void setDescription(String desc) {
		d.findElement(description).sendKeys(desc);
	}

	public void setTechnology(String techvalue) {
		WebElement tech = d.findElement(technology);
		Select technology = new Select(tech);
		technology.selectByValue(techvalue);
	}

	public void setPublishedOn(String pblshOn) {
		d.findElement(publishedOn).sendKeys(pblshOn);
	}

	public void setAuthor(String authr) {
		d.findElement(author).sendKeys(authr);
	}

	public void setBookName(String bName) {
		d.findElement(bookName).sendKeys(bName);
	}
	
	public void clickAdd() {
		d.findElement(clickAdd).click();
	}

	public void AddEBook() throws IOException, InterruptedException {
		
		String bName = prop.getProperty("bName");
		String authr = prop.getProperty("authr");
		String pblshOn = prop.getProperty("pblshOn");
		String techvalue = prop.getProperty("techvalue");
		String desc = prop.getProperty("desc");
		String filePath = prop.getProperty("filePath");
		System.out.println(filePath);

		setBookName(bName);
		setAuthor(authr);
		setPublishedOn(pblshOn);
		setTechnology(techvalue);
		setDescription(desc);
		setUploadBook(filePath);
		Thread.sleep(2000);
//		clickAdd();

	}
}
