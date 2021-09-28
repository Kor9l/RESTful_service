package by.ushev.RESTful_service.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarOfferResponse {
    private Integer id;
    private Integer sellerId;
    private Integer brandId;
    private Integer modelId;
    private Integer gearBoxId;
    private Integer fuelId;
    private Integer cityId;
    private String description;
    private Integer year;
    private Integer mileage;
    private Float price;
}
