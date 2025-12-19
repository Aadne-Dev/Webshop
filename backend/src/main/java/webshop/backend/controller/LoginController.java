package webshop.backend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webshop.backend.entity.User;
import webshop.backend.repository.UserRepository;

import java.util.Map;
import java.util.Optional;

@RestController
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Must listen to /api/ since front end requests are routed there
    @PostMapping("/api/login")
    // Using "Map<String, String> body" to access the JSON object from the POST request
    public String login(@RequestBody Map<String, String> body) {
        System.out.println("LOGIN ENDPOINT HIT");
        String username = body.get("username");
        String password = body.get("password");

        // Optional avoids NullPointerException
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return "Login successful for user: " + username;
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }

    }
}
