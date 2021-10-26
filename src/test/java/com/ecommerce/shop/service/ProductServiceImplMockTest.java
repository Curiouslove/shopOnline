package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import com.ecommerce.shop.payload.request.ProductRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplMockTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productServiceImpl;

    Product product;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
        MockitoAnnotations.openMocks(this);

        List<String> imageUrl = new ArrayList<>(List.of("image1, image2"));

        product =  new Product();
        product.setId(1L);
        product.setName("product 1");
        product.setDetails("details");
        product.setPrice(12.00);
        product.setCurrency(Currency.NGN);
        product.setImageUrl(imageUrl);
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveProductMockTest(){
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void updateProduct(){

        ProductRequest productRequest =  new ProductRequest();
        productRequest.setName("test product");

//        System.out.println(productServiceImpl.findById(1L));
        when(productRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(product));
        Product updatedProduct = productServiceImpl.updateProduct(1L, productRequest);
        System.out.println(updatedProduct);

        assertThat(updatedProduct.getId()).isEqualTo(product.getId());
    }



}