package app;

import app.config.UsersHttpRequest;
import app.dto.usersDto.User;
import app.dto.usersDto.UserDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTest {

    private static UsersHttpRequest usersHttpRequest;
    private static User expectedUser;

    @BeforeAll
    public static void setUp() {
        usersHttpRequest = new UsersHttpRequest();
        expectedUser = new User(2, "Janet", "Weaver", "janet.weaver@reqres.in");
    }

    @Test
    public void testMapUser() {

       // usersHttpRequest.createUser(expectedUser).then().statusCode(201);

        UserDetail detail = usersHttpRequest.getUsers(expectedUser.getId().toString())
                .then()
                .statusCode(200)
                .extract().as(UserDetail.class);
        User actual = detail.getData();

        Assertions.assertEquals(actual.getId(), expectedUser.getId());
        Assertions.assertEquals(actual.getFirst_name(), expectedUser.getFirst_name());
        Assertions.assertEquals(actual.getLast_Name(), expectedUser.getLast_Name());
        Assertions.assertEquals(actual.getEmail(), expectedUser.getEmail());
        Assertions.assertEquals(actual, expectedUser);
    }
}