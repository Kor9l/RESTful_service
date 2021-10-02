package by.ushev.RESTful_service.service.impl;

import by.ushev.RESTful_service.domain.CarOffer;
import by.ushev.RESTful_service.dto.request.CreateCarOfferRequest;
import by.ushev.RESTful_service.dto.request.SearchCarOfferRequest;
import by.ushev.RESTful_service.dto.request.UpdateCarOfferRequest;
import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import by.ushev.RESTful_service.mapper.CarOfferDtoToEntityMapper;
import by.ushev.RESTful_service.repository.CarOfferRepository;
import by.ushev.RESTful_service.security.UserPrincipal;
import by.ushev.RESTful_service.service.CarOfferService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarOfferServiceImpl implements CarOfferService {
        private final CarOfferRepository carOfferRepository;
        private final CarOfferDtoToEntityMapper carOfferDtoToEntityMapper;


    @Override
    public CarOfferResponse getById(Integer id) {
        CarOffer carOffer = carOfferRepository.getById(id);
        return carOfferDtoToEntityMapper.carEntityToDto(carOffer);
    }

    @Override
    public void deleteById(Integer id) {
        CarOffer carOffer = carOfferRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Car offer with id:" + id+" not found."));
        carOffer.setDelete(true);
        carOfferRepository.save(carOffer);

    }

    @Override
    public void create(UserPrincipal userPrincipal, CreateCarOfferRequest createCarOfferRequest) {
        CarOffer carOffer = carOfferDtoToEntityMapper.carOfferDtoToEntity(createCarOfferRequest);
        carOffer.setSellerId(userPrincipal.getId());
        carOffer.setDelete(false);

    }

    @Override
    public Page<CarOfferResponse> search(SearchCarOfferRequest searchCarOfferRequest, Pageable pageable) {
        List<CarOfferResponse> result = new ArrayList<>();
        if (searchCarOfferRequest.getBrandId()== null && searchCarOfferRequest.getCityId()== null){
            result = carOfferRepository.findAllByDelete(false,pageable).stream()
                    .map(carOfferDtoToEntityMapper::carEntityToDto).collect(Collectors.toList());
        }
        return new PageImpl<>(result);
    }

    @Override
    public CarOfferResponse update(UserPrincipal userPrincipal, UpdateCarOfferRequest updateCarOfferRequest) {
        CarOffer carOffer = carOfferRepository.findById(updateCarOfferRequest.getId())
                .orElseThrow(()-> new EntityNotFoundException("Car offer with id:"+updateCarOfferRequest.getId()+" not found."));
        carOffer.setBrandId(updateCarOfferRequest.getBrandId());
        carOffer.setCityId(updateCarOfferRequest.getCityId());
        carOffer.setDescription(updateCarOfferRequest.getDescription());
        carOffer.setSellerId(userPrincipal.getId());
        carOffer.setFuelId(updateCarOfferRequest.getFuelId());
        carOffer.setGearBoxId(updateCarOfferRequest.getGearBoxId());
        carOffer.setYear(updateCarOfferRequest.getYear());
        carOffer.setMileage(updateCarOfferRequest.getMileage());
        carOffer.setPrice(updateCarOfferRequest.getPrice());
        carOffer.setModelId(updateCarOfferRequest.getModelId());
        carOfferRepository.save(carOffer);
        return carOfferDtoToEntityMapper.carEntityToDto(carOffer);
    }
}
