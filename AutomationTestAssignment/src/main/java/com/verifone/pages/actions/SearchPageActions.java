package com.verifone.pages.actions;

import org.openqa.selenium.support.PageFactory;

import com.verifone.pages.locators.SearchPageLocators;
import com.verifone.pages.utilities.SeleniumDriver;

public class SearchPageActions {

	SearchPageLocators searchPageLocators = null;
	public final static int TIMEOUT = 30;

	public SearchPageActions() {

		this.searchPageLocators = new SearchPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), searchPageLocators);

	}

	public String getSearchPageTitle() {
		return searchPageLocators.titleSearchPage.getText();

	}

	public void clkFilterToggle() {
		searchPageLocators.toggleFilter.click();
	}

	public void clkInsightChkBox() {

		SeleniumDriver.clkWebElement(searchPageLocators.chkboxInsight);
	}

	public void clkPressReleaseChkBox() {
		SeleniumDriver.clkWebElement(searchPageLocators.chkboxPressRelease);
	}

	public void closeFilterToggle() {

		SeleniumDriver.clkWebElement(searchPageLocators.closeToggleFilter);

	}

	public String getSearchResultLink() {
		SeleniumDriver.waitElementToVisible(searchPageLocators.linkSearchResult);
		return searchPageLocators.linkSearchResult.getText();
	}

	public void clkSearchResultLink() {

		SeleniumDriver.waitElementToClickable(searchPageLocators.linkSearchResult);
		searchPageLocators.linkSearchResult.click();
	}

}
