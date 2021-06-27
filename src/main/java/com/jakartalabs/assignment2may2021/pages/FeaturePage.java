package com.jakartalabs.assignment2may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeaturePage extends BasePage {

	public FeaturePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	String button = "//button[@type='button' and text()='%s']";

	public void clickOnButton(String buttonName) {
		By finalXpath = By.xpath(String.format(button, buttonName));
		clickAndWait(finalXpath);
	}

}
