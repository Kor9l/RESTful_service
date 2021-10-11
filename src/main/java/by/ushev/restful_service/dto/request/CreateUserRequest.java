package by.ushev.restful_service.dto.request;

import by.ushev.restful_service.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {

    private String email;

    private String fullName;

    private String password;

    private Role role = Role.ROLE_USER;
}
