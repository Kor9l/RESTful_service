package by.ushev.restful_service.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateCarOfferRequest {

    private String sellerFullName;

    @NotNull(message ="Car must have brand")
    private String brandName;

    @NotNull(message ="Car must have model")
    private String modelName;

    @NotNull(message ="Car must have gear box type")
    private String gearBoxType;

    @NotNull(message ="Car must have fuel type")
    private String fuelType;

    @NotNull(message ="Car offer must have city")
    private String cityName;

    @NotNull(message ="Car offer must have description")
    private String description;

    @NotNull(message ="Car must have year")
    private Integer year;

    @NotNull(message ="Car must have mileage")
    private Integer mileage;

    @NotNull(message ="Car offer must have price")
    private Float price;




}
