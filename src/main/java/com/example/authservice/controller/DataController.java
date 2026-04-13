package com.example.authservice.controller;

import com.example.authservice.dto.*;
import com.example.authservice.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping("/product-types")
    public ResponseEntity<List<ProductTypeResponse>> getAllProductTypes() {
        return ResponseEntity.ok(dataService.getAllProductTypes());
    }

    @GetMapping("/product-types/{id}")
    public ResponseEntity<ProductTypeResponse> getProductTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(dataService.getProductTypeById(id));
    }

    @GetMapping("/brands")
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        return ResponseEntity.ok(dataService.getAllBrands());
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable Long id) {
        return ResponseEntity.ok(dataService.getBrandById(id));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(dataService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(dataService.getProductById(id));
    }

    @GetMapping("/products/by-type/{productTypeId}")
    public ResponseEntity<List<ProductResponse>> getProductsByType(@PathVariable Long productTypeId) {
        return ResponseEntity.ok(dataService.getProductsByType(productTypeId));
    }

    @GetMapping("/products/sale-off")
    public ResponseEntity<List<ProductResponse>> getSaleOffProducts() {
        return ResponseEntity.ok(dataService.getSaleOffProducts());
    }

    @GetMapping("/product-details/{id}")
    public ResponseEntity<ProductDetailResponse> getProductDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(dataService.getProductDetailById(id));
    }
}
