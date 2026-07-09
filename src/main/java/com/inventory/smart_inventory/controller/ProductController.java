package com.inventory.smart_inventory.controller;

import com.inventory.smart_inventory.entity.Product;
import com.inventory.smart_inventory.repository.ProductRepository;
import com.inventory.smart_inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product saveProduct = productService.createProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>>  getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


}
