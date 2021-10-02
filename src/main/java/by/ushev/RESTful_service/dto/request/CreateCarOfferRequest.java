package by.ushev.RESTful_service.dto.request;

import lombok.Data;

@Data
public class CreateCarOfferRequest {
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
