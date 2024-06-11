package com.example.microservicio_demo.service;

import com.example.microservicio_demo.dtos.ProductRequest;
import com.example.microservicio_demo.dtos.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServ {
    List<ProductResponse> findAll();
    ProductResponse save(ProductRequest request);
    ProductResponse findById(Long id);
    //ProductResponse update(ProductRequest request);
    Long delete(Long id);
    boolean existById(Long id);


}
