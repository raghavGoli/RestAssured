import io.restassured.RestAssured;

public class createPatchRequest {

    public static void main(String[] args) {

        RestAssured
        .given()
        .log().all()
        .baseUri("https://restful-booker.herokuapp.com/")
        .basePath("booking/3965")
                .header("Content-type","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
        .body("{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}")

        .patch().then().log().all().assertThat().statusCode(200);

    }
}
