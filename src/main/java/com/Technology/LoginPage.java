package com.Technology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {
	
	By loginPage = By.cssSelector("a[href*='Login']");
	By setUserName = By.cssSelector("#Input_Email");
	By setPassWord = By.cssSelector("#Input_Password");
	By loginButton = By.cssSelector("[type='submit']");
	By logoutbtn = By.cssSelector("[type='submit'].nav-link.btn.link.text-dark");
	By user = By.cssSelector("[@title='Manage']");

	public void loginBtn() {
		d.findElement(loginPage).click();
	}

	public void setUserName(String userName) {

		d.findElement(setUserName).sendKeys(userName);

	}

	public void setPassword(String passWord) {
		d.findElement(setPassWord).sendKeys(passWord);
	}

	public void clickLogin() {
		d.findElement(loginButton).click();
	}
	
	public void clickLogOut() {
		d.findElement(logoutbtn).click();
	}

	public void loginApp(String strUserName, String strPasword) {
		try {
			System.out.println("Test Login");
			setUserName(strUserName);
			setPassword(strPasword);
			clickLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loginOut() {
		try {
			clickLogOut();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
