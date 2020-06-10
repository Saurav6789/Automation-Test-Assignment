package com.verifone.testrunners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "json:target/positive/cucumber.json", "pretty", "html:target/Cucumber_Reports/cucumber.html",
		"com.cucumber.listener.ExtentCucumberFormatter" }, features = "src/test/resources/featureFiles", glue = "com.verifone.stepdefinitions"

)

public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public static void setup() {
		// Initiates the extent report and generates the output in the
		// output/Run_<unique timestamp>/report.html file by default.
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String fileName = System.getProperty("user.dir") + "\\target\\Extent_Reports\\" + strDate + ".html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile, false);
		
		// Loads the extent config xml to customize on the report.
		ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "v80.0");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.8.1");

		// Also you can add system information using a hash map
		// Map systemInfo = new HashMap();
		HashMap<String, String> systemInfo = new HashMap<String, String>();
		systemInfo.put("Cucumber version", "v1.2.3");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);
	}

}

