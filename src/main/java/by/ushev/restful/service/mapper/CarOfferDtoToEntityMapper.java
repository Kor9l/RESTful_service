package by.ushev.restful.service.mapper;

import by.ushev.restful.service.dto.response.CarOfferResponse;
import by.ushev.restful.service.domain.CarOffer;
import by.ushev.restful.service.dto.request.CreateCarOfferRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarOfferDtoToEntityMapper {
    CarOffer carOfferDtoToEntity (CreateCarOfferRequest createCarOfferRequestDto);
    CarOfferResponse carEntityToDto (CarOffer carOffer);

}
