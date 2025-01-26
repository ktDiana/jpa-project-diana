package model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "categories")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @OneToMany(mappedBy = "category")
    List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    List<Option> options = new ArrayList<>();
}
