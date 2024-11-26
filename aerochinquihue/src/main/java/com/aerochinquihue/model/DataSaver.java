package com.aerochinquihue.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataSaver {
    public static void saveToFile(AssistantData assistantData, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(assistantData.getNombre()+","+ assistantData.getApellidos()+","+ 
            assistantData.getTelefono()+","+ assistantData.getRut()+","+ assistantData.getDireccion()+","+ 
            assistantData.getDestino()+","+ assistantData.getOpcionRadio());
            writer.newLine();
        System.out.println("Datos guardados exitosamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}