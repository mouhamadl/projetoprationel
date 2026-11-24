package com.cours.projetoprationel.Controller;


import com.cours.projetoprationel.Entity.Order;
import com.cours.projetoprationel.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order passerCommande(
            @RequestParam Long clientId,
            @RequestParam List<Long> productIds) {

        return orderService.creerCommande(clientId, productIds);
    }
}