package app;

import app.config.UsersHttpRequest;
import app.dto.usersDto.Person;
import app.dto.usersDto.User;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static app.TestData.*;

public class UsersTest {

    private static UsersHttpRequest usersHttpRequest;

    @BeforeAll
    public static void init() {
        usersHttpRequest = new UsersHttpRequest();
    }


    @Test
    public void firstTest() {
        User in = usersHttpRequest.getUsers("2")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject("data", User.class);
        Assertions.assertEquals(in, user);
    }

    @Test
    public void secondTest() {
        Person p = new Person();
        p.setId("11");
        p.setName(userName);
        p.setJob(jobTitle);

        JsonPath responce = usersHttpRequest.createUser(p)
                .then()
                .statusCode(201)
                .extract()
                .jsonPath();

        Assertions.assertEquals(responce.get("job"), jobTitle);
        Assertions.assertEquals(responce.get("name"), userName);
    }

}
