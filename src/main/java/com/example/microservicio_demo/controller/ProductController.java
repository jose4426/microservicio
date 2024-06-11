package com.example.microservicio_demo.controller;

import com.example.microservicio_demo.dtos.ProductRequest;
import com.example.microservicio_demo.dtos.ProductResponse;
import com.example.microservicio_demo.dtos.UserRequest;
import com.example.microservicio_demo.dtos.UserResponse;
import com.example.microservicio_demo.service.ProductServ;
import com.example.microservicio_demo.service.UserServ;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    public ProductServ service;
    @Autowired
    public UserServ userServ;

    @GetMapping("/lista")
    public ResponseEntity<List<ProductResponse>> list() {
        List<ProductResponse> list = service.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> insert(@RequestBody ProductRequest request) {
        ProductResponse product = service.save(request);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ProductResponse> deleteById(@PathVariable("id") Long id) {
        if (!service.existById(id))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable("id") Long id) {
        if (!service.existById(id))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        ProductResponse product = service.findById(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }
   /* @PutMapping("/update/{request}")
    public  ResponseEntity<ProductResponse> update(@RequestBody ProductRequest request) {
        ProductResponse product = service.update(request);
        return new ResponseEntity(product, HttpStatus.OK);
    }*/

    @GetMapping("/listas")
    public ResponseEntity<List<UserResponse>> lists() {
        List<UserResponse> list = userServ.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponse> insertUser(@RequestBody UserRequest request) {
        UserResponse user = userServ.save(request);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}