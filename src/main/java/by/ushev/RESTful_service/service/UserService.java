package by.ushev.RESTful_service.service;

import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import by.ushev.RESTful_service.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserResponse> search(Pageable pageable);
}
