import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class createPostRequest {

    public static void main(String[] args) {

        RestAssured
        .given()
        .log().all()
        .baseUri("https://restful-booker.herokuapp.com/")
        .basePath("booking")
        .body("{\n" +
                "    \"firstname\" : \"raghav\",\n" +
                "    \"lastname\" : \"venkata\",\n" +
                "    \"totalprice\" : 678,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}")
        .contentType(ContentType.JSON)
        .post().then().log().all().statusCode(200);

    }
}
