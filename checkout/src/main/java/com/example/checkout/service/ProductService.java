package com.example.checkout.service;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.checkout.model.dto.Product;
import com.example.checkout.repository.FeignProductRepository;


@Service
public class ProductService implements IProductService{
    private FeignProductRepository feignProductRepository;

    Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(FeignProductRepository feignProductRepository) {
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    @CircuitBreaker(name = "product", fallbackMethod = "getProductFallbackMethod")
    @Retry(name="product")
    public Product getProduct(String id) {
        log.info("< ---- Intentando obtener info del producto con ID:" + id);
        return feignProductRepository.getProductById(id, false);
    }

    public Product getProductFallbackMethod(String id, CallNotPermittedException exception){
        log.error("----------------------   CircuitBreaker en estado Open   --------------------");
        return new Product();
    }

}
