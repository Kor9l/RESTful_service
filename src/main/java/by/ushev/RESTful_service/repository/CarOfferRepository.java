package by.ushev.RESTful_service.repository;

import by.ushev.RESTful_service.domain.CarOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOfferRepository extends JpaRepository<CarOffer, Integer> {
}
