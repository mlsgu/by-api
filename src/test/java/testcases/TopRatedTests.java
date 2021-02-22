package testcases;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import resthelpers.helper.TopRatedMoviesHelper;
import java.util.logging.Logger;


public class TopRatedTests extends TestBase {

	Response response;
	Logger log = Logger.getLogger(TopRatedTests.class.getName());
	String apiKey = getProperties().getProperty("apiKey");
	String InvalidApiKey = getProperties().getProperty("InvalidApiKey");

	@Test
	public void getTopRatedMoviesTest() {
		log.info("Top Rated Movies test is started");
		
		TopRatedMoviesHelper topRatedHelper = new TopRatedMoviesHelper();
		
		log.info("1-Get the Top Rated Movies with api key :" + apiKey);
		response = topRatedHelper.getTopRatedMovies(apiKey);

		log.info("2-Status code should be 200 OK");
		Assert.assertEquals(response.getStatusCode(), 200, "Response is not matched");
		log.info("Get Top Rated Movies test is ended");
	}

	@Test
	public void getTopRatedUnauthorizedTest() {
		log.info("Get Top Rated Movies Unauthorized test is started");
		
		TopRatedMoviesHelper topRatedHelper = new TopRatedMoviesHelper();
		
		log.info("1-Get the Top Rated Movies with invalid api key :" + InvalidApiKey);
		response = topRatedHelper.getTopRatedMovies(InvalidApiKey);

		log.info("2-Status code should be 401 Unauthorized");
		Assert.assertEquals(response.getStatusCode(), 401, "Response is not matched");
		log.info("Get Top Rated Movies Unauthorized test is ended");

	}

}