package by.ushev.RESTful_service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
public class GearBox {

    @Id
    private String type;

/*    @OneToMany(mappedBy = "gearBox")
    private Set<CarOffer> carOffers;*/
}
