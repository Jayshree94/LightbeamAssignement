Business Need: To Verify search functionality

  @sanity
  Scenario: To verify user should not be able to get authenticate with invalid credentials
    Given I set Post login api endpoint
    When  I set the request header for login
    And   I set the request body
    And   Sends post HTTP request for login
    Then  I received valid HTTP response code 400

  @sanity
  Scenario: To verify user should be able to get authenticate with valid credentials
    Given I set Post login api endpoint
    When  I set the request header for login
    And   I set the request body
    And   Sends post HTTP request for login
    Then  I received valid HTTP response code 200

  @sanity
  Scenario Outline: To verify API should written correct search result count
    Given I set the url for search API
    When  I set the headers for search api
    And   I set the params for search API
    And   the user fires a search query for "<searchQuery>"
    Then  the API should return the correct results count

    Examples:
      | searchQuery     |
      | adhaar jayshree |

  @sanity
  Scenario Outline: To verify API should give all the search results values
    Given I set the url for search API
    When  I set the headers for search api
    And   I set the params for search API
    And   the user fires a search query for "<searchQuery>"
    Then  the API should return search results with all values with same name "adhaar jayshree"
    Examples:
      | searchQuery     |
      | adhaar jayshree |

  @sanity
  Scenario Outline: To verify API should give all the search results values
    Given I set the url for search API
    When  I set the headers for search api
    And   I set the params for search API
    And   the user fires a search query for "<searchQuery>"
    Then  the API should return 400 bad request with validation message
    Examples:
      | searchQuery     |
      |  @@@!#$%^       |
      |                 |
      |           addhar|

