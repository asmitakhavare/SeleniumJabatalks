package com.jabatalks.singleton;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitiateClass {
public static WebDriver driver;
	private InitiateClass() {
		
	}
	
	public static WebDriver getInstance(String typeOfBrowser) {
		
		if (typeOfBrowser.equalsIgnoreCase("chrome")) {
			if (driver==null) {
				driver = new ChromeDriver();
				return driver;
			}
		}
		return driver;
	}
	
}
