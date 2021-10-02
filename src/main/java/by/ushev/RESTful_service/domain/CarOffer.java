package by.ushev.RESTful_service.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
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
/*
   @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false, updatable = false, insertable = false)
    private Users users;

    @JoinColumn(updatable = false, insertable = false)
    @ManyToOne
    private Brand brand;

    @ManyToOne
    @JoinColumn( nullable = false, updatable = false, insertable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false, insertable = false)
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false, insertable = false)
    private City city;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false, insertable = false)
    private GearBox gearBox;*/

}
