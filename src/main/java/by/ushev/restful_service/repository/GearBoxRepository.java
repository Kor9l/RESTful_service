package by.ushev.restful_service.repository;

import by.ushev.restful_service.domain.GearBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GearBoxRepository extends JpaRepository<GearBox, Integer> {
    Optional<GearBox> findByType(String type);
    boolean existsByType(String type);
}
