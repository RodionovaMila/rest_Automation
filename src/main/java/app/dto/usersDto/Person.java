package app.dto.usersDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Person {
   private String name;
   private String job;
   private String id;
   private String createdAt;
   private String updatedAt;

}
