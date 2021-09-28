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

    @Column(nullable = false)
    private Integer sellerId;

    @Column(nullable = false)
    private Integer brandId;

    @Column(nullable = false)
    private Integer modelId;

    @Column(nullable = false)
    private Integer gearBoxId;

    @Column(nullable = false)
    private Integer fuelId;

    @Column(nullable = false)
    private Integer cityId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer mileage;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Boolean delete;

    @ManyToOne
    @JoinColumn(name = "sellerId", nullable = false, updatable = false, insertable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false, updatable = false, insertable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "modelId", nullable = false, updatable = false, insertable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "fuelId", nullable = false, updatable = false, insertable = false)
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name = "cityId", nullable = false, updatable = false, insertable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "gearBoxID", nullable = false, updatable = false, insertable = false)
    private GearBox gearBox;

}
