	package com.Technology;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	
	public class Base {
		
		public static Properties prop;
		public static WebDriver d;
		
		public Base()
		{
		   try {
				prop=new Properties();
				FileInputStream fis=new FileInputStream("resources\\data.properties");
				prop.load(fis);
			   }
		   catch(Exception e)
			{
				e.getMessage();
			}
		}
		
		public void initialiseDriver1()
		{
			String brw=prop.getProperty("browser");
			if(brw.contentEquals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
				d=new ChromeDriver();
			}
			else if(brw.contentEquals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "");
				d=new FirefoxDriver();
			}
			d.manage().window().maximize();
			d.manage().deleteAllCookies();
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			d.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		}
	
		public WebDriver initialiseDriver() {
	
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			d = new ChromeDriver();
			return d;
		}
		
		public void getScrnShot()
		{
			String pth=prop.getProperty("scrDir");
			try {
			File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(pth+"ScrnShot1.png"));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
