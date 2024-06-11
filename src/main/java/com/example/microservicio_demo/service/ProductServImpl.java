package com.example.microservicio_demo.service;

import com.example.microservicio_demo.dtos.ProductRequest;
import com.example.microservicio_demo.dtos.ProductResponse;
import com.example.microservicio_demo.mapper.ProductMapper;
import com.example.microservicio_demo.model.Product;
import com.example.microservicio_demo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductServImpl implements ProductServ {
    private  ProductRepository repository;
    private  ProductMapper mapper;

    @Override
    public List<ProductResponse> findAll() {

        List<Product> product = repository.findAll();
        //return  mapper.entityToResponses(product);


        return product.stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse save(ProductRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("el request no suede ser null");
        }
        Product product = repository.save(mapper.requestToEntity(request));
        return mapper.entityToResponse(product);
    }

    @Override
    public ProductResponse findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("el id no puede ser null");
        }
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return mapper.entityToResponse(product.get());

        } else {
            throw new EntityNotFoundException("el producto con el id" + id + "no fue encontrado");
        }
    }

       /* @Override
        public ProductResponse update(ProductRequest request) {
                if (request.getId() == null){
                    throw new IllegalArgumentException("el id no puede ser null");
                }
            Product productExist = repository.findById(request.getId()).orElseThrow(() -> new EntityNotFoundException("product no encontrado"));
            productExist.setName(request.getName());
            productExist.setPrice(request.getPrice());

            Product productUpdate = repository.save(productExist);
            return mapper.entityToResponse(productUpdate);
        }*/

    @Override
    public Long delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("el id no puede ser null");
        }
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("No fue encontrado el id " + id);
        }
        repository.deleteById(id);
        return id;
    }

    @Override
    public boolean existById(Long id) {
        return repository.existsById(id);
    }

    ProductResponse entityToResponse(Product product){

        final ProductResponse response = new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()

        );
        return response;
    }/*
    Product requestToEntity (ProductRequest request){

        return new  Product(
                request.getId(),
                request.getName(),
                request.getPrice()

        );
    }*/

}
