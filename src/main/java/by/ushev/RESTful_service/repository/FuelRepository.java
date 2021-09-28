package by.ushev.RESTful_service.repository;

import by.ushev.RESTful_service.domain.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Integer> {
}
