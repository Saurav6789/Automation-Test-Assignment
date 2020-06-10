package com.verifone.pages.actions;

import org.openqa.selenium.support.PageFactory;

import com.verifone.pages.locators.HomePageLocators;
import com.verifone.pages.utilities.SeleniumDriver;

public class HomePageActions {

	HomePageLocators homePageLocators = null;

	public HomePageActions() {

		this.homePageLocators = new HomePageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), homePageLocators);
	}

	public void clkAcceptCookies() {

		homePageLocators.btnCookieAccept.click();
	}

	public String getHomePageTitle() {

		return homePageLocators.titleHomePage.getText();
	}

	public void setSearchTextbox(String strSearchValue) {

		homePageLocators.txtBoxSearch.click();
		homePageLocators.txtBoxSearch.sendKeys(strSearchValue);

	}

	public void clkSearchBtn() {

		homePageLocators.btnSearch.click();
	}

}
