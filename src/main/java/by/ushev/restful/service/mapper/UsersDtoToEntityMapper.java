package by.ushev.restful.service.mapper;

import by.ushev.restful.service.dto.request.CreateUserRequest;
import by.ushev.restful.service.domain.Users;
import by.ushev.restful.service.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersDtoToEntityMapper {
    Users userDtoToEntity(CreateUserRequest createUserRequest);

    UserResponse userEntityToDto(Users users);

}
