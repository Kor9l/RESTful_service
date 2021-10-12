package by.ushev.restful.service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import by.ushev.restful.service.domain.CarOffer;
import by.ushev.restful.service.dto.response.CarOfferResponse;
import by.ushev.restful.service.mapper.CarOfferDtoToEntityMapper;
import by.ushev.restful.service.repository.CarOfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CarOfferServiceImplTest {

    @Mock
    private CarOfferRepository carOfferRepository;

    @Mock
    private CarOfferDtoToEntityMapper carOfferDtoToEntityMapper;

    @InjectMocks
            private CarOfferServiceImpl carOfferService;
    CarOfferResponse carOfferResponse;
    CarOffer carOffer;

    private static final int CAROFFER_ID = 1;

    @BeforeEach
    public void setup() {
        carOffer = CarOffer.builder()
                .id(CAROFFER_ID)
                .brandName("Audi")
                .cityName("Minsk")
                .description("Best offer")
                .delete(false)
                .gearBoxType("Auto")
                .fuelType("Diesel")
                .modelName("TT")
                .mileage(100100)
                .price((float)99999.1)
                .sellerFullName("Jhon")
                .build();

        carOfferResponse = CarOfferResponse.builder()
                .id(CAROFFER_ID)
                .brandName("Audi")
                .cityName("Minsk")
                .description("Best offer")
                .gearBoxType("Auto")
                .fuelType("Diesel")
                .modelName("TT")
                .mileage(100100)
                .price((float)99999.1)
                .sellerFullName("Jhon")
                .build();
    }

    @Test
    public void getByIdShouldReturnFilledDto() {
        doReturn(Optional.of(carOffer)).when(carOfferRepository).findById(CAROFFER_ID);

        doReturn(carOfferResponse).when(carOfferDtoToEntityMapper).carEntityToDto(carOffer);

        CarOfferResponse response = carOfferService.getById(CAROFFER_ID);

        verify(carOfferRepository, times(1)).findById(CAROFFER_ID);
        verify(carOfferDtoToEntityMapper, times(1)).carEntityToDto(carOffer);

        assertEquals(response, carOfferResponse);

    }

    @Test
    public void getByIdShouldThrowExceptionTest() {
        assertThrows(
                EntityNotFoundException.class,
                () ->carOfferService.getById(CAROFFER_ID));
        verify(carOfferRepository, times(1)).findById(CAROFFER_ID);
        verify(carOfferDtoToEntityMapper, times(0))
                .carEntityToDto(any(CarOffer.class));
    }

}