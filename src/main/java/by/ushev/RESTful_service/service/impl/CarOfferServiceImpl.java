package by.ushev.RESTful_service.service.impl;

import by.ushev.RESTful_service.domain.Brand;
import by.ushev.RESTful_service.domain.CarOffer;
import by.ushev.RESTful_service.domain.GearBox;
import by.ushev.RESTful_service.dto.request.CreateCarOfferRequest;
import by.ushev.RESTful_service.dto.request.SearchCarOfferRequest;
import by.ushev.RESTful_service.dto.request.UpdateCarOfferRequest;
import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import by.ushev.RESTful_service.enums.Role;
import by.ushev.RESTful_service.mapper.CarOfferDtoToEntityMapper;
import by.ushev.RESTful_service.repository.*;
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
    private final BrandRepository brandRepository;
    private final FuelRepository fuelRepository;
    private final GearBoxRepository gearBoxRepository;
    private final ModelRepository modelRepository;



    @Override
    public CarOfferResponse getById(Integer id) {
        CarOffer carOffer = carOfferRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car offer with id:" + id + " not found."));
        return carOfferDtoToEntityMapper.carEntityToDto(carOffer);
    }

    @Override
    public void deleteById(Integer id) {
        CarOffer carOffer = carOfferRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car offer with id:" + id + " not found."));
        carOffer.setDelete(true);
        carOfferRepository.save(carOffer);

    }

    @Override
    public void create(UserPrincipal userPrincipal, CreateCarOfferRequest createCarOfferRequest) {
        CarOffer carOffer = carOfferDtoToEntityMapper.carOfferDtoToEntity(createCarOfferRequest);
        carOffer.setSellerFullName(userPrincipal.getUsername());
        carOffer.setDelete(false);
        validation(carOffer);
        carOfferRepository.save(carOffer);

    }

    @Override
    public Page<CarOffer> search(UserPrincipal user,String brand,String model, SearchCarOfferRequest searchCarOfferRequest, Pageable pageable) {
        if (user.getRole().equals(Role.ROLE_ADMIN)){
            if (brand.isEmpty()&&model.isEmpty()){
                return carOfferRepository.findAll (pageable);
            }
            else if (!brand.isEmpty()&&model.isEmpty()){
                return carOfferRepository.findAllByBrandName (brand,pageable);
            }
            else if (brand.isEmpty()&&!model.isEmpty()){
                return carOfferRepository.findAllByModelName (model,pageable);
            }
            return carOfferRepository.findCarOfferByBrandNameAndModelName(brand,model,pageable);
        }
        else {
            if (brand.isEmpty()&&model.isEmpty()){
                return carOfferRepository.findAllByDeleteFalse(pageable);
            }
            else if (!brand.isEmpty()&&model.isEmpty()){
                return carOfferRepository.findAllByBrandNameAndDeleteFalse(brand,pageable);
            }
            else if (brand.isEmpty()&&!model.isEmpty()){
                return carOfferRepository.findAllByModelNameAndDeleteFalse(model,pageable);
            }
            return carOfferRepository.findCarOfferByBrandNameAndModelNameAndDeleteFalse (brand,model,pageable);
        }


    }

    @Override
    public CarOfferResponse update(Integer id,UserPrincipal userPrincipal, UpdateCarOfferRequest updateCarOfferRequest) {
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
            validation(carOffer);
            carOfferRepository.save(carOffer);
            return carOfferDtoToEntityMapper.carEntityToDto(carOffer);
    }


    private void validation(CarOffer carOffer)throws EntityNotFoundException {
        brandRepository.findByName(carOffer.getBrandName())
                .orElseThrow(() -> new EntityNotFoundException("Brand with name:" + carOffer.getBrandName() + " not found."));
        fuelRepository.findByType(carOffer.getFuelType())
                .orElseThrow(() -> new EntityNotFoundException("Fuel type:" + carOffer.getFuelType() + " not found."));
        gearBoxRepository.findByType(carOffer.getGearBoxType())
                .orElseThrow(() -> new EntityNotFoundException("Gear box type:" + carOffer.getGearBoxType() + " not found."));
        modelRepository.findByName(carOffer.getModelName())
                .orElseThrow(() -> new EntityNotFoundException("Model with name:" + carOffer.getModelName() + " not found."));

    }
}
