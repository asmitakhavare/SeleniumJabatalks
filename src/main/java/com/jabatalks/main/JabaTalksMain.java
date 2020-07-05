package com.jabatalks.main;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.jabatalks.singleton.InitiateClass;
import com.jabatalks.utils.VerificationMethods;
import com.jabatalks.utils.Impl.VerificationMethodsImpl;

import junit.framework.Assert;

public class JabaTalksMain {

	public static void main(String[] args) {
		if (args[0]!=null&&args[0].equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumsoftwares\\chromedriver.exe");
		}
		WebDriver driver=	InitiateClass.getInstance(args[0]);
		    driver.get("http://jt-dev.azurewebsites.net/#/SignUp");  
		    VerificationMethods methods= new VerificationMethodsImpl();
		    String[] language = {"English", "Dutch"};
		  Boolean match= methods.verifyDropDownValues(language,driver) ;
		   
		  
		 
		   

if (!match) {
		    
    match=methods.verifySignUp(driver, args[1]);
    driver.close();
    Assert.assertTrue(match); 
		  	      
		  	      
		  	   
}else {
	Assert.assertTrue(match);
}
	}

}
