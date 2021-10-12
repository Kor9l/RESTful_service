package by.ushev.restful.service.controller;

import by.ushev.restful.service.repository.UserRepository;
import by.ushev.restful.service.domain.Users;
import by.ushev.restful.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/user")
public class UserAdminController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public Page<Users> findAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC)
                                       Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
