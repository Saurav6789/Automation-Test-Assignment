package com.verifone.stepdefinitions;



import com.verifone.pages.utilities.SeleniumDriver;

import cucumber.api.java.Before;


public class BeforeActions {
	
	@Before
    public static void setUp() {
       SeleniumDriver.setUpDriver();
       
    }
	
}
