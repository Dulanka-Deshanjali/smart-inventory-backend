package com.inventory.smart_inventory.controller;

import com.inventory.smart_inventory.entity.Category;
import com.inventory.smart_inventory.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category saveCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(saveCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

}
