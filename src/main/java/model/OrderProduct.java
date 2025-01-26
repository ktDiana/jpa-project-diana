package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_products")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne  // несколько продуктов в одном заказе (Many Products - One Order)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne  // несколько продуктов заказа к 1 продукту (можно заказать несколько раз, Many Products - One Product)
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

}