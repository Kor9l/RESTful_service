package by.ushev.restful_service.repository;

import by.ushev.restful_service.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Optional<Brand> findByName(String brand);

    boolean existsByName(String name);
}
