package by.ushev.RESTful_service.service.impl;

import by.ushev.RESTful_service.dto.request.CreateCarOfferRequest;
import by.ushev.RESTful_service.dto.request.SearchCarOfferRequest;
import by.ushev.RESTful_service.dto.request.UpdateCarOfferRequest;
import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import by.ushev.RESTful_service.mapper.CarOfferDtoToEntityMapper;
import by.ushev.RESTful_service.repository.CarOfferRepository;
import by.ushev.RESTful_service.security.UserPrincipal;
import by.ushev.RESTful_service.service.CarOfferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarOfferServiceImpl implements CarOfferService {
        private final CarOfferRepository carOfferRepository;
        private final CarOfferDtoToEntityMapper carOfferDtoToEntityMapper;


    @Override
    public CarOfferResponse getById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void create(UserPrincipal userPrincipal, CreateCarOfferRequest createCarOfferRequest) {

    }

    @Override
    public List<CarOfferResponse> search(SearchCarOfferRequest searchCarOfferRequest) {
        return null;
    }

    @Override
    public CarOfferResponse update(UserPrincipal userPrincipal, UpdateCarOfferRequest updateCarOfferRequest) {
        return null;
    }
}
