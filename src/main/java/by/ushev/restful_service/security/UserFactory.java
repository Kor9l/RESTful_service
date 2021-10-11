package by.ushev.restful_service.security;

import by.ushev.restful_service.domain.Users;
import by.ushev.restful_service.enums.Role;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public final class UserFactory {


    public static UserDetails create(Users user) {
        return new UserPrincipal(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                mapToGrantedAuthorities(user.getRole())
        ) {

        };
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role userRole) {
        List<GrantedAuthority> userRoles = new ArrayList<>();
        userRoles.add(new SimpleGrantedAuthority(userRole.name()));
        return userRoles;
    }
}
