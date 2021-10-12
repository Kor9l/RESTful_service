package by.ushev.restful.service.service.impl;

import by.ushev.restful.service.dto.response.UserResponse;
import by.ushev.restful.service.mapper.UsersDtoToEntityMapper;
import by.ushev.restful.service.repository.UserRepository;
import by.ushev.restful.service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UsersDtoToEntityMapper usersDtoToEntityMapper;


    @Override
    public Page<UserResponse> search(Pageable pageable) {
        List<UserResponse> result;
        result = userRepository.findAll(pageable).stream()
                .map(usersDtoToEntityMapper::userEntityToDto).collect(Collectors.toList());
        return new PageImpl<>(result);
    }
}
