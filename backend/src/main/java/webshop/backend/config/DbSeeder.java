package webshop.backend.config;

import webshop.backend.entity.Products;
import webshop.backend.entity.User;
import webshop.backend.repository.ProductRepository;
import webshop.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DbSeeder {

    @Bean
    CommandLineRunner seedDatabase(
            UserRepository userRepository,
            ProductRepository productRepository
    ) {
        return args -> {

            // ---- USERS ----
            if (userRepository.count() == 0) {
                userRepository.save(new User(
                        "testuser",
                        "testpassword",
                        "testrole"
                ));
            }

            // ---- PRODUCTS ----
            if (productRepository.count() == 0) {
                productRepository.saveAll(
                        List.of(
                                new Products("Balding cream", 899),
                                new Products("The horse from Bojack Horseman", 499),
                                new Products("Toothpaste", 2999)
                        )
                );
            }
        };
    }
}
