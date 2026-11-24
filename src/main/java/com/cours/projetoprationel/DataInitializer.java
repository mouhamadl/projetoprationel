package com.cours.projetoprationel;




import com.cours.projetoprationel.Entity.Client;
import com.cours.projetoprationel.Entity.Product;
import com.cours.projetoprationel.Repository.ClientRepository;
import com.cours.projetoprationel.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository, ProductRepository productRepository) {
        return args -> {
            // Créer un client s'il n'y en a pas
            if (clientRepository.count() == 0) {
                Client client = new Client();
                client.setFirstname("Jean");
                client.setLastname("Dupont");
                client.setEmail("jean@mail.com");
                clientRepository.save(client);
                System.out.println("Client créé !");
            }

            // Créer des produits s'il n'y en a pas
            if (productRepository.count() == 0) {
                Product p1 = new Product();
                p1.setName("Clavier");
                p1.setPrice(50.0);
                productRepository.save(p1);

                Product p2 = new Product();
                p2.setName("Souris");
                p2.setPrice(25.0);
                productRepository.save(p2);
                System.out.println("Produits créés !");
            }
        };
    }
}