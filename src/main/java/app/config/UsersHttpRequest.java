package app.config;

import app.dto.usersDto.Person;
import app.dto.usersDto.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UsersHttpRequest extends BaseHttpRequest {
    private static final String userUrl = "api/users";

    public Response getUsers(String id) {
        return getRequestSpecification()
                .when()
                .get(userUrl +"/"+ id);
    }

    public Response createUser(Person person) {
        return getRequestSpecification()
                .when()
                .body(person)
                .post(userUrl);
    }

    public Response updateUser(String id) {
        String updateUserApi = userUrl + "/" + id;
        return getRequestSpecification()
                .when()
                .body("{\"name\": \"Morpheus\", \"job\": \"Zion resident\"}")
                .put(updateUserApi);
    }

}
