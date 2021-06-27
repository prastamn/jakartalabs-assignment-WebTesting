package com.jakartalabs.assignment2may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuildCardPage extends BasePage {

	public BuildCardPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	String button = "//button[@type='button' and text()='%s']";
	String divclass = "//div [@class='%s']";
	String span = "//span [text()='%s']";

	public void clickOnButton(String buttonName) {
		By finalXpath = By.xpath(String.format(button, buttonName));
		clickAndWait(finalXpath);
	}

	public void clickOnDivClass(String divClassName) {
		By finalXpath = By.xpath(String.format(divclass, divClassName));
		clickAndWait(finalXpath);
	}

	public void clickOnSpan(String spanName) {
		By finalXpath = By.xpath(String.format(span, spanName));
		clickAndWait(finalXpath);
	}

}
