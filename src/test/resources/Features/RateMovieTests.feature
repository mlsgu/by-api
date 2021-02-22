Feature : Test RateMovie End Points

Scenario: Get a request token
  GivenUser has valid API Key
  When User sends a GET request with apiKey to EndPoint:/authentication/token/new
  Then User should get 200OK response code
  
  
Scenario: Rate Movie with Valid Guest Session ID
  Given User has valid API Key and MovieID
  When User sends a GET  request to EndPoint:/authentication/guest_session/new
  Then User should get 200OK response code
  When User send a GET request with APIKEY and MoveID to end EndPoint: /movie/movie_id
  Then User Should get 200OK response code
  Then User Movie title should be "Cars"
  When User User send a POST request to with apiKey, guestSessionId,movieID, score to EndPoint:/movie/movie_id/rating
  Then User Should get 201 Created Success response code


Scenario: Rate Movie with inValid Guest Session ID
  Given User has valid API Key and inValidGuestSessionID and MovieID
  When User send a GET request with APIKEY and MoveID to end EndPoint: /movie/movie_id
  Then User Should get 200OK response code
  Then User Movie title should be "Cars"
  When User User send a POST request to with apiKey, InvalidguestSessionId,movieID, score to EndPoint:/movie/movie_id/rating
  Then User Should get 401 unauthorized response code
