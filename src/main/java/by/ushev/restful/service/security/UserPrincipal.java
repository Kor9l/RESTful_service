package by.ushev.restful.service.security;

import by.ushev.restful.service.domain.Users;
import by.ushev.restful.service.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class UserPrincipal implements UserDetails {

    private final Users user;
    Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(
            Integer id,
            String fullName,
            String email,
            String password,
            Role role,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.user = Users.builder()
                .id(id)
                .fullName(fullName)
                .email(email)
                .password(password)
                .role(role)
                .build();
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    public Role getRole() {return this.user.getRole();}
    @Override
    public String getUsername() {
        return this.user.getFullName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return user.getId();
    }
}

