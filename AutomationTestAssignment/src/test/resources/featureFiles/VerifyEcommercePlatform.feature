Feature: Verifone E-commerce Platform

  Scenario: Validating Verifone Leadership Transition
    Given User enters the dimebox website URL
    And User navigates to verifone global E-commerce platform "https://www.verifone.com/en/uk/services/global-ecommerce-platform"
    And User can see the following title "Global eCommerce"on e-commerce home page
    When User enters "Mike Pulli" in search bar present in the footer and click on search button
    And User verifies that the "Mike Pulli" name is present in searched for section
    And User selects 'Insight' and 'Press Release' filter criteria checkboxes within Insight type section
    And User clicks on the close icon of filter
    And User clicks on the first result by clicking on the title "Leadership Transition at Verifone"
    Then User verifies the header "Verifone" with an image
    And User verifies the quote "Verifone and Francisco Partners Announce New Leadership Upon Closing" block
    And User verifies the related insights which are
      | Support for Partners | Verifone Region and Countries | Preparing to Re-open |
    And User verifies the footer "About Us" is present
    And User clicks on the LinkedIn button in the footer
    And User navigates to "https://www.linkedin.com/company/verifone/"
