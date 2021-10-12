package by.ushev.restful.service.service;


import by.ushev.restful.service.dto.response.CarOfferResponse;
import by.ushev.restful.service.security.UserPrincipal;
import by.ushev.restful.service.domain.CarOffer;
import by.ushev.restful.service.dto.request.CreateCarOfferRequest;
import by.ushev.restful.service.dto.request.SearchCarOfferRequest;
import by.ushev.restful.service.dto.request.UpdateCarOfferRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarOfferService {
    CarOfferResponse getById(Integer id);

    boolean deleteById(Integer id);

    void create(UserPrincipal userPrincipal, CreateCarOfferRequest createCarOfferRequest);

    Page<CarOffer> search(UserPrincipal user, String brand, String model, SearchCarOfferRequest searchCarOfferRequest, Pageable pageable);

    CarOfferResponse update(Integer id, UserPrincipal userPrincipal, UpdateCarOfferRequest updateCarOfferRequest);

}
