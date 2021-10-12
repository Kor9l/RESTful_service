package by.ushev.restful.service.service.impl;

import by.ushev.restful.service.domain.CarOffer;
import by.ushev.restful.service.dto.response.CarOfferResponse;
import by.ushev.restful.service.mapper.CarOfferDtoToEntityMapper;
import by.ushev.restful.service.repository.*;
import by.ushev.restful.service.security.UserPrincipal;
import by.ushev.restful.service.service.CarOfferService;
import by.ushev.restful.service.dto.request.CreateCarOfferRequest;
import by.ushev.restful.service.dto.request.SearchCarOfferRequest;
import by.ushev.restful.service.dto.request.UpdateCarOfferRequest;
import by.ushev.restful.service.enums.Role;
import by.ushev.restful.service.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class CarOfferServiceImpl implements CarOfferService {
    private final CarOfferRepository carOfferRepository;
    private final CarOfferDtoToEntityMapper carOfferDtoToEntityMapper;
    private final BrandRepository brandRepository;
    private final FuelRepository fuelRepository;
    private final GearBoxRepository gearBoxRepository;
    private final ModelRepository modelRepository;
    private final CityRepository cityRepository;


    @Override
    public CarOfferResponse getById(Integer id) {
        CarOffer carOffer = carOfferRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car offer with id:" + id + " not found."));
        return carOfferDtoToEntityMapper.carEntityToDto(carOffer);
    }

    @Override
    public boolean deleteById(Integer id) {
        CarOffer carOffer = carOfferRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car offer with id:" + id + " not found."));
        carOffer.setDelete(true);
        carOfferRepository.save(carOffer);
        return true;

    }

    @Override
    public void create(UserPrincipal userPrincipal, CreateCarOfferRequest createCarOfferRequest) {
        CarOffer carOffer = carOfferDtoToEntityMapper.carOfferDtoToEntity(createCarOfferRequest);
        carOffer.setSellerFullName(userPrincipal.getUsername());
        carOffer.setDelete(false);
        carOfferRepository.save(carOffer);

    }

    @Override
    public Page<CarOffer> search(UserPrincipal user, String brand, String model, SearchCarOfferRequest searchCarOfferRequest, Pageable pageable) {
        if (user.getRole().equals(Role.ROLE_ADMIN)) {
            if (brand.isEmpty() && model.isEmpty()) {
                return carOfferRepository.findAll(pageable);
            } else if (!brand.isEmpty() && model.isEmpty()) {
                return carOfferRepository.findAllByBrandName(brand, pageable);
            } else if (brand.isEmpty() && !model.isEmpty()) {
                return carOfferRepository.findAllByModelName(model, pageable);
            }
            return carOfferRepository.findCarOfferByBrandNameAndModelName(brand, model, pageable);
        } else {
            if (brand.isEmpty() && model.isEmpty()) {
                return carOfferRepository.findAllByDeleteFalse(pageable);
            } else if (!brand.isEmpty() && model.isEmpty()) {
                return carOfferRepository.findAllByBrandNameAndDeleteFalse(brand, pageable);
            } else if (brand.isEmpty() && !model.isEmpty()) {
                return carOfferRepository.findAllByModelNameAndDeleteFalse(model, pageable);
            }
            return carOfferRepository.findCarOfferByBrandNameAndModelNameAndDeleteFalse(brand, model, pageable);
        }


    }

    @Override
    public CarOfferResponse update(Integer id, UserPrincipal userPrincipal, UpdateCarOfferRequest updateCarOfferRequest) {
        CarOffer carOffer = carOfferRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car offer with id:" + id + " not found."));

        carOffer.setBrandName(updateCarOfferRequest.getBrandName());
        carOffer.setCityName(updateCarOfferRequest.getCityName());
        carOffer.setDescription(updateCarOfferRequest.getDescription());
        carOffer.setSellerFullName(userPrincipal.getUsername());
        carOffer.setFuelType(updateCarOfferRequest.getFuelType());
        carOffer.setGearBoxType(updateCarOfferRequest.getGearBoxType());
        carOffer.setYear(updateCarOfferRequest.getYear());
        carOffer.setMileage(updateCarOfferRequest.getMileage());
        carOffer.setPrice(updateCarOfferRequest.getPrice());
        carOffer.setModelName(updateCarOfferRequest.getModelName());
        carOfferRepository.save(carOffer);
        return carOfferDtoToEntityMapper.carEntityToDto(carOffer);
    }



}
