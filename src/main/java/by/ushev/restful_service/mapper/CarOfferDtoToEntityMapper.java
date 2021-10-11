package by.ushev.restful_service.mapper;

import by.ushev.restful_service.domain.CarOffer;
import by.ushev.restful_service.dto.request.CreateCarOfferRequest;
import by.ushev.restful_service.dto.response.CarOfferResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarOfferDtoToEntityMapper {
    CarOffer carOfferDtoToEntity (CreateCarOfferRequest createCarOfferRequestDto);
    CarOfferResponse carEntityToDto (CarOffer carOffer);

}
