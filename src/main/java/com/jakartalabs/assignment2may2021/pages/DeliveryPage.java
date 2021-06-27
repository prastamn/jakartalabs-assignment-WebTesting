package com.jakartalabs.assignment2may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryPage extends BasePage {

	public DeliveryPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	// button[@type='button' and text()='Save ']
	String button = "//button[@type='button' and text()='%s']";
	String textbox = "//input[@type='text' and @placeholder='eg. Booking.com']";

	public void clickOnButton(String buttonName) {
		By finalXpath = By.xpath(String.format(button, buttonName));
		clickAndWait(finalXpath);
	}

	public void inputText(String placeholder, String uniqueValue) {
		By finalXpath = By.xpath(String.format(textbox, placeholder));
		setText(finalXpath, uniqueValue);
	}

}
