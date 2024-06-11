package com.example.microservicio_demo.service;

import org.springframework.stereotype.Service;



@Service
public class OdsService {/*
    @Autowired
    private DatosRepository datosRepository;

    public void cargarDatosDesdeOds(MultipartFile file) throws IOException {
        try {
            OdfSpreadsheetDocument spreadsheetDocument = OdfSpreadsheetDocument.loadDocument(file.getInputStream());
            TableAlgorithmAttribute table = spreadsheetDocument.(0);

            for (int i = 0; i < table.getRowCount(); i++) {
                Datos datos = new Datos();
                datos.setColumna1(table.getCellByPosition(0, i).getStringValue());
                datos.setColumna2(table.getCellByPosition(1, i).getStringValue());
                datos.setColumna3(table.getCellByPosition(2, i).getStringValue());

                datosRepository.save(datos);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error al procesar el archivo ODS", e);
        }
    }*/

}
