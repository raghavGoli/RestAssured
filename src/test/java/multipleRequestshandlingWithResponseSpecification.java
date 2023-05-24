import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class multipleRequestshandlingWithResponseSpecification {

    ResponseSpecification responseSpecification;

    @BeforeClass
    public void createResponseSpec() {
        responseSpecification = RestAssured.expect();
        responseSpecification.contentType(ContentType.JSON).time(Matchers.lessThan(5000L)).statusCode(200);

    }


    @Test
    public void createbooking1() {

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
                .post().then().log().all().spec(responseSpecification);

    }


    @Test
    public void createbooking2() {

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
                .post().then().log().all().spec(responseSpecification);

    }
}
