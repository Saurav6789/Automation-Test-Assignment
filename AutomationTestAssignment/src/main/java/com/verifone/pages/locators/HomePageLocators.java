package com.verifone.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocators {

	@FindBy(how = How.XPATH, using = "//a[@id='CybotCookiebotDialogBodyLevelButtonAccept']")
	public WebElement btnCookieAccept;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Global eCommerce')]")
	public WebElement titleHomePage;

	@FindBy(how = How.XPATH, using = "//input[@id='footer-search-input']")
	public WebElement txtBoxSearch;

	@FindBy(how = How.XPATH, using = "//form[@name='search_form']//div//button")
	public WebElement btnSearch;

}
