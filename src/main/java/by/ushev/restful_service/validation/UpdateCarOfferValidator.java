package by.ushev.restful_service.validation;


import by.ushev.restful_service.dto.request.CreateCarOfferRequest;
import by.ushev.restful_service.dto.request.UpdateCarOfferRequest;
import by.ushev.restful_service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UpdateCarOfferValidator implements Validator {

    private final BrandRepository brandRepository;
    private final FuelRepository fuelRepository;
    private final GearBoxRepository gearBoxRepository;
    private final ModelRepository modelRepository;
    private final CityRepository cityRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return UpdateCarOfferRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UpdateCarOfferRequest updateCarOfferRequest =(UpdateCarOfferRequest) o;

        if(!brandRepository.existsByName(updateCarOfferRequest.getBrandName())){
            errors.rejectValue("brandName","","This brand not found");
        }
        if(!modelRepository.existsByName(updateCarOfferRequest.getModelName())){
            errors.rejectValue("modelName","","This model not found");
        }
        if(!fuelRepository.existsByType(updateCarOfferRequest.getFuelType())){
            errors.rejectValue("fuelType","","This fuel type not found");
        }
        if(!gearBoxRepository.existsByType(updateCarOfferRequest.getGearBoxType())){
            errors.rejectValue("gearBoxType","","This gear box type not found");
        }
        if(!cityRepository.existsByName(updateCarOfferRequest.getCityName())){
            errors.rejectValue("cityName","","This city not found");
        }


    }
}
