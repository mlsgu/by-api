package testcases;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import resthelpers.helper.RateMovieHelper;
import java.util.logging.Logger;

public class RateMovieTests extends TestBase {
	
	Logger log = Logger.getLogger(TopRatedTests.class.getName());
	String apiKey = getProperties().getProperty("apiKey");
	String invalidGuestSessionId = getProperties().getProperty("invalidGuestSessionId");
	int movieID =Integer.parseInt(getProperties().getProperty("movieID"));
	int movieRate =Integer.parseInt(getProperties().getProperty("movieRate"));
	Response response;
	String requestToken;
	String guestSessionId;
	String movieName;

	@Test
	public void getRequestTokenTest() {
		log.info("Get Request Token test is started");
		
		RateMovieHelper rateMovieHelper = new RateMovieHelper();
		
		log.info("1- Get Request Token with api key :" + apiKey );
		response = rateMovieHelper.getRequestToken(apiKey);
		requestToken = response.jsonPath().getString("request_token");
		log.info("requestToken :" + requestToken);

	
		log.info("2-Status code should be 200 OK");
		Assert.assertEquals(response.getStatusCode(), 200, "Response is not matched");

		log.info("Get Request Token test is ended");
	}

	@Test
	public void rateMovieWithValidGuestSession() {
		
		log.info("Rate Movie With Valid Guest Session is started");
		
		RateMovieHelper rateMovieHelper = new RateMovieHelper();
		

		log.info("1- Create Guest Session with api key :" + apiKey + " and status code is 200 OK ");
		response = rateMovieHelper.getGuestSession(apiKey);
		guestSessionId = response.jsonPath().getString("guest_session_id");
		log.info("guestSessionId :" + guestSessionId);
		
		Assert.assertEquals(response.getStatusCode(), 200, "Response is not matched");

		log.info("2- Get Movie details and status code is 200 OK ");
		response = rateMovieHelper.getMovieDetails(apiKey,movieID);
		movieName = response.jsonPath().getString("original_title");

		log.info("3- Status code should be 200 OK ");
		Assert.assertEquals(response.getStatusCode(), 200, "Response is not matched");
		log.info("4- Movie name should be Cars");
		Assert.assertEquals(movieName, "Cars", "Response is not matched");

		log.info("5- Post Rate to the Movie with valid guest session id ");
		response = rateMovieHelper.postRateMovie(apiKey,guestSessionId,movieID,movieRate);
		
		log.info("6-Status code should be 201 OK");
		Assert.assertEquals(response.getStatusCode(), 201, "Response is not matched");
		
		log.info("Rate Movie With Valid Guest Session is ended");
	}
	
	@Test
	public void rateMovieWithInValidGuestSession() {
		
		log.info("Rate Movie With InValid Guest Session is started");
		
		RateMovieHelper rateMovieHelper = new RateMovieHelper();


		log.info("1- Get Movie details and status code is 200 OK ");
		response = rateMovieHelper.getMovieDetails(apiKey,movieID);
		movieName = response.jsonPath().getString("original_title");

		log.info("2- Status code should be 200 OK ");
		Assert.assertEquals(response.getStatusCode(), 200, "Response is not matched");
		log.info("3- Movie name should be Cars");
		Assert.assertEquals(movieName, "Cars", "Response is not matched");

		log.info("4- Post Rate to the Movie with InvalidGuestSessionId ");
		response = rateMovieHelper.postRateMovie(apiKey,invalidGuestSessionId,movieID,movieRate);
		
		log.info("6-Status code should be 401 OK");
		Assert.assertEquals(response.getStatusCode(), 401, "Response is not matched");
		
		log.info("Rate Movie With InValid Guest Session is ended");
	}


	
}