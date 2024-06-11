package com.example.microservicio_demo.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private Long id;
    private String name;
    private Double price;
}
