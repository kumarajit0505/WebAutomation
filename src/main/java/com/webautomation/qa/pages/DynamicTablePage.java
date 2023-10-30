package com.webautomation.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DynamicTablePage {
	WebDriver driver;
	
	@FindBy(id = "jsondata")
	private WebElement inputBoxField;
	
	@FindBy(id = "refreshtable")
	private WebElement refreshTableButton;
	
	@FindBy(id="dynamictable")
	private WebElement table;
	
	@FindBy(xpath="//table[@id='dynamictable']/tr")
	private List<WebElement> tableRow;
	
	@FindBy(xpath="//summary[normalize-space()='Table Data']")
	private WebElement tableDataButton;
	
	@FindBy(xpath="//table[@id='dynamictable']/tr[' + row + ']/td[' + column + ']")
	private WebElement tableData;
	
	@FindBy(xpath="//table[@id='dynamictable']/tr[' + row + ']/td[' + column + ']")
	private WebElement nameFromTable;
	
	@FindBy(xpath="//table[@id='dynamictable']/tr[' + row + ']/td[' + column + ']")
	private WebElement ageFromTable;
	
	@FindBy(xpath="//table[@id='dynamictable']/tr[' + row + ']/td[' + column + ']")
	private WebElement genderFromTable;
	
	public DynamicTablePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void clickTableDataButton() {
		
        tableDataButton.click();
    }

    public DynamicTablePage setInputText(String text) {
    	tableDataButton.click();
        inputBoxField.click();
		inputBoxField.clear();
       
        inputBoxField.sendKeys(text);
        return new DynamicTablePage(driver);
    }

    public void clickRefreshTableButton() {
       refreshTableButton.click();
    }

    public int getTableRowCount() {
        int rowCount = tableRow.size();
        return rowCount;

    }

    public String getTableData() {
    	String tableRowData = tableData.getText();
        return tableRowData;
    }
}
	