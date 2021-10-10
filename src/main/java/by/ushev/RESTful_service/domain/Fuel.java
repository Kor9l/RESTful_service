package by.ushev.RESTful_service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Data
public class Fuel {

    @Id
    private String type;

}
