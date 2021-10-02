package by.ushev.RESTful_service.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(of = "name")
@ToString(of = {"name"})
@Entity
@Getter
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;


    public Brand(String name) {
        this.name = name;
    }
}
