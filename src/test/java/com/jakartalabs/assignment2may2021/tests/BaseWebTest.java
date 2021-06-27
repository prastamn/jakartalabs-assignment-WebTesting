package com.jakartalabs.assignment2may2021.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jakartalabs.assignment2may2021.utils.DataUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebTest implements IWebDriver {
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jakartalabs.may2021.tests.IWebDriver#createWebDriver()
	 */
	@BeforeMethod
	public void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();
		driver.get().get(DataUtils.getDataFromExcel("Config", "BaseUrl"));
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jakartalabs.may2021.tests.IWebDriver#quitWebDriver()
	 */
	@AfterMethod
	public void quitWebDriver(ITestResult itr) {
		if (itr.getStatus() == ITestResult.FAILURE) {
			takeScreenshot(itr);
		}

		driver.get().quit();
		driver.remove();
	}

	/**
	 * @param itr
	 */
	private void takeScreenshot(ITestResult itr) {

		File src = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);

		File destination = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ itr.getName() + System.currentTimeMillis() + ".png");

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
