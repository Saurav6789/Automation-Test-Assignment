package com.verifone.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPageLocators {
	
	
	@FindBy(how = How.XPATH, using = "//h1[@class='hero__title']")
	public WebElement titleSearchPage;
	
	@FindBy(how = How.CLASS_NAME, using = "filter__toggle__icon")
	public WebElement toggleFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Insight']")
	public WebElement chkboxInsight;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Press Release']")
	public WebElement chkboxPressRelease;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='filter__toggle js-search-filter-toggle']")
	public WebElement closeToggleFilter;
	
	@FindBy(how = How.LINK_TEXT, using = "Leadership Transition at Verifone")
	public WebElement linkSearchResult;
	
    
}
