package by.ushev.restful_service.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarOfferResponse {

    private Integer id;

    private String sellerFullName;

    private String brandName;

    private String modelName;

    private String gearBoxType;

    private String fuelType;

    private String cityName;

    private String description;

    private Integer year;

    private Integer mileage;

    private Float price;


}
