package com.example.microservicio_demo.service;

import com.example.microservicio_demo.model.Datos;
import com.example.microservicio_demo.repository.DatosRepository;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service

public class ExcelService {
    @Autowired
    private DatosRepository datosRepository;

    public void cargarDatosDesdeExcel(MultipartFile file) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            boolean isFirstRow = true;
            for (Row row : sheet) {
                if (row == null) {
                    continue;
                }

                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }
                String columna1 = getCellValue(row.getCell(0));
                String columna2 = getCellValue(row.getCell(1));
                String columna3 = getCellValue(row.getCell(2));

                if (columna1 != null && !columna1.trim().isEmpty() &&
                        columna2 != null && !columna2.trim().isEmpty() &&
                        columna3 != null && !columna3.trim().isEmpty()) {

                    Datos datos = new Datos();
                    datos.setColumna1(columna1);
                    datos.setColumna2(columna2);
                    datos.setColumna3(columna3);

                    datosRepository.save(datos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error al procesar el archivo Excel", e);
        }
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return null;
        }
    }
}
