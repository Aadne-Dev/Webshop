package webshop.backend.repository;

import webshop.backend.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

    boolean existsByProductname(String productname);
}
