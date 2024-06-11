package com.example.microservicio_demo.repository;

import com.example.microservicio_demo.model.Datos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosRepository extends JpaRepository<Datos, Long> {
}
