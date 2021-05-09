package dev.davidpereira.statuspages.repository;

import dev.davidpereira.statuspages.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
