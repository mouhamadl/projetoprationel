package com.cours.projetoprationel.Service;

import com.cours.projetoprationel.Entity.*;
import com.cours.projetoprationel.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public Order creerCommande(Long clientId, List<Long> productIds) {
        Client client = clientRepository.findById(clientId).orElseThrow();

        Order order = new Order();
        order.setClient(client);
        order.setDate(LocalDateTime.now());

        List<OrderDetail> details = new ArrayList<>();
        double totalPrix = 0;
        int totalQte = 0;

        for (Long prodId : productIds) {
            Product p = productRepository.findById(prodId).orElseThrow();

            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(p);
            detail.setQuantite(1);
            detail.setPrix(p.getPrice() * 1);

            details.add(detail);
            totalPrix += detail.getPrix();
            totalQte += 1;
        }

        order.setOrderDetails(details);
        order.setTotalPrice(totalPrix);
        order.setQuantity(totalQte);

        return orderRepository.save(order);
    }
}