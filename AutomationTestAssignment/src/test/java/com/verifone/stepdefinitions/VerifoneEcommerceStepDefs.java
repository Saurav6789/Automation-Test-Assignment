package com.verifone.stepdefinitions;

import java.util.List;

import org.testng.Assert;

import com.verifone.pages.actions.HomePageActions;
import com.verifone.pages.actions.SearchPageActions;
import com.verifone.pages.actions.VerifoneLeadershipActions;
import com.verifone.pages.utilities.Log;
import com.verifone.pages.utilities.SeleniumDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifoneEcommerceStepDefs {

	HomePageActions homePageActions = new HomePageActions();
	SearchPageActions searchPageActions = new SearchPageActions();
	VerifoneLeadershipActions verifoneLeadershipActions = new VerifoneLeadershipActions();
	Log log = new Log();

	@Given("^User enters the dimebox website URL$")
	public void user_enters_the_dimebox_website_URL() throws Throwable {

		log.startLog();
		SeleniumDriver.openPage();
		homePageActions.clkAcceptCookies();

	}

	@Given("^User navigates to verifone global E-commerce platform \"([^\"]*)\"$")
	public void user_navigates_to_verifone_global_E_commerce_platform(String strExpectedURL) throws Throwable {

		String currentURL = SeleniumDriver.getCurrentURL();
		log.info("The current URL is" + currentURL);
		Assert.assertEquals(currentURL, strExpectedURL);

	}

	@Given("^User can see the following title \"([^\"]*)\"on e-commerce home page$")
	public void user_can_see_the_following_title_on_e_commerce_home_page(String strHomePageTitle) throws Throwable {
		log.info("The E-Commerce Home Page title" + homePageActions.getHomePageTitle());
		Assert.assertEquals(homePageActions.getHomePageTitle(), strHomePageTitle);
	}

	@When("^User enters \"([^\"]*)\" in search bar present in the footer and click on search button$")
	public void user_enters_in_search_bar_present_in_the_footer_and_click_on_search_button(String strSearchValue)
			throws Throwable {
		homePageActions.setSearchTextbox(strSearchValue);
		homePageActions.clkSearchBtn();
	}

	@When("^User verifies that the \"([^\"]*)\" name is present in searched for section$")
	public void user_verifies_that_the_name_is_present_in_searched_for_section(String strSearchedValue)
			throws Throwable {

		log.info("The following name is present" + searchPageActions.getSearchPageTitle());
		Assert.assertEquals(searchPageActions.getSearchPageTitle(), strSearchedValue);
	}

	@When("^User selects 'Insight' and 'Press Release' filter criteria checkboxes within Insight type section$")
	public void user_selects_Insight_and_Press_Release_filter_criteria_checkboxes_within_Insight_type_section()
			throws Throwable {

		searchPageActions.clkFilterToggle();
		searchPageActions.clkInsightChkBox();
		searchPageActions.clkPressReleaseChkBox();

	}

	@When("^User clicks on the close icon of filter$")
	public void user_clicks_on_the_close_icon_of_filter() throws Throwable {

		searchPageActions.closeFilterToggle();

	}

	@When("^User clicks on the first result by clicking on the title \"([^\"]*)\"$")
	public void user_clicks_on_the_first_result_by_clicking_on_the_title(String strSearchedLink) throws Throwable {
        log.info("The First result of the page contains:" +searchPageActions.getSearchResultLink() );
		Assert.assertEquals(searchPageActions.getSearchResultLink(), strSearchedLink);
		searchPageActions.clkSearchResultLink();
	}

	@Then("^User verifies the header \"([^\"]*)\" with an image$")
	public void user_verifies_the_header_with_an_image(String strExpectedHeader) throws Throwable {
        log.info("The actual header on the page is :" +verifoneLeadershipActions.getVerifoneHeader());
		String strActualHeader = verifoneLeadershipActions.getVerifoneHeader();
		Assert.assertEquals(strActualHeader, strExpectedHeader);

	}

	@Then("^User verifies the quote \"([^\"]*)\" block$")
	public void user_verifies_the_quote_block(String strExpectedQuote) throws Throwable {
        log.info("The actual quote block on the page :" +verifoneLeadershipActions.getQuoteBlock());
		String strActualBlock = verifoneLeadershipActions.getQuoteBlock();
		Assert.assertEquals(strActualBlock, strExpectedQuote);

	}

	@Then("^User verifies the related insights which are$")
	public void user_verifies_the_related_insights_which_are(DataTable insights) throws Throwable {

		List<List<String>> data = insights.raw();
		Assert.assertEquals(verifoneLeadershipActions.getSupportForPartnerText(), data.get(0).get(0));
		Assert.assertEquals(verifoneLeadershipActions.getVerifoneRegionAndCountriesText(), data.get(0).get(1));
		Assert.assertEquals(verifoneLeadershipActions.getPrepareToReopenText(), data.get(0).get(2));

	}

	@Then("^User verifies the footer \"([^\"]*)\" is present$")
	public void user_verifies_the_footer_is_present(String strAboutUs) throws Throwable {

		String strActualAboutUS = verifoneLeadershipActions.getAboutUsFooter();
		Assert.assertEquals(strActualAboutUS, strAboutUs);
		Assert.assertEquals(verifoneLeadershipActions.getAboutUsFooter(), strAboutUs);

	}

	@Then("^User clicks on the LinkedIn button in the footer$")
	public void user_clicks_on_the_LinkedIn_button_in_the_footer() throws Throwable {
		try {

			verifoneLeadershipActions.clkLinkedInFooter();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^User navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String strExpectedURL) throws Throwable {

		SeleniumDriver.switchTab();
		String currentURL = SeleniumDriver.getCurrentURL();
		Assert.assertEquals(currentURL, strExpectedURL);

	}

}
