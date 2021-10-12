package by.ushev.restful.service.repository;

import by.ushev.restful.service.domain.CarOffer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOfferRepository extends JpaRepository<CarOffer, Integer> {

    Page<CarOffer> findAll(Pageable pageable);

    Page<CarOffer> findAllByBrandName(String brandName, Pageable pageable);

    Page<CarOffer> findAllByModelName(String modelName, Pageable pageable);

    Page<CarOffer> findCarOfferByBrandNameAndModelName(String brandName, String modelName, Pageable pageable);

    Page<CarOffer> findAllByDeleteFalse(Pageable pageable);

    Page<CarOffer> findAllByBrandNameAndDeleteFalse(String brandName, Pageable pageable);

    Page<CarOffer> findAllByModelNameAndDeleteFalse(String modelName, Pageable pageable);

    Page<CarOffer> findCarOfferByBrandNameAndModelNameAndDeleteFalse(String brandName, String modelName, Pageable pageable);

}
