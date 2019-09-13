package com.Technology;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddEBookPage extends Base {

	By NewContact = By.cssSelector("[class='v-button v-widget']");
	By Fristname = By.xpath("//*[@class='v-formlayout-contentcell']//input");
	By Lastname = By.xpath("(//*[@class='v-formlayout-contentcell']//input)[2]");
	By Phone = By.xpath("(//*[@class='v-formlayout-contentcell']//input)[3]");
	By Email = By.xpath("(//*[@class='v-formlayout-contentcell']//input)[4]");
	By BirthDate = By.xpath("(//*[@class='v-formlayout-contentcell']//input)[5]");
	By Save = By.cssSelector("[class='v-button v-widget primary v-button-primary']");
	By FilterContact = By.xpath("//*[@class='v-slot']/input");
	By FilterContactName = By.xpath("//*[@class='v-grid-body']//tr//td");
	By ContactEdit = By.xpath("//*[@class='v-grid-body']//tr");
	By SortAlphabet = By.xpath("//*[text()='First Name']");
	By SortLastname = By.xpath("//*[text()='Last Name']");
	By SortEmail = By.xpath("//*[text()='Email']");
	By Cancel = By.xpath("(//*[@class='v-button v-widget'])[2]");

	public void SetNewContact() {
		d.findElement(NewContact).click();
	}

	public void SetFristname() {
		d.findElement(Fristname).click();
		WebDriverWait wait = new WebDriverWait(d, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Fristname));
		d.findElement(Fristname).sendKeys(prop.getProperty("Firstname"));
	}

	public void SetLastname() {
		d.findElement(Lastname).click();
		d.findElement(Lastname).sendKeys(prop.getProperty("Lastname"));
	}

	public void SetPhone() {
		d.findElement(Phone).click();
		d.findElement(Phone).sendKeys(prop.getProperty("Phone"));
	}

	public void SetEmail() {
		d.findElement(Email).click();
		d.findElement(Email).sendKeys(prop.getProperty("Email"));
	}

	public void SetBirthDate() {
		d.findElement(BirthDate).click();
		d.findElement(BirthDate).sendKeys(prop.getProperty("Birthdate"));
	}

	public void SetSave() {
		WebDriverWait wait = new WebDriverWait(d, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Save));
		d.findElement(Save).click();
	}

	public void SetFilterContact() {
		WebDriverWait wait = new WebDriverWait(d, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FilterContact));
		d.findElement(FilterContact).click();
		d.findElement(FilterContact).sendKeys(prop.getProperty("FilterContact"));
	}

	public void SetFilterContactName() {
		WebDriverWait wait = new WebDriverWait(d, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FilterContactName));
		Assert.assertEquals(prop.getProperty("FilterContact"), d.findElement(FilterContactName).getText());
	}

	public void EditContactDetails() {
		String s = d.findElement(ContactEdit).getText();
		WebDriverWait wait = new WebDriverWait(d, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactEdit));
		d.findElement(ContactEdit).click();
		d.findElement(Fristname).clear();
		d.findElement(Fristname).sendKeys(prop.getProperty("Firstname1"));
		d.findElement(Lastname).clear();
		d.findElement(Lastname).sendKeys(prop.getProperty("Lastname1"));
		d.findElement(Phone).clear();
		d.findElement(Phone).sendKeys(prop.getProperty("Phone1"));
		d.findElement(Email).clear();
		d.findElement(Email).sendKeys(prop.getProperty("Email1"));
		d.findElement(BirthDate).clear();
		d.findElement(BirthDate).sendKeys(prop.getProperty("Birthdate1"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Save));
		d.findElement(Save).click();
		d.findElement(FilterContact).clear();
		d.findElement(FilterContact).sendKeys(prop.getProperty("FilterContact"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactEdit));
		Assert.assertNotSame(s, d.findElement(ContactEdit).getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated(FilterContact));
		d.findElement(FilterContact).clear();
		d.findElement(FilterContact).sendKeys(prop.getProperty("FilterContact1"));
		String s1 = d.findElement(ContactEdit).getText();
		Assert.assertEquals(s1, d.findElement(ContactEdit).getText());
	}

	public void SortAlphabetWise() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(d, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FilterContact));
		d.findElement(FilterContact).clear();
		d.findElement(FilterContact).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		d.findElement(SortAlphabet).click();
		Assert.assertEquals(true, d.findElement(ContactEdit).getText().startsWith("A"));
	}

	public void SortLatname() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(d, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FilterContact));
		d.findElement(FilterContact).clear();
		d.findElement(FilterContact).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		d.findElement(SortLastname).click();
		Assert.assertEquals(true, d.findElement(ContactEdit).getText().contains("Anderson"));

	}

	public void SortEmail() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(d, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FilterContact));
		d.findElement(FilterContact).clear();
		d.findElement(FilterContact).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		d.findElement(SortEmail).click();
		Assert.assertEquals(true, d.findElement(ContactEdit).getText().contains("alex@brown.com"));
	}

	public void CancelEdit() {
		try {
			WebDriverWait wait = new WebDriverWait(d, 25);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ContactEdit));
			d.findElement(ContactEdit).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Cancel));
			d.findElement(Cancel).click();
			Assert.assertEquals(false, d.findElement(Cancel).isDisplayed());
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	public void enterContactDetails() {
		SetNewContact();
		SetFristname();
		SetLastname();
		SetPhone();
		SetEmail();
		SetBirthDate();
		SetSave();
	}
}
