package by.ushev.RESTful_service.repository;

import by.ushev.RESTful_service.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Override
    Optional<Brand> findById(Integer integer);

    Optional<Brand> findByName(String brand);
}
