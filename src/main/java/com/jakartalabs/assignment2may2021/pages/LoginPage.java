package com.jakartalabs.assignment2may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	By email = By.name("email");
	By password = By.name("password");
	By signInBtn = By.xpath("//button[@type='submit' and text()='Sign in']");

	public void login(String useremail, String pwd) {
		setText(email, useremail);
		setText(password, pwd);
		clickAndWait(signInBtn);
	}

}
