package webshop.backend.service;

import webshop.backend.entity.Products;
import webshop.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Products createProduct(String name, Integer price) {
        if (productRepository.existsByProductname(name)) {
            throw new IllegalArgumentException("Product already exists");
        }

        Products products = new Products(name, price);
        return productRepository.save(products);
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
