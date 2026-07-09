package com.inventory.smart_inventory.service;

import com.inventory.smart_inventory.entity.Category;
import com.inventory.smart_inventory.entity.Product;
import com.inventory.smart_inventory.repository.CategoryRepository;
import com.inventory.smart_inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product createProduct(Product product){
       Long categoryId = product.getCategory().getId();

       Category category =categoryRepository.findById(categoryId).
               orElseThrow(() -> new RuntimeException("There is no Category For This ID: " + categoryId));


       product.setCategory(category);
       return  productRepository.save(product);

    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long Id){
        return productRepository.findById(Id)
                .orElseThrow(()-> new RuntimeException("There is no Product in this ID: "+ Id));
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }




}
