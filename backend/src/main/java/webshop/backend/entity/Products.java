package webshop.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String productname;

    @Column(nullable = false)
    private Integer price;

    public Products() {}

    public Products(String productname, Integer price) {
        this.productname = productname;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getProductname() {
        return productname;
    }

    public Integer getPrice() {
        return price;
    }
}
