package by.ushev.RESTful_service.service;


import by.ushev.RESTful_service.dto.request.CreateCarOfferRequest;
import by.ushev.RESTful_service.dto.request.SearchCarOfferRequest;
import by.ushev.RESTful_service.dto.request.UpdateCarOfferRequest;
import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import by.ushev.RESTful_service.security.UserPrincipal;

import java.util.List;

public interface CarOfferService {
    CarOfferResponse getById(Integer id);
    void deleteById(Integer id);
    void create(UserPrincipal userPrincipal, CreateCarOfferRequest createCarOfferRequest);
    List<CarOfferResponse> search(SearchCarOfferRequest searchCarOfferRequest);
    CarOfferResponse update(UserPrincipal userPrincipal, UpdateCarOfferRequest updateCarOfferRequest);
}
