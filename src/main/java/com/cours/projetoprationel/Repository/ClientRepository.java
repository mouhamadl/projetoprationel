package com.cours.projetoprationel.Repository;

import com.cours.projetoprationel.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}