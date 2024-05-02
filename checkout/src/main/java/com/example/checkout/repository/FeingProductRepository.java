package com.example.checkout.repository;

import com.example.checkout.configuration.LoadBalancerConfiguration;
import com.example.checkout.model.dto.Product;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="products", url="http://localhost:8080")
// @LoadBalancerClient(value = "products-service", configuration = LoadBalancerConfiguration.class)//  lo sacamos para poder configurar el weight en lugar del Robin
public interface FeingProductRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    Product getProductById(@RequestParam String id, @RequestParam Boolean throwError);
}
