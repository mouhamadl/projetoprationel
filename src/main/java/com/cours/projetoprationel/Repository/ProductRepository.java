package com.cours.projetoprationel.Repository;


import com.cours.projetoprationel.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}