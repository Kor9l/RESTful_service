package by.ushev.RESTful_service.repository;

import by.ushev.RESTful_service.domain.CarOffer;
import by.ushev.RESTful_service.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
    Page<Users> findAll( Pageable pageable);
}
