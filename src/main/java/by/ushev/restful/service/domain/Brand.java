package by.ushev.restful.service.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@EqualsAndHashCode(of = "name")
@ToString(of = {"name"})
@Entity
@Getter
@Table(name = "brand")
public class Brand {

    @Id
    private String name;

    public Brand(String name) {
        this.name = name;
    }

}
