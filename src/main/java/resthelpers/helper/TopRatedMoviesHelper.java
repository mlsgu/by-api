package resthelpers.helper;
import io.restassured.response.Response;
import java.util.logging.Logger;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class TopRatedMoviesHelper {

	Logger log = Logger.getLogger(TopRatedMoviesHelper.class.getName());

	Response response;

	public Response getTopRatedMovies(String apiKey) {

		response = given().
				log().all().contentType(ContentType.JSON).
				param("api_key", apiKey).
				when().
				get("/movie/top_rated").
				then().
				log().all().
				extract().
				response();
		
		log.info("response is: " + response.asString());
		return response;
	}

}