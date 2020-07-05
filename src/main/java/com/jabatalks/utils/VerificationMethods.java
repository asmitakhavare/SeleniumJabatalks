package com.jabatalks.utils;

import org.openqa.selenium.WebDriver;

public interface VerificationMethods {

	Boolean verifyDropDownValues(String[] values,WebDriver driver);
	Boolean verifySignUp(WebDriver driver,String path);
}
