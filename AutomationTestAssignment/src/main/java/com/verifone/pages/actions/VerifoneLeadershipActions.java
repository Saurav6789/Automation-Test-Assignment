package com.verifone.pages.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import com.verifone.pages.locators.VerifoneLeadershipLocators;
import com.verifone.pages.utilities.SeleniumDriver;

public class VerifoneLeadershipActions {
	
	VerifoneLeadershipLocators verifoneLeadershipLocators = null;
	
    public VerifoneLeadershipActions(){
    	
    	this.verifoneLeadershipLocators=new VerifoneLeadershipLocators();
    	PageFactory.initElements(SeleniumDriver.getDriver(), verifoneLeadershipLocators);
    }
    
    public String getVerifoneLeadershipPageTitle(){
    	
    	return verifoneLeadershipLocators.titleVerifoneLeadershipPage.getText();
    }
    
    public String getVerifoneHeader(){
    	
        SeleniumDriver.waitElementToVisible(verifoneLeadershipLocators.hdrImgVerifone);
    	return verifoneLeadershipLocators.hdrImgVerifone.getAttribute("alt");
    }
    
    public String getQuoteBlock(){
    	return verifoneLeadershipLocators.txtQuoteBlock.getText();
    }
    
    public String getSupportForPartnerText(){
    	return verifoneLeadershipLocators.linkSupportForPartners.getText();
    }
    
    
    public String getVerifoneRegionAndCountriesText(){
    	return verifoneLeadershipLocators.linkVerifoneRegionAndCountries.getText();
    }
    
    public String getPrepareToReopenText(){
    	return verifoneLeadershipLocators.linkPrepareToReopen.getText();
    }
    
    public String getAboutUsFooter(){
    	return verifoneLeadershipLocators.footerAboutUs.getText();
    }
    
    public void clkLinkedInFooter() {
		
		JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
		js.executeScript("document.getElementsByClassName('footer__social-link')[2].click();");   
		
	}
    
}
