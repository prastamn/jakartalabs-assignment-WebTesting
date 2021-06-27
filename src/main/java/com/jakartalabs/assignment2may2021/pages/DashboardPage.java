package com.jakartalabs.assignment2may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {

	public DashboardPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	String actualProjectName = "//h3[text()='%s ']";

	public boolean verifyProjectName(String inputtedProjectName) {
		By finalXpath = By.xpath(String.format(actualProjectName, inputtedProjectName));

		return getText(finalXpath).equals(inputtedProjectName);

	}

}
