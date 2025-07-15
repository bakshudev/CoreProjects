package seleniumtests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable {
			
	 private WebElement _webTable;
	  
	 // public WebTable(WebElement webTable, String dataRowXPath, String dataCellXPath)
	 public WebTable(WebElement webTable)
	 {
		// Take a web element parameter representing the table and assign that to _webTable
		_webTable=webTable;
	 }
	 
	 public int getRowCount()
	 {
		 // return count of all web elements by tag name tr (tr-represents table row)
		 return _webTable.findElements(By.cssSelector("tbody tr")).size();
	 }
	 
	 public int getColumnCount()
	 {
		 WebElement firstDataRow = _webTable.findElement(By.cssSelector("tbody tr"));
	
		 // return count of web elements by tag name td (td-represents table cell) from first row
		 return firstDataRow.findElements(By.tagName("td")).size();
	 }
	 
	 public WebElement getCellElement(int rowNumber, int colNumber)
	 {
		 return _webTable.findElement(By.cssSelector("tbody tr:nth-child("+rowNumber+")" 
				 										+ " td:nth-child("+colNumber+")"));
	 }
	 
	 public WebElement getCellElement(String cellText)
	 {
		 // Define xpath for a cell which contains specified text
		 // contains(.,'text') - represents a xpath function to check whether a element contains specified text 
		 String cellXPath = "tbody/tr/td[contains(.,'" + cellText +"')]";
		 return _webTable.findElement(By.xpath(cellXPath));
	 }
	 
	 public String[] getCellTextFromColumn(int colNumber)
	 {
		 int rowCount = getRowCount();
		// Define 1 dimensional string array based on number of rows in table to hold column data  
		 String[] tableColData = new String[rowCount];
	
		 for(int i=1;i<=rowCount;i++)
		 {
			 // Get each row cell text from the column=colNumber
			 tableColData[i-1] = getCellElement(i,colNumber).getText();
		 }
		 
		 return tableColData;
	 }
	 
	 public String[] getCellTextFromRow(int rowNumber)
	 {
		 int colCount = getColumnCount();
		 // Define 1 dimensional string array based on number of columns in table to hold row data  
		 String[] tableRowData = new String[colCount];
	
		 for(int i=1;i<=colCount;i++)
		 {
			// Get each column cell text from the row=rowNumber
			 tableRowData[i-1] = getCellElement(rowNumber,i).getText();
		 }
		 
		 return tableRowData;
	 }
	 
	 public String[][] getCellTextFromTable()
	 {
		 int rowCount = getRowCount();
		 int colCount = getColumnCount();
		 // Define 2 dimensional string array based on table size to hold all data  
		 String[][] allTableRowsData = new String[rowCount][colCount];
	
		 for(int i=1;i<=rowCount;i++)
		 {
			 for(int j=1;j<=colCount;j++)
			 {
				// Get each cell text based on row and column numbers
				allTableRowsData[i-1][j-1] = getCellElement(i,j).getText();
			 }
		 }
		 
		 return allTableRowsData;
	 }
	 
	 public WebElement getRowElement(int rowNumber)
	 {
	 	return _webTable.findElement(By.cssSelector("tbody tr:nth-child("+rowNumber+")"));
	 }
	 
	 public WebElement getRowElement(String rowText)
	 {
		 // Define xpath for a row which contains specified text
		 // contains(.,'text') - represents a xpath function to check whether a element contains specified text 
		 String rowXPath = "tbody/tr[contains(.,'" + rowText +"')]";
		 return _webTable.findElement(By.xpath(rowXPath));
	 }
	 
		
	 public WebElement getWebTable()
	 {
		 return _webTable;
	 }
}