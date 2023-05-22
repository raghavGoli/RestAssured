import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class createPutRequest {

    public static void main(String[] args) {

        RestAssured
        .given()
        .log().all()
        .baseUri("https://restful-booker.herokuapp.com/")
        .basePath("booking/1")
                .header("Content-type","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
        .body("{\n" +
                "    \"firstname\" : \"raghav\",\n" +
                "    \"lastname\" : \"goli1988\",\n" +
                "    \"totalprice\" : 678,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-02-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}")

        .put().then().log().all().assertThat().statusCode(200);

    }
}
