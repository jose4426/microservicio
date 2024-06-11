package com.example.microservicio_demo.mapper;

import com.example.microservicio_demo.dtos.ProductRequest;
import com.example.microservicio_demo.dtos.ProductResponse;
import com.example.microservicio_demo.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T09:56:26-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public List<ProductResponse> entityToResponses(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( product.size() );
        for ( Product product1 : product ) {
            list.add( entityToResponse( product1 ) );
        }

        return list;
    }

    @Override
    public Product requestToEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( request.getId() );
        product.name( request.getName() );
        product.price( request.getPrice() );

        return product.build();
    }

    @Override
    public ProductResponse entityToResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse.ProductResponseBuilder productResponse = ProductResponse.builder();

        productResponse.id( product.getId() );
        productResponse.name( product.getName() );
        productResponse.price( product.getPrice() );

        return productResponse.build();
    }
}
