import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class extractResponseBodyAsString {

    public static void main(String[] args) {

       String responseBody= RestAssured
                .given()
                .log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body("{\n" +
                        "    \"firstname\" : \"jacoco\",\n" +
                        "    \"lastname\" : \"jacko\",\n" +
                        "    \"totalprice\" : 5063,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2023-05-23\",\n" +
                        "        \"checkout\" : \"2023-07-23\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Lunch\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .post().then().log().all().extract().body().asPrettyString();
            System.out.println(responseBody);

    }

}
