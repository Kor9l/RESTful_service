package by.ushev.RESTful_service.mapper;

import by.ushev.RESTful_service.domain.Users;
import by.ushev.RESTful_service.dto.request.CreateUserRequest;
import by.ushev.RESTful_service.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersDtoToEntityMapper {
    Users userDtoToEntity(CreateUserRequest createUserRequest);

    UserResponse userEntityToDto(Users users);

}
