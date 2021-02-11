package com.groupeonepoint.abrahime.eshopping.controllers;

import com.groupeonepoint.abrahime.eshopping.models.Product;
import com.groupeonepoint.abrahime.eshopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/products?sort=productName")
    public ResponseEntity<List<Product>> getAllProductSortedByName(){
        return ResponseEntity.ok().body(productService.getAllProductSortedByName());
    }

    @GetMapping("/products?sort=productPrice")
    public ResponseEntity<List<Product>> getAllProductSortedByPrice(){
        return ResponseEntity.ok().body(productService.getAllProductSortedByPrice());
    }

    @GetMapping("/products?sort=productWeight")
    public ResponseEntity<List<Product>> getAllProductSortedByWeight(){
        return ResponseEntity.ok().body(productService.getAllProductSortedByWeight());
    }

    @GetMapping("/products?sort=productWeight,productName&sort=Price")
    public ResponseEntity<List<Product>> getAllProductGroupBySort(){
        return ResponseEntity.ok().body(productService.getAllProductGroupBySort());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(this.productService.createProduct(product));

    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
        product.setProductId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id){
        this.productService.deleteProduct(id);
        //return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
        return HttpStatus.OK;
    }
}
