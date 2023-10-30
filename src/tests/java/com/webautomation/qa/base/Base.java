package com.webautomation.qa.base;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	//public Properties dataProp;
   // List<Person> expectedTableData;
		
	public Base() {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\webautomation\\qa\\config\\config.properties");
		
//		dataProp = new Properties();
//		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\webautomation\\qa\\testdata\\tableData.properties");
		
//		try {
//			FileInputStream dataFis = new FileInputStream(dataPropFile);
//			dataProp.load(dataFis);
//		}catch(Throwable e) {
//			e.printStackTrace();
//		}
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
			
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			
		}
	
		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	
}
