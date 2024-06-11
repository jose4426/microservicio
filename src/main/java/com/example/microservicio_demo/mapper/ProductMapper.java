package com.example.microservicio_demo.mapper;

import com.example.microservicio_demo.dtos.ProductRequest;
import com.example.microservicio_demo.dtos.ProductResponse;
import com.example.microservicio_demo.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductResponse> entityToResponses(List<Product> product);
    Product requestToEntity(ProductRequest request);
    ProductResponse entityToResponse(Product product);

}
