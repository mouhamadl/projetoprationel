package com.cours.projetoprationel.Repository;


import com.cours.projetoprationel.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}