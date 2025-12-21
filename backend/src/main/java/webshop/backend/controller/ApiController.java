package webshop.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // matches the Angular proxy
public class ApiController {

    @GetMapping("/health")
    public String health() {
        return "200";
    }
}
