package com.jakartalabs.assignment2may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	String panel = "//div[@class='%s']";
	String button = "//button[@type='button' and text()='%s']";
	By inputPassword = By.xpath("//input[@type='password' and @name='password']");
	String span = "//span[text()='%s']";
	By template = By.xpath(
			"//img[@src='https://bstudio-staging.azureedge.net/alpha-stg-assets/uploads/application/new_background/10577/Test.jpg']");
	// span[text()='Build Now']

	public void clickOnPanel(String panelName) {
		By finalXpath = By.xpath(String.format(panel, panelName));
		clickAndWait(finalXpath);
	}

	public void clickOnButton(String buttonName) {
		By finalXpath = By.xpath(String.format(button, buttonName));
		clickAndWait(finalXpath);
	}

	public void scrollByElement() {
		scrollExecuteJs("arguments[0].scrollIntoView()", inputPassword);
	}

	public void scrollByElement2() {
		scrollExecuteJs("arguments[0].scrollIntoView()", template);
	}

	public void clickOnSpan(String templateName) {
		By finalXpath = By.xpath(String.format(span, templateName));
		clickAndWait(finalXpath);
	}

	public void chooseTemplate() {
		clickAndWait(template);
	}
}
