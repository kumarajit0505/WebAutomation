package com.webautomation.qa.testcases;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.webautomation.qa.base.Base;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webautomation.qa.pages.DynamicTablePage;


public class DynamicTableTest extends Base {
	
		DynamicTablePage objDynamicTablePage;
		Properties properties;
		public WebDriver driver;
		  
		public DynamicTableTest() {
			super();
		}

	@BeforeMethod
	public void setup() {
	
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		properties = new Properties();
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("tableData.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	

	@Test(priority = 1)
	public void enterDataAndAssert() {
		
			objDynamicTablePage = new DynamicTablePage(driver);
//			objDynamicTablePage.clickTableDataButton();

	        // Step 3: Insert the data from data.properties
	        String jsonData = properties.getProperty("testData");
	        objDynamicTablePage.setInputText(jsonData);

	        // Step 4: Click on Refresh Table button
	        objDynamicTablePage.clickRefreshTableButton();

	        // Step 5: Assert data in the table
	        String tableData = objDynamicTablePage.getTableData();
	        Assert.assertEquals(tableData, jsonData, "Table data does not match the input data");
	        
	        driver.quit();

        }
    }
	