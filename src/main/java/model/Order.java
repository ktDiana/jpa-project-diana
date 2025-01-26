package model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne // несколько заказов у одного пользователя (Many Orders - One User)
    @JoinColumn(name = "user_id")
    User user;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    String address;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @OneToMany(mappedBy = "order")  // один заказ содержит несколько продуктов (One Order - Many Products)
    List<OrderProduct> orderProducts = new ArrayList<>();
}
