package com.example.checkout.service;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import com.example.checkout.model.dto.Product;
import com.example.checkout.repository.FeingProductRepository;



@Service
public class ProductService implements IProductService{
    private FeingProductRepository feingProductRepository;


    public ProductService(FeingProductRepository feingProductRepository) {
        this.feingProductRepository = feingProductRepository;
    }

    @Override
    @CircuitBreaker(name = "product", fallbackMethod = "")
    public Product getProduct(String id) {
        return feingProductRepository.getProductById(id);
    }

    public Product getProductFallbackMethod(String id, CallNotPermittedException exception){

        return null;
    }

}
