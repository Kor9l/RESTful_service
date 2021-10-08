package by.ushev.RESTful_service.dto.response;

import by.ushev.RESTful_service.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private Integer id;

    private String email;

    private String fullName;

    private String password;

    private Role role = Role.ROLE_USER;

}
