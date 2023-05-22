import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class createGetRequest {

    public static void main(String[] args) {

        RestAssured
        .given()
        .log().all()
        .baseUri("https://restful-booker.herokuapp.com/")
        .basePath("booking/{id}").pathParam("id",3965)
        .contentType(ContentType.JSON)
        .get().then().log().all().statusCode(200);

    }
}
