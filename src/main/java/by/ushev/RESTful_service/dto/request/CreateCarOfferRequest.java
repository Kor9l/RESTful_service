package by.ushev.RESTful_service.dto.request;

import lombok.Data;

@Data
public class CreateCarOfferRequest {
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
