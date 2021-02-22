package resthelpers.helper;

import io.restassured.response.Response;
import java.util.logging.Logger;


import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class RateMovieHelper{

	Logger log = Logger.getLogger(RateMovieHelper.class.getName());

	Response response;

	public Response getRequestToken(String apiKey) {

		response = given().
				log().all().contentType(ContentType.JSON).
				param("api_key", apiKey).
				when().
				get("/authentication/token/new").
				then().
				log().all().
				extract().
				response();

		log.info("getRequestToken Response: " + response.asString());

		return response;

	}

	public Response getGuestSession(String apiKey) {

		response = given().
				log().all().contentType(ContentType.JSON).
				param("api_key", apiKey).
				when().
				get("/authentication/guest_session/new").
				then().
				log().all().
				extract().
				response();

		log.info("getGuestSession Response " + response.asString());

		return response;

	}

	public Response getMovieDetails(String apiKey, int movie_id) {

		response = given().
				log().all().contentType(ContentType.JSON).
				param("api_key", apiKey).
				when().
				get("/movie/" + movie_id).
				then().
				log().all().
				extract().
				response();

		log.info("getMovieDetails Response: " + response.asString());

		return response;

	}

	public Response postRateMovie(String apiKey, String guest_session_id, int movie_id, int score) {

		String payload = "{\n" + 
		"    \"value\": \"" + score + "\"\n" + 
		"}";

		response = given().
				log().all().contentType(ContentType.JSON).
				with().
				queryParam("api_key", apiKey).
				queryParam("guest_session_id", guest_session_id).
				body(payload).
				when().
				post("/movie/" + movie_id + "/rating").
				then().
				log().all().
				extract().
				response();

		log.info("postRateMovie response : " + response.asString());

		return response;

	}

}
