package com.inventory.smart_inventory.repository;

import com.inventory.smart_inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findBySkuCode(String sku);
}
