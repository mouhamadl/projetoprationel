package com.cours.projetoprationel.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double prix;
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore // <-- Ajoute cette ligne
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}