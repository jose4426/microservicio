package com.example.microservicio_demo.controller;

import com.example.microservicio_demo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            excelService.cargarDatosDesdeExcel(file);
            return "Datos cargados exitosamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al cargar datos: " + e.getMessage();
        }
    }
}
