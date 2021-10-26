package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.payload.request.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    List<Product> saveAll(List<Product> products);
    List<Product> findAll();
    Product findById(Long id);
    void deleteById(Long id);
    Product updateProduct(Long id, ProductRequest productRequest);
}
