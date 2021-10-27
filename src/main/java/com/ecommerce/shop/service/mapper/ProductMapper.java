package com.ecommerce.shop.service.mapper;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.payload.request.ProductRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToProduct(ProductRequest productRequest, @MappingTarget Product product);
}
