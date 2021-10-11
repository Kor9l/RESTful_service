package by.ushev.restful_service.repository;

import by.ushev.restful_service.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> findByName(String brand);
    boolean existsByName(String name);
}
