package webshop.backend.repository;

import webshop.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Extends JpaRepository, such that we can do CRUD operations on the User entity
// <User> represents the entity and <Long> represents the datatype of the primary key
public interface UserRepository extends JpaRepository<User, Long> {
    // Chaining JPA keywords to create a query
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html:
    // "The JPA module supports defining a query manually as a String or having
    // it being derived from the method name"
    Optional<User> findByUsername(String username);
}
