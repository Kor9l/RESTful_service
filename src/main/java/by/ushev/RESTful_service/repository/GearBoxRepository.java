package by.ushev.RESTful_service.repository;

import by.ushev.RESTful_service.domain.GearBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GearBoxRepository extends JpaRepository<GearBox, Integer> {
    Optional<GearBox> findByType(String type);
}
