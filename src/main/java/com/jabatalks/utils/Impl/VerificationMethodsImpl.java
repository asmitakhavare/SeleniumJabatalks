package com.jabatalks.utils.Impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jabatalks.utils.VerificationMethods;

public class VerificationMethodsImpl implements VerificationMethods{

	public Boolean verifyDropDownValues(String[] language,WebDriver driver) {
		// TODO Auto-generated method stub
		Boolean match=false;
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-select-choices-group']/div/a/div"));


		for(WebElement lang:options)  
				    {  

				 match = false;
				     for (int i=0; i<language.length; i++){
				         if (lang.getText().equals(language[i]))
				        		 {
				           match = true;
				       
				           break;
				          
				         }
				       }
				     if(!match) {
				    	 break;
				     }
				     
				   
				    }  
		return match;
	}

	public Boolean verifySignUp(WebDriver driver,String path) {
		// TODO Auto-generated method stub
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String username="";
		String organization="";
		String email="";
		String password="";
Row row= sheet.getRow(0);
for (Cell cell : row) {
	switch (cell.getStringCellValue()) {
    case "UserName":
    	username = sheet.getRow(1).getCell(cell.getColumnIndex()).getStringCellValue();
        break;
    case "Organization":
    	organization = sheet.getRow(1).getCell(cell.getColumnIndex()).getStringCellValue();
        break;
    case "Email":
        email = sheet.getRow(1).getCell(cell.getColumnIndex()).getStringCellValue();
        break;
    case "Password":
    	password=sheet.getRow(1).getCell(cell.getColumnIndex()).getStringCellValue().toString();
    	break;
}
	
}
	    driver.findElement(By.xpath("//input[@id='name']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@id='orgName']")).sendKeys(organization);
	    driver.findElement(By.xpath("//input[@id='singUpEmail']")).sendKeys(email);
	    driver.findElement(By.xpath("//span[@class='black-color ng-binding']")).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    //Launch email site
	    driver.navigate().to("https://login.yahoo.com/?.intl=in");
	    driver.findElement(By.xpath("//input[@id=\"login-username\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id=\"login-signin\"]")).click();		
	    driver.findElement(By.xpath("//input[@id=\"login-passwd\"]")).sendKeys(password);

	    driver.findElement(By.xpath("//button[@id=\"login-signin\"]")).click();
	   		driver.findElement(By.xpath("//a[contains(text(),'Mail')]")).click();
	   		driver.findElement(By.xpath("(//span[contains(text(),'Inbox')])[1]")).click();
	   		
	    		 
	    		List<WebElement> allMessages = driver.findElements(By.xpath("//*[contains(text(),'JabaTalks Development')]"));  
	    		if(allMessages.isEmpty()) {
		  	    	return false;
		  	      }else {
		  	    	return true;
		  	      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		}
	

}
