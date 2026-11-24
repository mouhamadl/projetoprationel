package com.cours.projetoprationel.Repository;


import com.cours.projetoprationel.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
