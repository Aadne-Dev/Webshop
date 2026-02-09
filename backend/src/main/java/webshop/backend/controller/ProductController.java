package webshop.backend.controller;

import webshop.backend.entity.Products;
import webshop.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Products createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(
                request.productname(),
                request.price()
        );
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }
}
