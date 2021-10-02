package by.ushev.RESTful_service.repository;

import by.ushev.RESTful_service.domain.CarOffer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOfferRepository extends JpaRepository<CarOffer, Integer> {
    Page<CarOffer> findAllByDelete(boolean delete, Pageable pageable);
}
