package com.jakartalabs.assignment2may2021.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.jakartalabs.assignment2may2021.AppEnums;
import com.jakartalabs.assignment2may2021.pages.BuildCardPage;
import com.jakartalabs.assignment2may2021.pages.DashboardPage;
import com.jakartalabs.assignment2may2021.pages.DeliveryPage;
import com.jakartalabs.assignment2may2021.pages.FeaturePage;
import com.jakartalabs.assignment2may2021.pages.HomePage;
import com.jakartalabs.assignment2may2021.pages.LoginPage;
import com.jakartalabs.assignment2may2021.pages.WelcomePage;
import com.jakartalabs.assignment2may2021.utils.DataUtils;

public class AppTest extends BaseWebTest {

	WelcomePage welcomePage = new WelcomePage(driver, explicitWait);
	HomePage homePage = new HomePage(driver, explicitWait);
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	FeaturePage featurePage = new FeaturePage(driver, explicitWait);
	DeliveryPage deliveryPage = new DeliveryPage(driver, explicitWait);
	BuildCardPage buildCardPage = new BuildCardPage(driver, explicitWait);
	DashboardPage dashboardPage = new DashboardPage(driver, explicitWait);

	@Test
	public void LoginAndCreateProject() {

		welcomePage.clickOnButtonItem(AppEnums.MenuNames.CHOOSEBASE.toString());
		welcomePage.clickOnIconItem(AppEnums.MenuNames.ClOSEICON.toString());
		homePage.clickOnPanel(AppEnums.MenuNames.NATASHAMSGPANEL.toString());
		homePage.clickOnPanel(AppEnums.MenuNames.NATASHACLOSEPANEL.toString());
		homePage.clickOnButton(AppEnums.MenuNames.SIGNIN.toString());
		homePage.scrollByElement();

		String useremail = DataUtils.getDataFromExcel("Config", "Email");
		String password = DataUtils.getDataFromExcel("Config", "Password");

		loginPage.login(useremail, password);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		homePage.chooseTemplate();
		homePage.clickOnSpan(AppEnums.SpanNames.BUILDNOW.toString());

		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		featurePage.clickOnButton(AppEnums.ButtonNames.PLANDELIVERY.toString());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		deliveryPage.clickOnButton(AppEnums.ButtonNames.DONE.toString());

		String uniqueValue = "automation88438";

		deliveryPage.inputText(AppEnums.TextBoxNames.BOOKING.toString(), uniqueValue);

		deliveryPage.clickOnButton(AppEnums.ButtonNames.SAVE.toString());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buildCardPage.clickOnDivClass(AppEnums.DivClassNames.PROFILE.toString());

		buildCardPage.clickOnSpan(AppEnums.SpanNames.DASHBOARD.toString());

		assertEquals(dashboardPage.verifyProjectName(uniqueValue), true);

	}

}
