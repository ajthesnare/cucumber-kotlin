Feature: A/B Testing Page - Content
  Valid static and dynamic page content

  Background:
    Given I am on the "A/B Testing" page

  Scenario: Something something the title is dynamic
    Then the text for element "h3" should be one of the following:
      | A/B Test Control     |
      | A/B Test Variation 1 |

  Scenario: Something something the description
    Then the following text should display:
      | Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through). |
