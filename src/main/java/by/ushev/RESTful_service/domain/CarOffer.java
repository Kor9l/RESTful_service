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

    private Integer sellerId;

    @Column(name = "brand_id")
    private Integer brandId;

    private Integer modelId;

    private Integer gearBoxId;

    private Integer fuelId;

    private Integer cityId;

    private String description;

    private Integer year;

    private Integer mileage;

    private Float price;

    private Boolean delete;

/*    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false, updatable = false, insertable = false)
    private Users users;*/

    @JoinColumn(updatable = false, insertable = false)
    @ManyToOne
    private Brand brand;
/*
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false, updatable = false, insertable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "fuel_id", nullable = false, updatable = false, insertable = false)
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, updatable = false, insertable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "gear_box_id", nullable = false, updatable = false, insertable = false)
    private GearBox gearBox;*/

}
