package by.ushev.RESTful_service.mapper;

import by.ushev.RESTful_service.domain.CarOffer;
import by.ushev.RESTful_service.dto.request.CreateCarOfferRequest;
import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarOfferDtoToEntityMapper {
    CarOffer carOfferDtoToEntity (CreateCarOfferRequest createCarOfferRequest);
    CarOfferResponse carEntityToDto (CarOffer carOffer);

}
