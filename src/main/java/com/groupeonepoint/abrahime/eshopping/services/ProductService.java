package com.groupeonepoint.abrahime.eshopping.services;

import com.groupeonepoint.abrahime.eshopping.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProduct();
    List<Product> getAllProductSortedByName();
    List<Product> getAllProductSortedByPrice();
    List<Product> getAllProductSortedByWeight();
    List<Product> getAllProductGroupBySort();
    Product getProductById(long productId);
    void deleteProduct(long productId);

}
