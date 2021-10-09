package by.ushev.RESTful_service.service;


import by.ushev.RESTful_service.domain.CarOffer;
import by.ushev.RESTful_service.dto.request.CreateCarOfferRequest;
import by.ushev.RESTful_service.dto.request.SearchCarOfferRequest;
import by.ushev.RESTful_service.dto.request.UpdateCarOfferRequest;
import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import by.ushev.RESTful_service.security.UserPrincipal;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarOfferService {
    CarOfferResponse getById(Integer id);
    void deleteById(Integer id);
    void create(UserPrincipal userPrincipal, CreateCarOfferRequest createCarOfferRequest);
    Page<CarOffer> search(UserPrincipal user,String brand,String model,  SearchCarOfferRequest searchCarOfferRequest, Pageable pageable);
    CarOfferResponse update( Integer id, UserPrincipal userPrincipal,UpdateCarOfferRequest updateCarOfferRequest);

}
