package dev.davidpereira.statuspages.repository;

import dev.davidpereira.statuspages.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
