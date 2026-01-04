package webshop.backend.config;

import webshop.backend.entity.User;
import webshop.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbSeeder {

    // CommandLineRunner makes this execute on runtime
    @Bean
    CommandLineRunner seedUsers(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new User(
                        "testuser",
                        "testpassword",
                        "testrole"
                ));
            }
        };
    }
}
