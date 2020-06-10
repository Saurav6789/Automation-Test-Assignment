package com.verifone.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VerifoneLeadershipLocators {
	
	@FindBy(how = How.XPATH, using = "//h1[@class='hero__title']")
	public WebElement titleVerifoneLeadershipPage;
    
	@FindBy(how = How.XPATH, using = "//span[@class='header-menu__logo-plain']//img[contains(@class,'lazyloaded')]")
	public WebElement hdrImgVerifone;
	
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Verifone and Francisco Partners Announce New Leade')]")
	public WebElement txtQuoteBlock;
	
	@FindBy(how = How.LINK_TEXT, using = "Support for Partners")
	public WebElement linkSupportForPartners;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Verifone Region and Countries')]")
	public WebElement linkVerifoneRegionAndCountries;
	
	@FindBy(how = How.LINK_TEXT, using = "Preparing to Re-open")
	public WebElement linkPrepareToReopen;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'About Us')]")
	public WebElement footerAboutUs;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='footer__social']//li[3]//a[1]//*[local-name()='svg']")
	public WebElement footerLinkedIn;
	
	@FindBy(how = How.XPATH, using = "//*[@href='https://www.linkedin.com/company/verifone/ ']")
	public WebElement footerLinkedIn1;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@href,'https://www.linkedin.com/company/verifone/')]")
	public WebElement footerLinkedIn2;
}
