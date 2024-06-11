package com.example.microservicio_demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    @JsonProperty("id")

    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")

    private Double price;
}
