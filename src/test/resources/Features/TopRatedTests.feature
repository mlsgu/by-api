Feature: Test TopRated End Points

  As a user, i want to GET Top Rated Movies with valid API Key

  Scenario: Get Top Rated Movies with valid API Key
    Given User has valid API Key
    When User sends a GET request with apiKey to EndPoint:/movie/top_rated
    Then User should get 200OK response code
    
  As a user, i want to GET Top Rated Movies with inValid API Key
  
  Scenario: Get Top Rated Movies with inValid API Key
    Given User has inValid API Key
    When User sends a GET request with apiKey to EndPoint:/movie/top_rated
    Then User should get 401 Unauthorized response code
  
  
