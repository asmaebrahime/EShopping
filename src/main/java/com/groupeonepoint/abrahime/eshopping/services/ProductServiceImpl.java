package com.groupeonepoint.abrahime.eshopping.services;

import com.groupeonepoint.abrahime.eshopping.exceptions.ResourceNotFoundException;
import com.groupeonepoint.abrahime.eshopping.models.Product;
import com.groupeonepoint.abrahime.eshopping.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product){
        Optional<Product> productDb= this.productRepository.findById(product.getProductId());
        if(productDb.isPresent()){
            Product productUpdate= productDb.get();
            productUpdate.setProductId(product.getProductId());
            productUpdate.setProductName(product.getProductName());
            productUpdate.setProductPrice(product.getProductPrice());
            productUpdate.setProductWeight(product.getProductWeight());
            productRepository.save(productUpdate);
            return productUpdate;
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+product.getProductId());
        }
    }

    @Override
    public List<Product> getAllProduct(){
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductSortedByName(){
        Sort sortName = Sort.by("productName");
        return this.productRepository.findAll(sortName);

    }

    @Override
    public List<Product> getAllProductSortedByPrice(){
        Sort sortPrice = Sort.by("productPrice");
        return this.productRepository.findAll(sortPrice);
    }

    @Override
    public List<Product> getAllProductSortedByWeight(){
        Sort sortWeight = Sort.by("productWeight");
        return this.productRepository.findAll(sortWeight);
    }

    @Override
    public List<Product> getAllProductGroupBySort(){
        Sort weightSort = Sort.by("productWeight");
        Sort priceSort = Sort.by("productPrice");
        Sort nameSort = Sort.by("productName");
        Sort groupBySort=weightSort.and(priceSort).and(nameSort);
        return this.productRepository.findAll(groupBySort);
    }
    @Override
    public Product getProductById(long productId){
        Optional<Product> productDb= this.productRepository.findById(productId);
        if(productDb.isPresent()){
            return productDb.get();
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+productId);
        }
    }

    @Override
    public void deleteProduct(long productId){
        Optional<Product> productDb= this.productRepository.findById(productId);
        if(productDb.isPresent()){
            this.productRepository.delete(productDb.get());
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+productId);
        }
    }

    
}
