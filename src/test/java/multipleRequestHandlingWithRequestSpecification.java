import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class multipleRequestHandlingWithRequestSpecification {
    RequestSpecification requestSpecification = null;

    @BeforeClass
    public void setupRequestSpec() {
        requestSpecification = RestAssured.given();
        requestSpecification.log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .contentType(ContentType.JSON);
    }


    @Test
    public void createBooking() {

        RestAssured
                .given()
                .spec(requestSpecification)
                .basePath("booking")
                .body("{\n" +
                        "    \"firstname\" : \"raghav\",\n" +
                        "    \"lastname\" : \"venkata\",\n" +
                        "    \"totalprice\" : 678,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Lunch\"\n" +
                        "}")

                .post().then().log().all().statusCode(200);

    }


    @Test
    public void updateBooking() {

        RestAssured
                .given()
                .spec(requestSpecification)
                .basePath("booking/26")
                //.header("Content-type", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
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
