package by.ushev.restful_service.repository;

import by.ushev.restful_service.domain.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Integer> {

    Optional<Fuel> findByType(String type);

    boolean existsByType(String type);
}
