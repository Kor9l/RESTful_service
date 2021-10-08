package by.ushev.RESTful_service.service.impl;

import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import by.ushev.RESTful_service.dto.response.UserResponse;
import by.ushev.RESTful_service.mapper.UsersDtoToEntityMapper;
import by.ushev.RESTful_service.repository.UserRepository;
import by.ushev.RESTful_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
