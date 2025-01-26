package model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "reviews")

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne  // несколько отзывов от 1 пользователя (Many Reviews - One User)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne  // несколько отзывов на 1 продукт (Many Reviews - One Product)
    @JoinColumn(name = "product_id")
    Product product;

    @Enumerated(EnumType.STRING)
    ReviewStatus published;

    int rate;

    String text;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
