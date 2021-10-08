package by.ushev.RESTful_service.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
