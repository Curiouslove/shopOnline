package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.payload.request.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    void updateProductTest(){

        assertThat(productService.findById(110L).getName()).isEqualTo("luxury chair");

        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("egyptian mat");

        Product product = productService.updateProduct(110L, productRequest);
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("egyptian mat");

    }
}
