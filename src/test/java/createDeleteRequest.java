import io.restassured.RestAssured;

public class createDeleteRequest {

    public static void main(String[] args) {

        RestAssured
        .given()
        .log().all()
        .baseUri("https://restful-booker.herokuapp.com/")
        .basePath("booking/9")
                .header("Content-type","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
        .delete().then().log().all().assertThat().statusCode(201);

    }
}
