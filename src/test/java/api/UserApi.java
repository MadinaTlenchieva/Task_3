package api;
import static io.restassured.RestAssured.given;

public class UserApi {

    public static String[] createUser() {
        String email = "test" + System.currentTimeMillis() + "@mail.com";
        String password = "123456";

        given()
                .contentType("application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"name\":\"test\"}")
                .post("https://stellarburgers.education-services.ru/api/auth/register")
                .then()
                .statusCode(200);

        return new String[]{email, password};
    }

    public static String getToken(String email, String password) {
        return given()
                .contentType("application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .post("https://stellarburgers.education-services.ru/api/auth/login")
                .then()
                .extract()
                .path("accessToken");
    }

    public static void deleteUser(String token) {
        given()
                .header("Authorization", token)
                .delete("https://stellarburgers.education-services.ru/api/auth/user")
                .then()
                .statusCode(202);
    }
}