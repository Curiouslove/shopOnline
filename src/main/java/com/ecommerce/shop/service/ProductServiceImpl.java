package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import com.ecommerce.shop.payload.request.ProductRequest;
import com.ecommerce.shop.service.mapper.ProductMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id"));
    }

    @Override
    public void deleteById(Long id) {
       productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, ProductRequest productRequest) throws NullPointerException{
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){

            Product product1 = product.get();
            productMapper.mapDtoToProduct(productRequest, product1);
            return productRepository.save(product1);
        }else{
            throw new NullPointerException("Product is Null");
        }

    }
}
