package by.ushev.restful.service.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class CarOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


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

    private Boolean delete;


}
