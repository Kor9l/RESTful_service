package by.ushev.restful_service.validation;


import by.ushev.restful_service.dto.request.CreateCarOfferRequest;
import by.ushev.restful_service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class NewCarOfferValidator implements Validator {

    private final BrandRepository brandRepository;
    private final FuelRepository fuelRepository;
    private final GearBoxRepository gearBoxRepository;
    private final ModelRepository modelRepository;
    private final CityRepository cityRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CreateCarOfferRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CreateCarOfferRequest createCarOfferRequest =(CreateCarOfferRequest) o;

        if(!brandRepository.existsByName(createCarOfferRequest.getBrandName())){
            errors.rejectValue("brandName","","This brand not found");
        }
        if(!modelRepository.existsByName(createCarOfferRequest.getModelName())){
            errors.rejectValue("modelName","","This model not found");
        }
        if(!fuelRepository.existsByType(createCarOfferRequest.getFuelType())){
            errors.rejectValue("fuelType","","This fuel type not found");
        }
        if(!gearBoxRepository.existsByType(createCarOfferRequest.getGearBoxType())){
            errors.rejectValue("gearBoxType","","This gear box type not found");
        }
        if(!cityRepository.existsByName(createCarOfferRequest.getCityName())){
            errors.rejectValue("cityName","","This city not found");
        }


    }
}
