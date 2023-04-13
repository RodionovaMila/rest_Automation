package app;

import app.dto.usersDto.Support;
import app.dto.usersDto.User;

public interface TestData {
    Integer id = 2;
    String jobTitle = "leader";
    String userName = "Janet";
    String userLastName = "Weaver";
    String userEmail = "janet.weaver@reqres.in";
    User user = new User(id, userName, userLastName, userEmail);
    Support support = new Support("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
}
