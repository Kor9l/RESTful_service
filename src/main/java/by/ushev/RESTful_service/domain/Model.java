package by.ushev.RESTful_service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
public class Model {

    @Id
    private String name;
}
