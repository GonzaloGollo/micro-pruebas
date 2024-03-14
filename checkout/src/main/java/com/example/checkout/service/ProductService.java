package com.example.checkout.service;

import com.example.checkout.model.dto.Product;
import com.example.checkout.repository.FeingProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService{
    private FeingProductRepository feingProductRepository;


    public ProductService(FeingProductRepository feingProductRepository) {
        this.feingProductRepository = feingProductRepository;
    }

    @Override
    public Product getProduct(String id) {
        return feingProductRepository.getProductById(id);
    }
}
