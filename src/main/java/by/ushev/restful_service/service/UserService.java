package by.ushev.restful_service.service;

import by.ushev.restful_service.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserResponse> search(Pageable pageable);
}
